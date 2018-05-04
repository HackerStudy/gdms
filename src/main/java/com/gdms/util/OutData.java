package com.gdms.util;

import java.io.Serializable;

public class OutData<T> implements Serializable {
    private static final long serialVersionUID = 8888873636260841895L;     //序列化id用来验证版本的一致性
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;

    private int code;

    public OutData(String msg, T data, int code) {
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    public OutData() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "OutData{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                ", code=" + code +
                '}';
    }

    public static <T> OutData<T> outData(String msg, T data,int code) {
        return new OutData<T>(msg,data, code);
    }
}
