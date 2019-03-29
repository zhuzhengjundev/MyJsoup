package cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter;

public class Buzhou {

    private String image,     //左侧图片
                id,            //序号
                content;      //步骤内容

    public Buzhou(String image, String id, String content) {
        this.image = image;
        this.id = id;
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
