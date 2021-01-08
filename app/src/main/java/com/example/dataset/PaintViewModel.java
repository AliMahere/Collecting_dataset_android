package com.example.dataset;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PaintViewModel extends AndroidViewModel {

    private PaintRepository mRepository;

    private final LiveData<List<Paint>> mAllPaints;
    public PaintViewModel(@NonNull Application application) {
        super(application);
        mRepository = new PaintRepository(application);
        mAllPaints = mRepository.getAllPaints();
    }


    LiveData<List<Paint>> getAllPaints() { return mAllPaints; }

    public void insert(Paint Paint) { mRepository.insert(Paint); }
    public void deleteAll() { mRepository.deleteAll(); }
}
