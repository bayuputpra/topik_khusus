package com.TK.sonobudoyoyk;

public class report_user {
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String key;
    private String email;
    private String comment;

    public report_user(){

    }

    public report_user(String email, String comment){
        this.email = email;
        this.comment = comment;
    }
}
