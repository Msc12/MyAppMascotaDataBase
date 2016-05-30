package com.mascware.app.myappmascotadatabase.presentador;

import android.content.Context;
import android.provider.Settings;

import com.mascware.app.myappmascotadatabase.modelo.ConstructorMascota;
import com.mascware.app.myappmascotadatabase.pojo.Mascota;
import com.mascware.app.myappmascotadatabase.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecylerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;
    int[] data;
    public  RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascota = new ConstructorMascota(context);
        mascotas = constructorMascota.obtenerMascota();
        mostarcMascotasRV();
    }


    @Override
    public void mostarcMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
    @Override
    public void obteneridMascotastop() {
        constructorMascota = new ConstructorMascota(context);
        data = new int[5];
        data = constructorMascota.obtenerIdTop();
    }
    @Override
    public int obtenerAlgo(int a){
        return data[a];
    }
    @Override
    public void actualizarTop5(ArrayList<Integer> listaidTop ){
        constructorMascota.actualizarIdTop5(listaidTop );


    }
}
