package com.mascware.app.myappmascotadatabase.adapters;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mascware.app.myappmascotadatabase.R;

import java.util.ArrayList;

/**
 * Created by MASC on 12-05-2016.
 */
public class PerfilMascotaAdapter extends  RecyclerView.Adapter<PerfilMascotaAdapter.MascotaViewHolder> {

    FragmentActivity activity;
    ArrayList<Integer> imagen;
    ArrayList<Integer> raiting;
    public PerfilMascotaAdapter(FragmentActivity activityw,ArrayList<Integer> imagen,ArrayList<Integer> raiting){
        this.activity=activityw;
        this.imagen=imagen;
        this.raiting=raiting;
    }
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //inflamos las vistas para el viewHolder
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotadetalle,parent,false);
        return new MascotaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) { //pasar lista de mascotas a los elementos
        holder.raiting.setText(Integer.toString(raiting.get(position)));
        holder.imgFoto.setImageResource(imagen.get(position));
    }

    @Override
    public int getItemCount() { //cantidad de elementos que contien mi lista.
        return imagen.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView raiting;
        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFotoPerfil);
            raiting = (TextView)  itemView.findViewById(R.id.textViewRaitingPerfil);
        }


    }

}
