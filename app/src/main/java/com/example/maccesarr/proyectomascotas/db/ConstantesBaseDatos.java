package com.example.maccesarr.proyectomascotas.db;

/**
 * Created by MacCesarR on 22/01/17.
 */

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTAS            = "mascota";
    public static final String TABLE_MASCOTAS_ID         = "id";
    public static final String TABLE_MASCOTAS_NOMBRE     = "nombre";
    public static final String TABLE_MASCOTAS_FOTO       = "foto";

    public static final String TABLE_LIKES_MASCOTA= "mascota_likes";
    public static final String TABLE_LIKES_MASCOTAS_ID = "id";
    public static final String TABLE_LIKES_MASCOTAS_ID_MASCOTAS= "id_contacto";
    public static final String TABLE_LIKES_MASCOTAS_NUMERO_LIKES = "numero_likes";
}


