package com.amadurell.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.*;
import androidx.navigation.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amadurell.myapplication.databinding.ComptesBinding;
import com.bumptech.glide.Glide;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import com.amadurell.myapplication.databinding.BenvingutsBinding;


public class Benvinguts extends Fragment {

    NavController navController;
    Arranque arranque;
    private BenvingutsBinding binding;
    Executor executor = Executors.newSingleThreadExecutor();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return (binding = BenvingutsBinding.inflate(inflater, container, false)).getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arranque = new ViewModelProvider(requireActivity()).get(Arranque.class);
        navController = Navigation.findNavController(view);

        Glide.with(Benvinguts.this).load(R.drawable.loading).into(binding.carregant);

        arranque.finishedLoading.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                navController.navigate(R.id.action_benvingut_to_matrix);
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    // simular la carga de recursos

                    Thread.sleep(3000);
                    arranque.finishedLoading.postValue(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}