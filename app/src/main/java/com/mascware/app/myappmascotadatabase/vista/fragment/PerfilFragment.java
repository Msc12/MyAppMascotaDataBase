package com.mascware.app.myappmascotadatabase.vista.fragment;

import com.mascware.app.myappmascotadatabase.R;
import com.mascware.app.myappmascotadatabase.adapters.PerfilMascotaAdapter;
import com.mascware.app.myappmascotadatabase.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    Mascota mascota;
    ArrayList<Integer> imagenesMascota;
    ArrayList<Integer> raitingsMascota;
    RecyclerView listaMascota;
    CircularImageView imagenPerfil;
    TextView nombrePerfil;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_perfil,container,false);
        listaMascota = (RecyclerView) v.findViewById(R.id.recycleviewPerfil);
        listaMascota.setHasFixedSize(true);
        imagenPerfil=(CircularImageView) v.findViewById(R.id.imagePerfilCircle);
        nombrePerfil=(TextView) v.findViewById(R.id.nombrePerfil);
        GridLayoutManager llm =new GridLayoutManager(getContext(),3);
        listaMascota.setLayoutManager(llm);
        inicializarListaMascota();
        inicializarAdapter();
        imagenPerfil.setImageResource(mascota.getFoto());
        nombrePerfil.setText(mascota.getNombre());
        return v;
    }


    PerfilMascotaAdapter adapter;
    public void inicializarAdapter(){
        adapter= new PerfilMascotaAdapter(getActivity(),imagenesMascota,raitingsMascota);
        listaMascota.setAdapter(adapter);

    }
    private void inicializarListaMascota() {
        mascota=new Mascota("Lucas","3",R.drawable.perro1);
        imagenesMascota=new ArrayList<>();
      raitingsMascota=new ArrayList<>();
        imagenesMascota.add(R.drawable.perro1);
        raitingsMascota.add(4);
        imagenesMascota.add(R.drawable.perro1);
        raitingsMascota.add(4);
        imagenesMascota.add(R.drawable.perro1);
        raitingsMascota.add(3);
        imagenesMascota.add(R.drawable.perro1);
        raitingsMascota.add(2);
        imagenesMascota.add(R.drawable.perro1);
        raitingsMascota.add(7);
        imagenesMascota.add(R.drawable.perro1);
        raitingsMascota.add(1);
        imagenesMascota.add(R.drawable.perro1);
        raitingsMascota.add(9);

    }

}
