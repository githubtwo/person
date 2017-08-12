package com.test.pojo;

/**
 * Created by Administrator on 2017/8/10.
 */
public class MovieInfo {
    private static final String baseUrl="http://maoyan.com";
    private String name;//片名
    private String img;//图像
    private String score;//评分
    private String movie_var;//影视类别 2D/3D
    private String imgDetail;//详情链接
    private String shopping;//立即购买

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMovie_var() {
        return movie_var;
    }

    public void setMovie_var(String movie_var) {
        this.movie_var = movie_var;
    }

    public String getImgDetail() {
        return imgDetail;
    }

    public void setImgDetail(String imgDetail) {
        this.imgDetail = imgDetail;
    }

    public String getShopping() {
        return shopping;
    }

    public void setShopping(String shopping) {
        this.shopping = shopping;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", score='" + score + '\'' +
                ", movie_var='" + movie_var + '\'' +
                ", imgDetail='" +"http://maoyan.com"+ imgDetail + '\'' +
                ", shopping='" + shopping + '\'' +
                '}';
    }
}
