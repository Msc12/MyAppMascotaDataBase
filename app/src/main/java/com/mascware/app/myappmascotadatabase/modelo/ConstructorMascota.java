package com.mascware.app.myappmascotadatabase.modelo;

import android.content.ContentValues;
import android.content.Context;

import com.mascware.app.myappmascotadatabase.R;
import com.mascware.app.myappmascotadatabase.dataBase.Constantes;
import com.mascware.app.myappmascotadatabase.dataBase.DataBase;
import com.mascware.app.myappmascotadatabase.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascota{

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascota() {
        DataBase db = new DataBase(context);
        insertarDatosDB(db);
        return  db.obtenerTodosLasMascotas();
    }

    public ArrayList<Mascota> obtenerTop5Mascota(){
        DataBase db = new DataBase(context);
        insertarTop5DB(db);
        return  db.obtenerTop5Mascota();

    }

    public void insertarDatosDB(DataBase dataBase){
        ContentValues cv= new ContentValues();
        cv.put(Constantes.TABLE_MASCOTA_NAME,"Lucas");
        cv.put(Constantes.TABLE_MASCOTA_RATING,"3");
        cv.put(Constantes.TABLE_MASCOTA_FOTO,R.drawable.perro1);
        dataBase.agregarContacto(cv);

        cv.put(Constantes.TABLE_MASCOTA_NAME,"Brook");
        cv.put(Constantes.TABLE_MASCOTA_RATING,"2");
        cv.put(Constantes.TABLE_MASCOTA_FOTO,R.drawable.perro2);
        dataBase.agregarContacto(cv);

        cv.put(Constantes.TABLE_MASCOTA_NAME,"Luna");
        cv.put(Constantes.TABLE_MASCOTA_RATING,"4");
        cv.put(Constantes.TABLE_MASCOTA_FOTO,R.drawable.gatapato);
        dataBase.agregarContacto(cv);

        cv.put(Constantes.TABLE_MASCOTA_NAME,"Peke");
        cv.put(Constantes.TABLE_MASCOTA_RATING,"1");
        cv.put(Constantes.TABLE_MASCOTA_FOTO,R.drawable.chihuahua);
        dataBase.agregarContacto(cv);

        cv.put(Constantes.TABLE_MASCOTA_NAME,"Rhyno");
        cv.put(Constantes.TABLE_MASCOTA_RATING,"2");
        cv.put(Constantes.TABLE_MASCOTA_FOTO,R.drawable.hamster);
        dataBase.agregarContacto(cv);

        cv.put(Constantes.TABLE_MASCOTA_NAME,"Linda");
        cv.put(Constantes.TABLE_MASCOTA_RATING,"2");
        cv.put(Constantes.TABLE_MASCOTA_FOTO,R.drawable.perrita);
        dataBase.agregarContacto(cv);

        cv.put(Constantes.TABLE_MASCOTA_NAME,"Ignacio");
        cv.put(Constantes.TABLE_MASCOTA_RATING,"5");
        cv.put(Constantes.TABLE_MASCOTA_FOTO,R.drawable.ignacio);
        dataBase.agregarContacto(cv);


        cv.put(Constantes.TABLE_MASCOTA_NAME,"Cachupin");
        cv.put(Constantes.TABLE_MASCOTA_RATING,"8");
        cv.put(Constantes.TABLE_MASCOTA_FOTO,R.drawable.cachupin);
        dataBase.agregarContacto(cv);
    }


    public void insertarTop5DB(DataBase dataBase){
        ContentValues cv= new ContentValues();
         cv= new ContentValues();
        cv.put(Constantes.TABLE_LIKE_ID_MASCOTA,"1");
        dataBase.agregarTop5(cv);

         cv= new ContentValues();
        cv.put(Constantes.TABLE_LIKE_ID_MASCOTA,"2");
        dataBase.agregarTop5(cv);

         cv= new ContentValues();
        cv.put(Constantes.TABLE_LIKE_ID_MASCOTA,"3");
        dataBase.agregarTop5(cv);

         cv= new ContentValues();
        cv.put(Constantes.TABLE_LIKE_ID_MASCOTA,"4");
        dataBase.agregarTop5(cv);

        cv.put(Constantes.TABLE_LIKE_ID_MASCOTA,"5");
        dataBase.agregarTop5(cv);

    }

    public int[] obtenerIdTop() {
        DataBase db = new DataBase(context);
        return  db.obtenerID();
    }

    public void actualizarIdTop5(ArrayList<Integer> listaidTop) {
        DataBase db=new DataBase(context);
        for(int i=0;i<5;i++){
            db.actualizarIdTop5(listaidTop.get(i),i+1);
        }


    }


/*
    public void darLikeMascota(Mascota contacto){
        DataBase db = new DataBase(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
*/

}
