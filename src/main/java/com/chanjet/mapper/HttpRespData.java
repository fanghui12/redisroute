package com.chanjet.mapper;

public class HttpRespData {
    private String resp_code;
    private String resp_desc;

    public String getResp_code() {
        return resp_code;
    }

    public String getResp_desc() {
        return resp_desc;
    }

    public void setResp_code(String resp_code) {
        this.resp_code = resp_code;
    }

    public void setResp_desc(String resp_desc) {
        this.resp_desc = resp_desc;
    }

    @Override
    public String toString() {
        return "HttpRespData{" +
                "resp_code='" + resp_code + '\'' +
                ", resp_desc='" + resp_desc + '\'' +
                '}';
    }
}
