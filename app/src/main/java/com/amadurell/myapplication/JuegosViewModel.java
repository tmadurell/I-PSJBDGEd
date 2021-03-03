package com.amadurell.myapplication;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class JuegosViewModel extends AndroidViewModel {

    private final ContingutStorage contingutStorage;

    //imagen del insert
    MutableLiveData<Uri> imagenSeleccionada = new MutableLiveData<>();


    public JuegosViewModel(@NonNull Application application) {
        super(application);

        contingutStorage = new ContingutStorage(application);
    }

    void establecerImagenSeleccionada(Uri uri) {
        imagenSeleccionada.setValue(uri);
    }



    LiveData<List<Juego>> obtenerJuegosNuevos(){
        return contingutStorage.obtenerJuegosNuevos();
    }

}

