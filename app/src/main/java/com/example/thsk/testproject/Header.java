package com.example.thsk.testproject;

/**
 * Created by thsk on 18/02/2018.
 */

public class Header {

    private String headerTitle;
    private String type;

    public Header(String headerTitle) {
        this.headerTitle = headerTitle;
        this.type = "HEADER";
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
