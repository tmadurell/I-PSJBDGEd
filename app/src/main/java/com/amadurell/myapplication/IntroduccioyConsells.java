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
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.amadurell.myapplication.databinding.IntroduccioyconsellsBinding;


public class IntroduccioyConsells extends Fragment {

    NavController navController;
    private IntroduccioyconsellsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = IntroduccioyconsellsBinding.inflate(inflater, container, false)).getRoot();    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);


        binding.viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0: default:
                        return new Consell1();
                    case 1:
                        return new Consell1A();
                    case 2:
                        return new Consell1B();
                    case 3:
                        return new Consell1C();
                }
            }
            @Override
            public int getItemCount() {
                return 4;
            }
        });
    }
}