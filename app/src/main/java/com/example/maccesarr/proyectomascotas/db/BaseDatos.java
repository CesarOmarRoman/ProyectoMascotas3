package com.example.maccesarr.proyectomascotas.db;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.maccesarr.proyectomascotas.Dominio.Mascota;

import java.util.ArrayList;

/**
 * Created by MacCesarR on 25/01/17.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Activity activity;
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    public void limpiarBaseDatos() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(ConstantesBaseDatos.TABLE_MASCOTAS, null, null);
        db.delete(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, null);
        db.close();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                ")";

        String queryCrearTablaLikesMascotas ="CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS +
                "("+ConstantesBaseDatos.TABLE_MASCOTAS_ID +")" +
                ")";
        sqLiteDatabase.execSQL(queryCrearTablaMascotas);
        sqLiteDatabase.execSQL(queryCrearTablaLikesMascotas);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);

        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerTodosLosContactos(){
        ArrayList<Mascota> nombres = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setName(registros.getString(1));
            mascotaActual.setFotografía(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES+") as likes "+
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + "=" + mascotaActual.getId();
            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            if(registrosLikes.moveToNext()){
                mascotaActual.setVotación(registrosLikes.getInt(0));
            }else{
                mascotaActual.setVotación(0);
            }

            nombres.add(mascotaActual);
        }
        db.close();
        return nombres;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }

    public void LimpiarTabla(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        db.execSQL("delete from "+ ConstantesBaseDatos.TABLE_MASCOTAS);
        db.close();
    }


    public int obtenerLikesContacto(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES+")"+
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + "=" +
                mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
