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

import com.amadurell.myapplication.databinding.TerminisbBinding;


public class TerminisB extends Fragment {

    NavController navController;
    private TerminisbBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = TerminisbBinding.inflate(inflater, container, false)).getRoot();    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.okboomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_terminisB_to_dades);
            }
        });
        binding.esperachaval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_terminisB_to_tiP);
            }
        });
        binding.infoaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_terminisB_to_terminisA);
            }
        });
        binding.infoaceptar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_terminisB_to_terminisA);
            }
        });
        binding.Aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_terminisB_to_terminisA);
            }
        });
    }
}
