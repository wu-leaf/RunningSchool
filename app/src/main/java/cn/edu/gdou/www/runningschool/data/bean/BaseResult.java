package cn.edu.gdou.www.runningschool.data.bean;

/**
 * Created by Veyron on 2017/9/26.
 * Function：用于 retrofit 网络访问后结果的存储
 */

public class BaseResult {

    private int success;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

}
