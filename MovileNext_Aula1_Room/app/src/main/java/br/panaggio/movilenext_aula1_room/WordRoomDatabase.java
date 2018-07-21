package br.panaggio.movilenext_aula1_room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    private static WordRoomDatabase sInstance;

    public abstract WordDao wordDao();

    static WordRoomDatabase getDatabase(final Context context) {
        if (sInstance == null) {
            synchronized (WordRoomDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context,
                            WordRoomDatabase.class, "word_database")
                            .addCallback(sCallback).build();
                }
            }
        }

        return sInstance;
    }

    private static RoomDatabase.Callback sCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(sInstance).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final WordDao mWordDao;

        public PopulateDbAsync(WordRoomDatabase db) {
            mWordDao = db.wordDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mWordDao.insert(new Word("Android"));
            mWordDao.insert(new Word("Movile"));
            mWordDao.insert(new Word("Next"));
            return null;
        }
    }
}
