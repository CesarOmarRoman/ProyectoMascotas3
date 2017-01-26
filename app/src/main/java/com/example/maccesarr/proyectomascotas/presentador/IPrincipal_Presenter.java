package com.example.maccesarr.proyectomascotas.presentador;

import android.content.Context;

import com.example.maccesarr.proyectomascotas.db.BaseDatos;

/**
 * Created by MacCesarR on 25/01/17.
 */

public interface IPrincipal_Presenter {

    public void obtenerMascotasBaseDeDatos();

    public void mostrarMascotasBaseDeDatos();

    public void agregarMascotasBaseDeDatos(BaseDatos db);

    public void limpiarTablas(Context context);
}
