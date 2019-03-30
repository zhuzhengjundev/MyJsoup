package cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter;

public class Love {

    private String image,    //图片
                title,        //标题
                zuozhe,       //作者
                time;         //时间

    public Love(String image, String title, String zuozhe, String time) {
        this.image = image;
        this.title = title;
        this.zuozhe = zuozhe;
        this.time = time;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getZuozhe() {
        return zuozhe;
    }

    public void setZuozhe(String zuozhe) {
        this.zuozhe = zuozhe;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
