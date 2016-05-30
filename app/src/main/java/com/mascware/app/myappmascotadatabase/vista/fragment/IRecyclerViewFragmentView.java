package com.mascware.app.myappmascotadatabase.vista.fragment;

import com.mascware.app.myappmascotadatabase.adapters.MascotaAdapter;
import com.mascware.app.myappmascotadatabase.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by MASC on 29-05-2016.
 */
public interface IRecyclerViewFragmentView {
    void generarLinearLayoutVertical();

    MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    void inicializarAdaptadorRV(MascotaAdapter adaptador);
}
