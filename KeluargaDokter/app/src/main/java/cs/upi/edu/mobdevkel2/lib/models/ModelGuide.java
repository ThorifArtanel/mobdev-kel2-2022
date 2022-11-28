package cs.upi.edu.mobdevkel2.lib.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ModelGuide {

    @SerializedName("guide")
    @Expose
    private List<Guide> guide = null;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("status")
    @Expose
    private Integer status;

    public List<Guide> getGuide() {
        return guide;
    }

    public void setGuide(List<Guide> guide) {
        this.guide = guide;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
