package com.amadurell.myapplication;

import android.graphics.drawable.Drawable;
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

import com.amadurell.myapplication.databinding.SimpsonsBinding;

public class MostrarJuego extends Fragment {

    private SimpsonsBinding binding;
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return (binding = SimpsonsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.estrella.setOnClickListener(v -> navController.navigate(R.id.action_simpsonsinfo_to_simpsons_No));

        binding.enrere.setOnClickListener(v -> navController.navigate(R.id.action_simpsonsinfo_to_llista));

        binding.titulo.setText("CUALRQUIER COSA");

        binding.portada.setImageDrawable(Drawable.createFromPath("file:///android_asset/S.jpg"));

    }
}