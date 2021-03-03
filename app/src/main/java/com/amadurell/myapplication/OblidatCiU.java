package com.amadurell.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.amadurell.myapplication.databinding.OblidatCiUBinding;
import com.bumptech.glide.Glide;


public class OblidatCiU extends Fragment {

    NavController navController;
    private OblidatCiUBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = OblidatCiUBinding.inflate(inflater, container, false)).getRoot();    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        Glide.with(OblidatCiU.this).load(R.drawable.key).into(binding.clau);

        binding.Confirmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_oblidatCiU_to_matrix);
            }

        });
        binding.atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_oblidatCiU_to_iniciarsessio);
            }

        });
    }
}
