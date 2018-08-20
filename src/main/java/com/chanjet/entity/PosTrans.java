package com.chanjet.entity;

public class PosTrans {
    private String trans_code;
    private String trans_date;
    private String trans_time;

    @Override
    public String toString() {
        return "PosTrans{" +
                "trans_code='" + trans_code + '\'' +
                ", trans_date='" + trans_date + '\'' +
                ", trans_time='" + trans_time + '\'' +
                ", merch_id='" + merch_id + '\'' +
                ", term_id='" + term_id + '\'' +
                ", resp_code='" + resp_code + '\'' +
                ", resp_desc='" + resp_desc + '\'' +
                '}';
    }

    public void setTrans_code(String trans_code) {
        this.trans_code = trans_code;
    }

    public void setTrans_date(String trans_date) {
        this.trans_date = trans_date;
    }

    public void setTrans_time(String trans_time) {
        this.trans_time = trans_time;
    }

    public void setMerch_id(String merch_id) {
        this.merch_id = merch_id;
    }

    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }

    public void setResp_code(String resp_code) {
        this.resp_code = resp_code;
    }

    public void setResp_desc(String resp_desc) {
        this.resp_desc = resp_desc;
    }

    private String merch_id;
    private String term_id;
    private String resp_code;

    public String getTrans_code() {
        return trans_code;
    }

    public String getTrans_date() {
        return trans_date;
    }

    public String getTrans_time() {
        return trans_time;
    }

    public String getMerch_id() {
        return merch_id;
    }

    public String getTerm_id() {
        return term_id;
    }

    public String getResp_code() {
        return resp_code;
    }

    public String getResp_desc() {
        return resp_desc;
    }

    private String resp_desc;
}
