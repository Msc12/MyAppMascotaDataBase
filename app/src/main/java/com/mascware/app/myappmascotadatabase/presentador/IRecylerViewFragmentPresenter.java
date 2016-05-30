package com.mascware.app.myappmascotadatabase.presentador;

import java.util.ArrayList;

public interface IRecylerViewFragmentPresenter {

    public void obtenerMascotas();

    public void mostarcMascotasRV();
    public void obteneridMascotastop();
    public int obtenerAlgo(int a);
    public void actualizarTop5(ArrayList<Integer> listaidTop );
}
