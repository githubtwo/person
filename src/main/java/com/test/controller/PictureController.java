package com.test.controller;

import com.test.common.Const;
import com.test.common.ServerResponse;
import com.test.pojo.User;
import com.test.service.IPictureService;
import com.test.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2017/8/3.
 */
@RestController
@RequestMapping("/picture/")
public class PictureController {
    @Resource
    private IUserService iUserService;
    @Resource
    private IPictureService iPictureService;

    @RequestMapping(value = "uploadPicture")
    public ServerResponse upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
        String url = request.getSession().getServletContext().getRealPath("/") ;
        String uploadUrl = url.substring(0,url.length()-5) + "upload/";
        String path = "D:/File/IdeaProjects/Personal/target/upload";
        System.out.println(path);
        String fileName = file.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(path);
        File targetFile = new File(uploadUrl, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ServerResponse.createBySuccess("添加成功",fileName);
    }

    /**
     * 更新用户头像
     * @param fileName
     * @param session
     * @return
     */
    @RequestMapping("/updateImg")
    public ServerResponse<String> updateUserImg(String fileName, HttpSession session) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user !=null){
            ServerResponse<String> userServerResponse  = iPictureService.updateUserImg(user.getId(),fileName,user.getUsername());
            return userServerResponse;
        }
        return ServerResponse.createByErrorMessage("用户未登录，无法更新头像");
    }


    @RequestMapping("/image")
    public Integer image(HttpServletRequest request,HttpServletResponse response, HttpSession session, String img) {

        String path = "D:/File/IdeaProjects/Personal/target/upload";
        String url = session.getServletContext().getRealPath("/") ;
        String uploadUrl = url.substring(0,url.length()-5) + "upload/";
        System.out.println("uploadUrl      "+uploadUrl);
        try {
            FileInputStream fis = new FileInputStream(uploadUrl + "/" + img);
            OutputStream os = response.getOutputStream();
            byte[] buffer = new byte[1024 * 8];
            int count;
            while ((count = fis.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
