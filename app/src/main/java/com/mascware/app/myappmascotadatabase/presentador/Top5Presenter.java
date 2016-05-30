package com.mascware.app.myappmascotadatabase.presentador;

import android.content.Context;

import com.mascware.app.myappmascotadatabase.Top5Activity;
import com.mascware.app.myappmascotadatabase.modelo.ConstructorMascota;
import com.mascware.app.myappmascotadatabase.pojo.Mascota;
import com.mascware.app.myappmascotadatabase.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

/**
 * Created by MASC on 29-05-2016.
 */
public class Top5Presenter implements iTop5Presenter {


    private final Top5Activity top5activity;
    private final Context context;
    ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;

    public  Top5Presenter(Top5Activity top5, Context context) {
        this.top5activity = top5;
        this.context =top5;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascota= new ConstructorMascota(context);
        mascotas = constructorMascota.obtenerTop5Mascota();
       // mostarcMascotasRV();
    }

    @Override
    public ArrayList<Mascota> getLista() {
        return mascotas;
    }


  /*  @Override
    public void mostarcMascotasRV() {
        top5activity.inicializarAdaptadorRV(top5activity.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }*/
}
