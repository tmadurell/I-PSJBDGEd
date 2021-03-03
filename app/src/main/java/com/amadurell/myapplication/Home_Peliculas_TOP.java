package com.amadurell.myapplication;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.amadurell.myapplication.databinding.HomePeliculasTopBinding;

import java.util.List;

public class Home_Peliculas_TOP extends Fragment {

    HomePeliculasTopBinding binding;
    private JuegosViewModel juegosViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = HomePeliculasTopBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //AQUI VA EL CODIGO
        NavController navController = Navigation.findNavController(view);

        binding.llupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_Peliculas_TOP_to_cerca);
            }


        });
        binding.genero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_Peliculas_TOP_to_home_Peliculas_Genere);
            }


        });
        binding.novetats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_Peliculas_TOP_to_home_Pelicules);
            }


        });
        binding.barritas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_Peliculas_TOP_to_barra_Menu);
            }

        });

    }




}