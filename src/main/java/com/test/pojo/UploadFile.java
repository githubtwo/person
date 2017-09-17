package com.test.pojo;

import java.util.Date;

public class UploadFile {
    private Integer id;

    private String filename;

    private Double filesize;

    private Date createTime;

    public UploadFile(Integer id, String filename, Double filesize, Date createTime) {
        this.id = id;
        this.filename = filename;
        this.filesize = filesize;
        this.createTime = createTime;
    }
    public UploadFile( String filename, Double filesize) {

        this.filename = filename;
        this.filesize = filesize;
    }

    public UploadFile() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Double getFilesize() {
        return filesize;
    }

    public void setFilesize(Double filesize) {
        this.filesize = filesize;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}