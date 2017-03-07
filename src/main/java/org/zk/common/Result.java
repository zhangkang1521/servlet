package org.zk.common;

/**
 * Created by zhangkang on 2017/3/7.
 */
public class Result {
    private boolean success = true;
    private String msg = "操作成功";

    public static Result SUCCESS = new Result();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
