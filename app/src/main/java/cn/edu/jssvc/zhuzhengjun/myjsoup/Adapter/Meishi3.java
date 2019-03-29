package cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter;

public class Meishi3 {

    private String image,        //图片
                    name,         //菜名
                    time,         //发布时间
                    peiliao,     //做法
                    liulan;       //浏览数

    public Meishi3(String image, String name, String time, String peiliao, String liulan) {
        this.image = image;
        this.name = name;
        this.time = time;
        this.peiliao = peiliao;
        this.liulan = liulan;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPeiliao() {
        return peiliao;
    }

    public void setPeiliao(String peiliao) {
        this.peiliao = peiliao;
    }

    public String getLiulan() {
        return liulan;
    }

    public void setLiulan(String liulan) {
        this.liulan = liulan;
    }
}
