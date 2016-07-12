package com.example.javi.tutorial;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created by Javi on 12/07/2016.
 */
public class Generador {
    private static ArrayList<Noticia> noticias;

    private Generador(){
        String texto="Texto ejemplo que mostrará el de la noticia";
        Calendar c = Calendar.getInstance();
        noticias = new ArrayList<Noticia>();
        for(int i=1;i<20;i++){
            noticias.add(i-1,new Noticia(UUID.randomUUID()
            ,"Noticia " + Integer.toString(i), texto, c.getTime()));
        }

    }

    public static ArrayList<Noticia> getInstance(){
        if(noticias == null)
            new Generador();

        return noticias;
    }

}
