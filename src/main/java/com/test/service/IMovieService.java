package com.test.service;

import com.test.common.ServerResponse;

import java.io.IOException;

/**
 * Created by Administrator on 2017/8/11.
 */
public interface IMovieService {
    ServerResponse getMaoYanMovie() throws IOException;
}
