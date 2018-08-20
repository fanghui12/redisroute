package com.chanjet.mapper;

public class Data {
    private String trans_code;
    private String trans_time;
    private String mobl_no;
    private String card_no;
    private String resp_code;
    private String resp_desc;
    private String sign;

    public String getTrans_code() {
        return trans_code;
    }

    public String getTrans_time() {
        return trans_time;
    }

    public void setTrans_code(String trans_code) {
        this.trans_code = trans_code;
    }

    public void setTrans_time(String trans_time) {
        this.trans_time = trans_time;
    }

    public String getMobl_no() {
        return mobl_no;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setMobl_no(String mobl_no) {
        this.mobl_no = mobl_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public void setResp_code(String resp_code) {
        this.resp_code = resp_code;
    }

    public void setResp_desc(String resp_desc) {
        this.resp_desc = resp_desc;
    }

    public String getResp_code() {
        return resp_code;
    }

    public String getResp_desc() {
        return resp_desc;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
