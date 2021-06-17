package com.wiryaimd.textmanager.db.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "data_model")
public class DataModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String text;
    private String category;
    private String date;

    public DataModel(String title, String text, String category, String date) {
        this.title = title;
        this.text = text;
        this.category = category;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String test(){
        return title;
    }
}
