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

import com.amadurell.myapplication.databinding.DadeselegiraBinding;


public class DadesElegirA extends Fragment {

    NavController navController;
    private DadeselegiraBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = DadeselegiraBinding.inflate(inflater, container, false)).getRoot();    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        binding.esperachaval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_dadesElegirA_to_dades);
            }

        });
        binding.okboomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_dadesElegirA_to_notificacions);
            }

        });
        binding.infobasicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_dadesElegirA_to_dadesElegirB);
            }

        });
        binding.infobasicos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_dadesElegirA_to_dadesElegirB);
            }

        });
        binding.basicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_dadesElegirA_to_dadesElegirB);
            }

        });
    }
}
