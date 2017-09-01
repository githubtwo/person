package com.test.pojo;

public class MovieInfo {
    private Integer id;

    private String name;

    private String img;

    private String score;

    private String movieVar;

    private String imgdetail;

    private String shopping;

    public MovieInfo(Integer id, String name, String img, String score, String movieVar, String imgdetail, String shopping) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.score = score;
        this.movieVar = movieVar;
        this.imgdetail = imgdetail;
        this.shopping = shopping;
    }

    public MovieInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getMovieVar() {
        return movieVar;
    }

    public void setMovieVar(String movieVar) {
        this.movieVar = movieVar == null ? null : movieVar.trim();
    }

    public String getImgdetail() {
        return imgdetail;
    }

    public void setImgdetail(String imgdetail) {
        this.imgdetail = imgdetail == null ? null : imgdetail.trim();
    }

    public String getShopping() {
        return shopping;
    }

    public void setShopping(String shopping) {
        this.shopping = shopping == null ? null : shopping.trim();
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", score='" + score + '\'' +
                ", movieVar='" + movieVar + '\'' +
                ", imgdetail='" + imgdetail + '\'' +
                ", shopping='" + shopping + '\'' +
                '}';
    }


}