package com.amadurell.myapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = {Juego.class}, version = 1, exportSchema = false)

public abstract class AppBaseDeDatos extends RoomDatabase {

    private static volatile AppBaseDeDatos INSTANCE;
    static Executor executor = Executors.newSingleThreadExecutor();

    abstract App obtenerJuegosDao();

    public static AppBaseDeDatos getInstance(final Context context){
        if (INSTANCE == null){
            synchronized (AppBaseDeDatos.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppBaseDeDatos.class, "app.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(new Callback() {
                                @Override
                                public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
                                    super.onDestructiveMigration(db);
                                    insertarJuegosIniciales(INSTANCE.obtenerJuegosDao());
                                }

                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    insertarJuegosIniciales(INSTANCE.obtenerJuegosDao());
                                }
                            })

                            .build();
                }
            }
        }
        return INSTANCE;
    }

    @Dao
    interface App {

        @Insert
        void  insertarContingut(Juego juego);

        @Query("SELECT * FROM juego")
        LiveData<List<Juego>> obtenerJuegos();

        @Query("SELECT * FROM juego WHERE year > 2018")
        LiveData<List<Juego>> obtenerJuegosNuevos();

        @Query("SELECT * FROM juego WHERE year < 2018")
        LiveData<List<Juego>> obtenerJuegosPopulares();

    }

    static void insertarJuegosIniciales(App app){
        executor.execute(() -> {
            app.insertarContingut(new Juego("Rocket", "2019", "PC","file:///android_asset/S.jpg"));
            app.insertarContingut(new Juego("Genshin", "2019", "PC","file:///android_asset/S.jpg"));
            app.insertarContingut(new Juego("Valorant", "2019", "PC",  "file:///android_asset/S.jpg"));
            app.insertarContingut(new Juego("Warzone", "2019", "PC","file:///android_asset/S.jpg"));
            app.insertarContingut(new Juego("Runeterra", "2019", "PC", "file:///android_asset/S.jpg"));
            app.insertarContingut(new Juego("R", "2019", "PC","file:///android_asset/S.jpg"));

        });
    }
}

