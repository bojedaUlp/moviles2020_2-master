package com.example.moviles2020_2.ui.propiedades;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviles2020_2.R;
import com.example.moviles2020_2.model.Inmueble;

import java.util.ArrayList;
import java.util.List;


public class PropiedadFragment extends Fragment {

    private PropiedadViewModel mViewModel;
    List<Inmueble> listaMutable;
    RecyclerView contenedor;
    public static PropiedadFragment newInstance() {
        return new PropiedadFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PropiedadViewModel.class);
        View view = inflater.inflate(R.layout.propiedad_fragment, container, false);
        contenedor = view.findViewById(R.id.rvPropiedades);

        RecyclerView.LayoutManager layout= new LinearLayoutManager(getContext());
        contenedor.setLayoutManager(layout);

        mViewModel.obtenerPropiedades();

        listaMutable = new ArrayList<>();
        final Observer<List<Inmueble>> listaObservable = new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> propiedads) {
                contenedor.setAdapter(new Adapter(propiedads));
            }
        };
        mViewModel.getPropiedades().observe(getViewLifecycleOwner(), listaObservable);


        return view;
    }

}
