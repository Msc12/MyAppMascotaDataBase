package com.mascware.app.myappmascotadatabase.vista.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mascware.app.myappmascotadatabase.R;
import com.mascware.app.myappmascotadatabase.adapters.MascotaAdapter;
import com.mascware.app.myappmascotadatabase.pojo.Mascota;
import com.mascware.app.myappmascotadatabase.presentador.IRecylerViewFragmentPresenter;
import com.mascware.app.myappmascotadatabase.presentador.RecyclerViewFragmentPresenter;
import com.mascware.app.myappmascotadatabase.presentador.Top5Presenter;

import java.util.ArrayList;


public class RecyclerViewFragmentView extends Fragment implements IRecyclerViewFragmentView {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascota;
    IRecylerViewFragmentPresenter presenter;
    RecyclerView rvMascotas;
    ArrayList<Integer> valoresId;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.recicleview_fragment, container, false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.recycleviewMascotasPrin);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        buscartop5id();
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

    }
    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas,this );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adaptador) {
        rvMascotas.setAdapter(adaptador);
    }

    public void buscartop5id(){
        presenter.obteneridMascotastop();
        this.valoresId=new ArrayList<>();
        for(int i=0;i<5;i++){
            this.valoresId.add(presenter.obtenerAlgo(i));
        }

    }

    public void agregaAlTop(int id) {
        this.valoresId.add(0, id);
        presenter.actualizarTop5(valoresId);
    }
}
