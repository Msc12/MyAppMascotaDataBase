package com.mascware.app.myappmascotadatabase.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mascware.app.myappmascotadatabase.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by MASC on 24-05-2016.
 */
public class DataBase extends SQLiteOpenHelper{

Context context;
    public DataBase(Context context) {
        super(context, Constantes.DATABASE_NAME, null, Constantes.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTabla="CREATE TABLE "+ Constantes.TABLE_MASCOTA+" ("+Constantes.TABLE_MASCOTA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                Constantes.TABLE_MASCOTA_NAME+" TEXT, "+Constantes.TABLE_MASCOTA_RATING+" TEXT, "+Constantes.TABLE_MASCOTA_FOTO+" INTEGER"+")";
        String queryCrearTablaLikes= "CREATE TABLE " + Constantes.TABLE_LIKE + "(" +
                Constantes.TABLE_LIKE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constantes.TABLE_LIKE_ID_MASCOTA+ " INTEGER, " +
                "FOREIGN KEY (" + Constantes.TABLE_LIKE_ID_MASCOTA + ") " +
                "REFERENCES " + Constantes.TABLE_LIKE + "(" + Constantes.TABLE_MASCOTA_ID + ")" +
                ")";
        db.execSQL(queryCrearTabla);

        db.execSQL(queryCrearTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+Constantes.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST "+Constantes.TABLE_LIKE);
        onCreate(db);
    }



    public ArrayList<Mascota> obtenerTodosLasMascotas(){
        ArrayList<Mascota> mascotas =new ArrayList<>();
        String query="SELECT * FROM "+Constantes.TABLE_MASCOTA;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);
        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRaiting(registros.getString(2));
            mascotaActual.setFoto(registros.getInt(3));
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void agregarContacto(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(Constantes.TABLE_MASCOTA,null,contentValues);
        db.close();
    }

    public void agregarTop5(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(Constantes.TABLE_LIKE,null,contentValues);
        db.close();
    }

    public ArrayList<Mascota> obtenerTop5Mascota() {
        int[] data=new int[5];
        ArrayList<Mascota> aux= new ArrayList<>();
        String query="SELECT * FROM "+Constantes.TABLE_LIKE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor registros=db.rawQuery(query,null);
        int i=0;
        while(registros.moveToNext()&&i<5){
            int idaux=registros.getInt(1);
            data[i]=idaux;
            i++;
        }

        for (int a=0;a<5;a++) {
            String query2="SELECT * FROM "+Constantes.TABLE_MASCOTA+ " WHERE "+Constantes.TABLE_MASCOTA_ID+"="+Integer.toString(data[a]);
           // db=this.getWritableDatabase();
            Cursor registros2=db.rawQuery(query2,null);

            Mascota mascotaActual=new Mascota();
            if (registros2.moveToNext()) {
                mascotaActual.setId(registros2.getInt(0));
                mascotaActual.setNombre(registros2.getString(1));
                mascotaActual.setRaiting(registros2.getString(2));

                mascotaActual.setFoto(registros2.getInt(3));
                aux.add(mascotaActual);
            }
        }
        db.close();

        return aux;
    }

    public int[] obtenerID() {
        int[] data=new int[5];
        String query="SELECT * FROM "+Constantes.TABLE_LIKE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor registros=db.rawQuery(query,null);
        int i=0;
        while(registros.moveToNext()&&i<5){
            int idaux=registros.getInt(1);
            data[i]=idaux;
            i++;
        }
    return data;
    }

    public void actualizarIdTop5(Integer idMascota,Integer id) {
        String query="UPDATE "+Constantes.TABLE_LIKE+" SET "+Constantes.TABLE_LIKE_ID_MASCOTA+"="+idMascota+" WHERE "+Constantes.TABLE_LIKE_ID+"="+id;
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL(query);

    }
}

