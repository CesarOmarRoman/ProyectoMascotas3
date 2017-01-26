package com.example.maccesarr.proyectomascotas.Adaptadores;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.R;
import com.example.maccesarr.proyectomascotas.fragments.PerfilFragment;

import java.util.ArrayList;

public class AdaptadorMascotasPerfil extends RecyclerView.Adapter<AdaptadorMascotasPerfil.ContactoViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    PerfilFragment perfil;



    public AdaptadorMascotasPerfil(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

    }

    //Inflar el layout y lo pasará el viewHolder
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_gril, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder holder, int position) {

        SharedPreferences preferencias= activity.getSharedPreferences("SICAM", Context.MODE_PRIVATE);



        final Mascota mascota = mascotas.get(position);
        holder.imagen.setImageResource(mascota.getFotografía());
        holder.ranking.setText(String.valueOf(Integer.parseInt(preferencias.getString(mascota.getName(),"0"))));

        if(holder.ranking.getText().toString().equals("0")){
            holder.btnRanking.setImageResource(R.drawable.dog_bone_96_2);
        }else{
            holder.btnRanking.setImageResource(R.drawable.dog_bone_96);
        }


////AJUSTAR PARA MOSTRAR EL LIKEEEEEE
        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //holder.imagenPerfil.setImageResource(R.drawable.dog_bone_96);
                perfil.cambiar(R.drawable.christmas_star_96);
            }
        });

    }



    //Cantidad de contactos del tamaño
    @Override
    public int getItemCount() {
        return mascotas.size();
    }



    public  class ContactoViewHolder extends RecyclerView.ViewHolder{

        private TextView ranking;
        private ImageView imagen;
        private LinearLayout cardView;
        private ImageView btnRanking;





        public ContactoViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView)itemView.findViewById(R.id.imgFoto2);
            ranking = (TextView)itemView.findViewById(R.id.tvRanking2);
            cardView = (LinearLayout)itemView.findViewById(R.id.cardViewLayout2);
            btnRanking = (ImageView) itemView.findViewById(R.id.imgB_Ranking2);

        }


    }



}
