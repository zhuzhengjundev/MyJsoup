package cn.edu.jssvc.zhuzhengjun.myjsoup.Adapter;

public class Meishi {

    private String image,    //图片
            title,            //标题
            author,           //作者
            material;         //原料

    public Meishi() {
    }

    public Meishi(String image, String title, String author, String material) {
        this.image = image;
        this.title = title;
        this.author = author;
        this.material = material;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
