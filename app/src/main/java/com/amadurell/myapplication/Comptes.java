package com.amadurell.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amadurell.myapplication.databinding.ComptesBinding;
import com.bumptech.glide.Glide;

public class Comptes extends Fragment {

    private ComptesBinding binding;
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return (binding = ComptesBinding.inflate(inflater, container, false)).getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        Glide.with(Comptes.this).load(R.drawable.bbdd).into(binding.pc);

        binding.iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_comptes_to_iniciarsessio);
            }

        });

        binding.irAlRegistro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_comptes_to_creacompte);
            }

        });
        binding.irAlRegistro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_comptes_to_creacompte);
            }

        });
        binding.equis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_comptes_to_tiP);
            }

        });
        binding.atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_comptes_to_matrix);
            }

        });

    }
}
