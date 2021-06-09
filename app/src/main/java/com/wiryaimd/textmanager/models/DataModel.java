package com.wiryaimd.textmanager.models;

import javax.inject.Inject;

public class DataModel {

    private String title;

    @Inject
    public DataModel(String title) {
        this.title = title;
        System.out.println("anjaeee gilee " + title);
    }

    public String test(){
        return title;
    }
}
