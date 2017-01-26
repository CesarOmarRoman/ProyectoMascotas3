package com.example.maccesarr.proyectomascotas.vista;

import android.content.Context;

import com.example.maccesarr.proyectomascotas.Adaptadores.AdaptadorMascotas;
import com.example.maccesarr.proyectomascotas.Dominio.Mascota;

import java.util.ArrayList;

/**
 * Created by MacCesarR on 25/01/17.
 */

public interface IPrincipalFragment_View {

    public void generarLayoutVertical();

    public AdaptadorMascotas crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(AdaptadorMascotas adaptadorMascotas);

}
