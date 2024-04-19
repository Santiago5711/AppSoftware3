package com.example.mylogin;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class bdd  extends SQLiteOpenHelper{

    private Context context ;
    private static final  String DATABESE_NAME ="Basedd_ul.db";
    private static final  int DATABESE_version =1;

    private static final  String Nombre_tabla ="Usuario";
    private static final  String  COLUMNA_ID ="Id_usuario";
    private static final  String  COLUMNA_CORREO ="Correo";

    private static final  String  COLUMNA_CLAVE ="clave";
    private static final  String  COLUMNA_NUMERO ="numero";



    public bdd(@Nullable Context context) {
        super(context, DATABESE_NAME, null,DATABESE_version );
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Nombre_tabla +
                "(" + COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMNA_CORREO + " TEXT, " +
                COLUMNA_NUMERO + " INT, " +
                COLUMNA_CLAVE + " TEXT)";
        db.execSQL(query);
    }

     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Nombre_tabla);
        onCreate(db);
     }
     void añadir_usuario (String correo , String clave ){
        SQLiteDatabase db = this.getWritableDatabase();
         ContentValues cv = new ContentValues();

         cv.put(COLUMNA_CORREO, correo);
         cv.put(COLUMNA_CLAVE, clave);
         long result = db.insert(Nombre_tabla,null,cv);
         if (result == -1){
             Toast.makeText(context, "fallo :(", Toast.LENGTH_SHORT).show();
         }
         else {
             Toast.makeText(context, "insert realizado", Toast.LENGTH_SHORT).show();
         }

     }
 }
