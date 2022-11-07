package cs.upi.edu.mobdevkel2;

public class DataGuide {
    int imageId;
    String title;
    String desc;
    String detail;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public DataGuide(int imageId, String title, String desc, String detail) {
        this.imageId = imageId;
        this.title = title;
        this.desc = desc;
        this.detail = detail;
    }
}
