package com.example.maccesarr.proyectomascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;

import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.R;
import com.example.maccesarr.proyectomascotas.presentador.Principal_Presenter;

import java.util.ArrayList;

import javax.mail.Quota;

/**
 * Created by MacCesarR on 25/01/17.
 */

public class ConstructorDeMascotas {

    private Context context;
    private static final int LIKE = 1;

    public ConstructorDeMascotas(Context context) {
        this.context = context;
    }

    public  ConstructorDeMascotas() {
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos baseDatos = new BaseDatos(context);
       // Principal_Presenter principal_presenter = new Principal_Presenter(context);
      //  principal_presenter.agregarMascotasBaseDeDatos(baseDatos);
        return  baseDatos.obtenerTodosLosContactos();
    }

    public ArrayList<Mascota> eliminarDatos(Context context){
        BaseDatos baseDatos = new BaseDatos(context);
        baseDatos.LimpiarTabla();
        return  baseDatos.obtenerTodosLosContactos();
    }


    public void darLikeContacto(Mascota mascota){
        BaseDatos db= new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesContacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(mascota);
    }


}
