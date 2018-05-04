package com.gdms.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 封装前端传过来的数据
 */
public class InData implements Serializable {

    private static final long serialVersionUID = 7754908913247118188L;    //序列化id用来验证版本的一致性

    /**
     * 请求参数的签名
     */
    private String sign;
    /**
     * 单行请求参数
     */
    private Map<String,Object> inmap;
    /**
     * 多行请求参数
     */
    private List<Map<String,Object>> inlist;

    public InData(String sign, Map<String, Object> inmap, List<Map<String, Object>> inlist) {
        this.sign = sign;
        this.inmap = inmap;
        this.inlist = inlist;
    }

    public InData() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Map<String, Object> getInmap() {
        return inmap;
    }

    public void setInmap(Map<String, Object> inmap) {
        this.inmap = inmap;
    }

    public List<Map<String, Object>> getInlist() {
        return inlist;
    }

    public void setInlist(List<Map<String, Object>> inlist) {
        this.inlist = inlist;
    }

    @Override
    public String toString() {
        return "InData{" +
                "sign='" + sign + '\'' +
                ", inmap=" + inmap +
                ", inlist=" + inlist +
                '}';
    }
}