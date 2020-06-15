package com.example.moviles2020_2.ui.propiedades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviles2020_2.R;
import com.example.moviles2020_2.model.Inmueble;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Inmueble> listaPropiedad;

    public Adapter(List<Inmueble> listaPropiedad) {
        this.listaPropiedad = listaPropiedad;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_propiedad, parent, false);
        return new ViewHolder(vista, listaPropiedad);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cargaPropiedad(listaPropiedad.get(position));
    }

    @Override
    public int getItemCount() {
        return listaPropiedad.size();
    }



    //clase Interna


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvDireccion, tvAmbientes, tvTipo, tvUso, tvPrecio, tvDisponible;
        Button btnBuscaPropiedad;
        List<Inmueble> lista;


        public ViewHolder(@NonNull View itemView, List<Inmueble> lista) {
            super(itemView);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvAmbientes = itemView.findViewById(R.id.tvAmbientes);
            tvTipo = itemView.findViewById(R.id.tvTipo);
            tvUso = itemView.findViewById(R.id.tvUso);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            tvDisponible = itemView.findViewById(R.id.tvDisponible);
            btnBuscaPropiedad = itemView.findViewById(R.id.btnBuscaPropiedad);
            btnBuscaPropiedad.setOnClickListener(this);
            this.lista = lista;
        }

        public void cargaPropiedad(Inmueble p){
            tvDireccion.setText(p.getDireccion());
            tvAmbientes.setText(p.getAmbientes()+"");
            //tvTipo.setText(p.getTipo());
            tvUso.setText(p.getUso());
            tvPrecio.setText(p.getPrecio()+"");
            //tvDisponible.setText(p.getDisponible()+"");
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Inmueble propiedad = listaPropiedad.get(position);

            //Toast.makeText(btnBuscaPropiedad.getContext(), propiedad.getDireccion(), Toast.LENGTH_SHORT).show();


            Bundle bundle = new Bundle();
            bundle.putInt("propiedadId", propiedad.getId());
            Navigation.findNavController(v).navigate(R.id.propiedadDetailFragment, bundle);



        }
    }

}
