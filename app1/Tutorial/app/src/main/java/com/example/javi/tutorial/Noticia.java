package com.example.javi.tutorial;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Javi on 12/07/2016.
 */
public class Noticia {
    private UUID id;
    private String nombre;
    private Date fecha;
    private String texto;

    public Noticia(UUID idNoticia, String tituloNoticia, String textoNoticia, Date fechaNoticia ){
        id=idNoticia;
        fecha = fechaNoticia;
        nombre = tituloNoticia;
        texto=textoNoticia;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getTexto() {
        return texto;
    }

    public UUID getId() {
        return id;
    }






}
