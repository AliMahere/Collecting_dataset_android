package com.example.dataset;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PaintDao {

    @Insert
    void insert(Paint paint);

    @Query("DELETE FROM paint_table")
    void deleteAll();

    @Query("SELECT * FROM paint_table ORDER BY id ASC")
    LiveData<List<Paint>> getAllData();
}
