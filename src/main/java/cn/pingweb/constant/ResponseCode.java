package cn.pingweb.constant;

/**
 * @author zhuyuping
 * @date 2018/1/11.
 */
public enum ResponseCode {
    SUCCESS(0, "success"),
    FAIL(-1, "fail"),
    ERRO(-2, "erro");
    private int code;
    private String msg;
    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
