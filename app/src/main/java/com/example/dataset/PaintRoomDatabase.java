package com.example.dataset;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Paint.class},version = 1,exportSchema = false)
public abstract class PaintRoomDatabase extends RoomDatabase {


    public abstract PaintDao paintDao();
    public static volatile PaintRoomDatabase INSTANCE;
    public static final  int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors
            .newFixedThreadPool(NUMBER_OF_THREADS);

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                PaintDao dao = INSTANCE.paintDao();
                dao.deleteAll();

                Paint paint = new Paint("fist","fist",
                        "fist","first","fifst");
                dao.insert(paint);

            });
        }
    };
    static PaintRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (PaintRoomDatabase.class){
                if (INSTANCE ==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PaintRoomDatabase.class, "paint_Database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }
}
