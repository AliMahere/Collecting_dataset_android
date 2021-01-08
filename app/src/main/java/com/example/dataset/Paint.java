package com.example.dataset;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "paint_table")
public class Paint {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String name;
    private String artist;
    private String year;
    private String notes;
    private String country;

    public Paint(String name, String artist, String year,  String country, @Nullable String notes) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.country = country;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getYear() {
        return year;
    }

    public String getNotes() {
        return notes;
    }

    public String getCountry() {
        return country;
    }
}
