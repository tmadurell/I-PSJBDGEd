package com.amadurell.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.amadurell.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());



        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {

            if(destination.getId() == R.id.iniciarsessio
                    || destination.getId() == R.id.benvinguts
                    || destination.getId() == R.id.matrix
                    || destination.getId() == R.id.comptes
                    || destination.getId() == R.id.felicitats
                    || destination.getId() == R.id.notificacions
                    || destination.getId() == R.id.dades
                    || destination.getId() == R.id.dadesElegirA
                    || destination.getId() == R.id.dadesElegirB
                    || destination.getId() == R.id.introduccioyConsells
                    || destination.getId() == R.id.terminisA
                    || destination.getId() == R.id.terminisB
                    || destination.getId() == R.id.tiP
                    || destination.getId() == R.id.creacompte
                    || destination.getId() == R.id.oblidatCiU
                    || destination.getId() == R.id.ayuda
                    || destination.getId() == R.id.barra_Menu
                    || destination.getId() == R.id.perfil
                    || destination.getId() == R.id.cerca){
                binding.bottomNavView.setVisibility(View.GONE);
            } else {
                binding.bottomNavView.setVisibility(View.VISIBLE);
            }


        });



    }

}