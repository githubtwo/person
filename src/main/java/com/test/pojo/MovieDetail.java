package com.test.pojo;

/**
 * Created by Administrator on 2017/8/14.
 */
public class MovieDetail {

    private String name;
    private String type;
    private String area;
    private String time;
    private String introduce;
    private String mainActor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieDetail that = (MovieDetail) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (introduce != null ? !introduce.equals(that.introduce) : that.introduce != null) return false;
        return mainActor != null ? mainActor.equals(that.mainActor) : that.mainActor == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (introduce != null ? introduce.hashCode() : 0);
        result = 31 * result + (mainActor != null ? mainActor.hashCode() : 0);
        return result;
    }
}
