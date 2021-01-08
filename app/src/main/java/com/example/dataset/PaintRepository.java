package com.example.dataset;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PaintRepository {
    private PaintDao mPaintDao;
    private LiveData<List<Paint>> mAllPaints;

    PaintRepository(Application application) {
        PaintRoomDatabase db = PaintRoomDatabase.getDatabase(application);
        mPaintDao = db.paintDao();
        mAllPaints = mPaintDao.getAllData();
    }
    LiveData<List<Paint>> getAllPaints(){
        return mAllPaints;
    }
    void insert(Paint paint){
        PaintRoomDatabase.databaseWriteExecutor.execute(() ->{
            mPaintDao.insert(paint);
        });
    }
    void deleteAll(){
        PaintRoomDatabase.databaseWriteExecutor.execute(() ->{
            mPaintDao.deleteAll();
        });
    }
}
