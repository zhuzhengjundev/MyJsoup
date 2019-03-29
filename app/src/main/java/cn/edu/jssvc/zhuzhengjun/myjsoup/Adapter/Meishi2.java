package cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter;

public class Meishi2 {

    private String img,      //菜的图片
                caiming,     //菜名
                name;        //网名

    public Meishi2(String img, String caiming, String name) {
        this.img = img;
        this.caiming = caiming;
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCaiming() {
        return caiming;
    }

    public void setCaiming(String caiming) {
        this.caiming = caiming;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
