package com.wiryaimd.textmanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// mirip kek buat model, ada getter, setter, constructor

/**
 * tag @Entity menandakan class tersebut adalah room atau bagian dari room
 *
 * room = model = data = sqlite
 * class ini termasuk membuat tabel
 *
 * hahay
 *
 * rdbms = menggunakan tabel dan columns
 */

@Entity(tableName = "document_table")
public class Documentdata {

    // room akan otomatis mengenerate column sesuai di bawah

    // primary key (wajib ada id)
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String text;

    // jika mau mengubah nama columnt VVV
    // @ColumnInfo(name = "ngontol_date")
    private String date;

    // id tidak dimasukan karena sudah auto generate
    public Documentdata(String title, String text, String date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    // hanya perlu setId aja karena autogenerate nya bisa jalan anjeng
    public void setId(int id) {
        this.id = id;
    }

    // getter yekan ykl

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }
}
