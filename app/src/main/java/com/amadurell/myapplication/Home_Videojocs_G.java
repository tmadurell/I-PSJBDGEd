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
import com.amadurell.myapplication.databinding.HomeVideojocsGBinding;
import com.amadurell.myapplication.databinding.HorizontalContingutBinding;

import java.util.List;

public class Home_Videojocs_G extends Fragment {

    HomeVideojocsGBinding binding;
    private JuegosViewModel juegosViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = HomeVideojocsGBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //AQUI VA EL CODIGO
        NavController navController = Navigation.findNavController(view);
        binding.novetats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_Videojocs_G_to_home_Videojocs);
            }


        });
        binding.top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_Videojocs_G_to_home_Videojocs_T);
            }


        });
        binding.plataforma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_Videojocs_G_to_home_Videojocs_P);
            }


        });
        binding.barritas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_Videojocs_G_to_barra_Menu);
            }

        });
        binding.llupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_Videojocs_G_to_cerca);
            }

        });

        juegosViewModel = new ViewModelProvider(this).get(JuegosViewModel.class);


        JuegosNewAdapter juegosNewAdapter = new JuegosNewAdapter();
        binding.recyclerViewNew.setAdapter(juegosNewAdapter);

        juegosViewModel.obtenerJuegosNuevos().observe(getViewLifecycleOwner(), juegos -> {
            juegosNewAdapter.setJuegoList(juegos);
        });


    }


    class JuegosNewAdapter extends RecyclerView.Adapter<JuegoNewViewHolder> {

        List<Juego> juegoList;


        @NonNull
        @Override
        public JuegoNewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new JuegoNewViewHolder(HorizontalContingutBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull JuegoNewViewHolder holder, int position) {
            Juego juego = juegoList.get(position);

            Glide.with(holder.itemView).load(juego.imagen).into(holder.binding.portada);
        }

        @Override
        public int getItemCount() {
            return juegoList == null ? 0 : juegoList.size();
        }

        public void setJuegoList(List<Juego> juegoList) {
            this.juegoList = juegoList;
            notifyDataSetChanged();
        }
    }


    static class JuegoNewViewHolder extends RecyclerView.ViewHolder {
        HorizontalContingutBinding binding;

        public JuegoNewViewHolder(@NonNull HorizontalContingutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}