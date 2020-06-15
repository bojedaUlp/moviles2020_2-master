package com.example.moviles2020_2.ui.propiedades;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.moviles2020_2.model.Inmueble;
import java.util.ArrayList;
import java.util.List;

public class PropiedadViewModel extends ViewModel {
    private MutableLiveData<List<Inmueble>> propiedades;
    private MutableLiveData<Inmueble> propiedad;


    public PropiedadViewModel() {
        this.propiedades = new MutableLiveData<List<Inmueble>>();
        this.propiedad = new MutableLiveData<>();
    }

    public LiveData<List<Inmueble>> getPropiedades(){
        if(propiedades==null){
            propiedades=new MutableLiveData<>();
        }
        return propiedades;
    }
    public LiveData<Inmueble> getPropiedad(){
        if(propiedad==null){
            propiedad=new MutableLiveData<>();
        }
        return propiedad;
    }

    public void setPropiedad(Inmueble p){
        this.propiedad.setValue(p);
    }

    public void setPropiedades(List<Inmueble> propiedades) {
        this.propiedades.setValue(propiedades);
    }


    // desde aca lleno el fragment main
    public void obtenerPropiedades(){
        List<Inmueble> lista = new ArrayList<Inmueble>();
        lista.add(new Inmueble(1, "Sucre 2250", 4, "Depto", "Residencial", 10000, true));
        lista.add(new Inmueble(2, "Poblet 548", 10, "Depto", "Comercial", 50000, true));
        lista.add(new Inmueble(3, "Bolivar 815", 1, "Depto", "Comercial", 5000, true));
        lista.add(new Inmueble(4, "Colon 3213", 3, "Depto", "Residencial", 15000, true));
        lista.add(new Inmueble(5, "Lince 22 19", 6, "Depto", "Comercial", 30000, true));
        lista.add(new Inmueble(6, "Italia 11 Sur", 2, "Depto", "Comercial", 10000, true));
        lista.add(new Inmueble(7, "Ruta 3 Km 11", 8, "Depto", "Residencial", 80000, true));
        lista.add(new Inmueble(8, "Ruta 20 km 4", 3, "Depto", "Residencial", 15000, true));
        lista.add(new Inmueble(9, "Av Illia 185", 4, "Depto", "Comercial", 20000, true));
        setPropiedades(lista);
    }


    //desde aca lleno el fragment detail
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void obtenerPropiedad(int id){
        List<Inmueble> lista = new ArrayList<Inmueble>();
        lista.add(new Inmueble(1, "Sucre 2250", 4, "Depto", "Residencial", 10000, true));
        lista.add(new Inmueble(2, "Poblet 548", 10, "Depto", "Comercial", 50000, true));
        lista.add(new Inmueble(3, "Bolivar 815", 1, "Depto", "Comercial", 5000, true));
        lista.add(new Inmueble(4, "Colon 3213", 3, "Depto", "Residencial", 15000, true));
        lista.add(new Inmueble(5, "Lince 22 19", 6, "Depto", "Comercial", 30000, true));
        lista.add(new Inmueble(6, "Italia 11 Sur", 2, "Depto", "Comercial", 10000, true));
        lista.add(new Inmueble(7, "Ruta 3 Km 11", 8, "Depto", "Residencial", 80000, true));
        lista.add(new Inmueble(8, "Ruta 20 km 4", 3, "Depto", "Residencial", 15000, true));
        lista.add(new Inmueble(9, "Av Illia 185", 4, "Depto", "Comercial", 20000, true));

        Inmueble prop = lista.stream()
                .filter(x -> id == (x.getId()))
                .findAny()
                .orElse(null);

        if (prop != null){
            setPropiedad(prop);
        }

    }


    //cambiar disponible
    public void cambiarDisponible(){
        try{
            Inmueble p = propiedad.getValue();
            if (p.getDisponible()){
                p.setDisponible(false);
            }else{
                p.setDisponible(true);
            }
            propiedad.setValue(p);
        }catch (Exception e){
            Log.d("verPropVM", e.getMessage());
            Log.d("verPropVM", e.getCause().toString());
        }



    }
}
