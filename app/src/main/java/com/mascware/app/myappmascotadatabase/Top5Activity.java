package com.mascware.app.myappmascotadatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.mascware.app.myappmascotadatabase.adapters.Top5MascotaAdapter;
import com.mascware.app.myappmascotadatabase.pojo.Mascota;
import com.mascware.app.myappmascotadatabase.presentador.Top5Presenter;
import com.mascware.app.myappmascotadatabase.presentador.iTop5Presenter;

import java.util.ArrayList;

public class Top5Activity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    RecyclerView listaMascotaTop;
    iTop5Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        if(miActionBar!=null){
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        listaMascotaTop= (RecyclerView) findViewById(R.id.recycleviewMascotastop5);
        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotaTop.setLayoutManager(llm);

        presenter = new Top5Presenter(this, getBaseContext());
        mascotas=presenter.getLista();

        inicializarAdapter();
    }

    public void inicializarAdapter(){
        Top5MascotaAdapter adapter= new Top5MascotaAdapter(mascotas,this);
        listaMascotaTop.setAdapter(adapter);

    }
    public void inicializarListaMascotaTop5(){
        mascotas =new ArrayList<Mascota>();
        mascotas.add(new Mascota("Lucas","3",R.drawable.perro1));
        mascotas.add(new Mascota("Brook","2",R.drawable.perro2));
        mascotas.add(new Mascota("Luna","4",R.drawable.gatapato));
        mascotas.add(new Mascota("Peke","1",R.drawable.chihuahua));
        mascotas.add(new Mascota("Rhyno","2",R.drawable.hamster));
    }
}
