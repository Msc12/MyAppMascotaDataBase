package com.mascware.app.myappmascotadatabase.presentador;

import com.mascware.app.myappmascotadatabase.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by MASC on 29-05-2016.
 */
public interface iTop5Presenter {
    void obtenerMascotas();

    ArrayList<Mascota> getLista();


    //  void mostarcMascotasRV();
}
