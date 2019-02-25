package com.protal.pojo;

public class Cook {
    private Long id;

    private String cookname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCookname() {
        return cookname;
    }

    public void setCookname(String cookname) {
        this.cookname = cookname == null ? null : cookname.trim();
    }
}