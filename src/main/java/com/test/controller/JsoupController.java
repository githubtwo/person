package com.test.controller;

import com.google.common.collect.Lists;
import com.test.pojo.MovieInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */
public class JsoupController {

    private static List<MovieInfo> movieInfoList = Lists.newArrayList();

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://maoyan.com/").get();
        String title = doc.title();
       // System.out.println(title);
        Elements elements = doc.getElementsByClass("movie-list");//热映列表
        for(Element element : elements){
            Elements movie = element.getElementsByClass("movie-item");//单部电影信息
           // System.out.println(movie.toString());

            for(Element elementInfo:movie){
                MovieInfo movieInfo = new MovieInfo();
                Elements elements1 = elementInfo.getElementsByTag("a"); //a href
                movieInfo.setImgdetail(elementInfo.getElementsByTag("a").attr("href").toString());
               // System.out.println(elementInfo.getElementsByTag("a").attr("href").toString());
                Elements elements2 = elementInfo.getElementsByClass("movie-poster");
               // System.out.println(elementInfo.getElementsByClass("movie-title movie-title-padding").text());//获取html内容
                movieInfo.setName(elementInfo.getElementsByClass("movie-title movie-title-padding").text());
                if(movieInfo.getName().isEmpty()){
                    movieInfo.setName(elementInfo.getElementsByClass("movie-overlay movie-overlay-bg").text());
                }

               // System.out.println(elementInfo.getElementsByClass("movie-poster").get(0).getElementsByTag("img").get(1).attr("data-src"));//电影图片
                movieInfo.setImg(elementInfo.getElementsByClass("movie-poster").get(0).getElementsByTag("img").get(1).attr("data-src"));

               // System.out.println(elementInfo.getElementsByClass("active").attr("href"));
                movieInfo.setShopping(elementInfo.getElementsByClass("active").attr("href"));

                //System.out.println(elementInfo.getElementsByClass("integer").text() + elementInfo.getElementsByClass("fraction").text());
                movieInfo.setScore(elementInfo.getElementsByClass("integer").text() + elementInfo.getElementsByClass("fraction").text());

                //System.out.println(elementInfo.getElementsByClass("movie-ver").html());
                if(elementInfo.getElementsByClass("movie-ver").html().length() >0){
                    Elements elements3 = elementInfo.getElementsByClass("movie-ver");//获取电影类型 2d /3d
                    for(Element element1 : elements3){
                       // System.out.println(element1.getElementsByTag("i").attr("class"));
                         movieInfo.setMovieVar(element1.getElementsByTag("i").attr("class"));

                    }
                }
                movieInfoList.add(movieInfo);
              //  System.out.println(movieInfo.toString());
            }
            if(movieInfoList.size()==8){
                break;
            }
        }

    }

}
