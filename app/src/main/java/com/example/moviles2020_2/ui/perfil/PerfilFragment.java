package com.example.moviles2020_2.ui.perfil;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.moviles2020_2.LoginViewModel;
import com.example.moviles2020_2.R;
import com.example.moviles2020_2.model.Propietario;
import com.example.moviles2020_2.model.Usuario;

import java.util.IllegalFormatCodePointException;
import java.util.concurrent.ExecutionException;

public class PerfilFragment extends Fragment {

    private PerfilViewModel mViewModel;
    EditText etdni, etapellido, etnombre, etTelefono, etMail, etPass,etDir;
    Button btnToggleEditar;
    private int estado = 0;
    private Propietario p =null;

    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.perfil_fragment, container, false);
        etdni = view.findViewById(R.id.etPFDNI);
        etapellido = view.findViewById(R.id.etPFApellido);
        etnombre = view.findViewById(R.id.etPFNombre);
        etTelefono = view.findViewById(R.id.etPFTelefono);
        etMail = view.findViewById(R.id.etPFMail);
        etPass = view.findViewById(R.id.etPFPass);
        etDir=view.findViewById(R.id.etIFDDireccion);
        btnToggleEditar = view.findViewById(R.id.btnToggleEditar);

        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);



        public void fijarDato(){}

    public void estadoUno() {
        etdni.setEnabled(false);
        etapellido.setEnabled(false);
        etnombre.setEnabled(false);
        etTelefono.setEnabled(false);
        etMail.setEnabled(false);
        etPass.setEnabled(false);
        etapellido.setEnabled(false);
        etDir.setEnabled(false);
        btnToggleEditar.setText("Editar");
        estado = 1;
    }

    public void estadoDos(){
        etdni.setEnabled(true);
        etapellido.setEnabled(true);
        etnombre.setEnabled(true);
        etTelefono.setEnabled(true);
        etMail.setEnabled(true);
        etPass.setEnabled(true);
        etapellido.setEnabled(true);
        etDir.setEnabled(true);
        btnToggleEditar.setText("Actualizar");
        estado = 2;
    }
}
}
