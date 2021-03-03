package com.amadurell.myapplication;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ContingutStorage {

    private final AppBaseDeDatos.App app;
    Executor executor = Executors.newSingleThreadExecutor();

    ContingutStorage(Application application){
        app = AppBaseDeDatos.getInstance(application).obtenerJuegosDao();
    }

    void insertar(String titul, String any, String plataforma, String imagen){
        executor.execute(()->{
            app.insertarContingut(new Juego(titul, any, plataforma, imagen));


        });

    }

    public LiveData<List<Juego>> obtenerJuegosNuevos() {
        return app.obtenerJuegosNuevos();
    }


}
