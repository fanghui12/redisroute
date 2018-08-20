package com.chanjet.entity;

public class AgentInfo {
    private String agent_id;
    private String agent_name;
    private String zmk;

    public String getAgent_id() {
        return agent_id;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public String getZmk() {
        return zmk;
    }

    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public void setZmk(String zmk) {
        this.zmk = zmk;
    }

    @Override
    public String toString() {
        return "AgentInfo{" +
                "agent_id='" + agent_id + '\'' +
                ", agent_name='" + agent_name + '\'' +
                ", zmk='" + zmk + '\'' +
                '}';
    }
}
