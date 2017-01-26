package com.example.maccesarr.proyectomascotas.Adaptadores;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.maccesarr.proyectomascotas.R;

import java.util.ArrayList;

import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.db.ConstructorDeMascotas;

public class AdaptadorMascotas extends RecyclerView.Adapter<AdaptadorMascotas.ContactoViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;



    public AdaptadorMascotas(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

    }

    //Inflar el layout y lo pasará el viewHolder
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder holder, int position) {

        final Mascota mascota = mascotas.get(position);
        holder.imagen.setImageResource(mascota.getFotografía());
        holder.nombre.setText(mascota.getName());
        holder.ranking.setText(String.valueOf(mascota.getVotación()));

        if(holder.ranking.getText().toString().equals("0")){
            holder.btnRanking.setImageResource(R.drawable.dog_bone_96_2);
        }else{
            holder.btnRanking.setImageResource(R.drawable.dog_bone_96);
        }


////AJUSTAR PARA MOSTRAR EL LIKEEEEEE
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override




            public void onClick(View view) {
                if(holder.btnRanking.getDrawable().getConstantState().equals( activity.getResources().getDrawable(R.drawable.dog_bone_96_2).getConstantState())) {

                    ConstructorDeMascotas constructorDeMascotas = new ConstructorDeMascotas(activity);
                    constructorDeMascotas.darLikeContacto(mascota);
                    holder.ranking.setText(String.valueOf(constructorDeMascotas.obtenerLikesContacto(mascota)));
                    holder.btnRanking.setImageResource(R.drawable.dog_bone_96);
                }else{
                    ConstructorDeMascotas constructorDeMascotas = new ConstructorDeMascotas(activity);
                    constructorDeMascotas.darLikeContacto(mascota);
                    holder.ranking.setText(String.valueOf(constructorDeMascotas.obtenerLikesContacto(mascota)));
                }
            }
        });

    }



    //Cantidad de contactos del tamaño
    @Override
    public int getItemCount() {
        return mascotas.size();
    }



    public  class ContactoViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre;
        private TextView ranking;
        private ImageView imagen;
        private LinearLayout cardView;
        private ImageView btnLike;
        private ImageView btnRanking;




        public ContactoViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView)itemView.findViewById(R.id.imgFoto);
            nombre = (TextView)itemView.findViewById(R.id.tvNombre);
            ranking = (TextView)itemView.findViewById(R.id.tvRanking);
            cardView = (LinearLayout)itemView.findViewById(R.id.cardViewLayout);
            btnLike = (ImageView) itemView.findViewById(R.id.imgB_Favorite);
            btnRanking = (ImageView) itemView.findViewById(R.id.imgB_Ranking);


        }


    }



}
