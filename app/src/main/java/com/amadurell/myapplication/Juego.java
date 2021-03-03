package com.amadurell.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Juego {
    @PrimaryKey(autoGenerate = true)
    int id;

    String titulo;
    String year;
    String desarrollador;
    String imagen;
    String plataforma;

    public Juego(String titulo, String year, String plataforma, String imagen) {
        this.titulo = titulo;
        this.year = year;
        this.plataforma = plataforma;
        this.imagen = imagen;
    }
}