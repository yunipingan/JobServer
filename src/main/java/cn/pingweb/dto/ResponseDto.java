package cn.pingweb.dto;

import cn.pingweb.constant.ResponseCode;

/**
 * @author zhuyuping
 * @date 2018/1/11.
 */
public class ResponseDto {
    protected Object data;
    protected Integer code;
    protected String msg;

    public ResponseDto(Object data,Integer code,  String msg) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public ResponseDto(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseDto success() {
        return new ResponseDto(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg());
    }

    public static ResponseDto success(Object data) {
        return new ResponseDto(data, ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg());
    }

    public static ResponseDto fail() {
        return new ResponseDto(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMsg());
    }

    public static ResponseDto erro() {
        return new ResponseDto(ResponseCode.ERRO.getCode(), ResponseCode.ERRO.getMsg());
    }

}
