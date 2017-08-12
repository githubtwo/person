package com.test.controller;

import com.test.common.ServerResponse;
import com.test.service.IMovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/11.
 */
@RestController
@RequestMapping("/movie/")
public class MovieController {

    @Resource
    private IMovieService iMovieService;

    @RequestMapping("getMaoYanMovie")
    public ServerResponse getMaoyanMovie() throws IOException {
        return iMovieService.getMaoYanMovie();
    }
}
