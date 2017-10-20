package com.test.controller;

import com.google.common.collect.Maps;
import com.test.common.Const;
import com.test.common.ServerResponse;
import com.test.pojo.User;
import com.test.service.IFileService;
import com.test.util.PropertiesUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class FileController {

    @Resource
    private IFileService iFileService;

    @PostMapping("upload")
    public ServerResponse upload(HttpSession session, MultipartFile[] file, HttpServletRequest request){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录管理员");
//        }

        //if(iUserService.checkAdminRole(user).isSuccess()){
  /*      String path = request.getSession().getServletContext().getRealPath("upload");
        System.out.println(path + "    " + file.getSize());
        // String uploadUrl = path.substring(0,path.length()-5) + "upload/";
        String targetFileName = iFileService.upload(file,path);
        String url = PropertiesUtil.getProperty("ftp.server.http.prefix") + targetFileName;
        Map fileMap = Maps.newHashMap();
        fileMap.put("uri",targetFileName);
        fileMap.put("url",url);
*/
        return null;//ServerResponse.createBySuccess(fileMap);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
    }

    @GetMapping("getAllFile")
    public ServerResponse<List<String>> getAllFile(HttpServletResponse response){

        System.out.println(new Date());
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<String> list = iFileService.getAllFile();

        System.out.println(new Date());
        return ServerResponse.createBySuccess(list);
    }

    @GetMapping("downFile")
    public ServerResponse downFile(@RequestParam(value = "filename")String filename,HttpServletResponse response,HttpSession session){

        response.setHeader("Access-Control-Allow-Origin", "*");

        //设置文件MIME类型
        response.setContentType(session.getServletContext().getMimeType(filename));
        //设置Content-Disposition
        response.setHeader("Content-Disposition", "attachment;filename="+filename);
        //读取目标文件，通过response将目标文件写到客户端
        //获取目标文件的绝对路径
        String fullFileName = "D:\\ftpfile/" + filename;
        //System.out.println(fullFileName);

        try {
            //读取文件
            InputStream in = new FileInputStream(fullFileName);
            OutputStream out = response.getOutputStream();

            //写文件
            int b;
            while((b=in.read())!= -1)
            {
                out.write(b);
            }

            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        if(iFileService.downfile(filename)){
//            return ServerResponse.createBySuccessMessage("download successfully!");
//        }

         return ServerResponse.createByErrorMessage("download Fail!");
    }




}
