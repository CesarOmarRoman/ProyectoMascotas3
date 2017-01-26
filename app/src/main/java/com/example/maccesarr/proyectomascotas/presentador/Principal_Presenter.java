package com.example.maccesarr.proyectomascotas.presentador;

import android.content.ContentValues;
import android.content.Context;

import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.R;
import com.example.maccesarr.proyectomascotas.db.BaseDatos;
import com.example.maccesarr.proyectomascotas.db.ConstantesBaseDatos;
import com.example.maccesarr.proyectomascotas.db.ConstructorDeMascotas;
import com.example.maccesarr.proyectomascotas.vista.IPrincipalFragment_View;

import java.util.ArrayList;

/**
 * Created by MacCesarR on 25/01/17.
 */

public class Principal_Presenter implements IPrincipal_Presenter {

    IPrincipalFragment_View iPrincipalFragment_view;
    public Context context;
    private ConstructorDeMascotas constructorDeMascotas;
    private ArrayList<Mascota> mascotas;

    public Principal_Presenter(IPrincipalFragment_View iPrincipalFragment_view, Context context) {
        this.iPrincipalFragment_view = iPrincipalFragment_view;
        this.context = context;
        obtenerMascotasBaseDeDatos();
    }

    public Principal_Presenter(Context context) {
        limpiarTablas(context);
    }

    @Override
    public void obtenerMascotasBaseDeDatos() {
        constructorDeMascotas = new ConstructorDeMascotas(context);
        mascotas = constructorDeMascotas.obtenerDatos();
        mostrarMascotasBaseDeDatos();
    }

    @Override
    public void mostrarMascotasBaseDeDatos() {
        iPrincipalFragment_view.inicializarAdaptador(iPrincipalFragment_view.crearAdaptador(mascotas));
        iPrincipalFragment_view.generarLayoutVertical();
    }

    public void limpiarTablas(Context context){
        constructorDeMascotas = new ConstructorDeMascotas();
        mascotas = constructorDeMascotas.eliminarDatos(context);
        mostrarMascotasBaseDeDatos();
    }

    @Override
    public void agregarMascotasBaseDeDatos(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Bronco");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Max");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Algodón");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog3);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Intenso");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog4);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pensativo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog5);
        db.insertarMascota(contentValues);
    }
}
