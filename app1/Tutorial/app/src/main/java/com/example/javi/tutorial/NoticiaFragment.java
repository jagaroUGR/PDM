package com.example.javi.tutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Javi on 12/07/2016.
 */
public class NoticiaFragment extends Fragment {
    Noticia noticia;
    private TextView nombre;
    private TextView texto;
    private TextView fecha;
    public static String EXTRA_ID="com.example.javi.tutorial.uuid";


    public static NoticiaFragment newInstance(UUID id){
        NoticiaFragment fragment = new NoticiaFragment();

        Bundle arg = new Bundle();
        arg.putSerializable(EXTRA_ID,id);

        fragment.setArguments(arg);

        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        UUID id = (UUID)getArguments().getSerializable(EXTRA_ID);
        ArrayList<Noticia> noticias = Generador.getInstance();

        for (int i = 0; i < noticias.size(); i++) {
            if (noticias.get(i).getId().equals(id)) {
                noticia = noticias.get(i);
                break;
            }
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
                             ,Bundle savedInstanceState){

        super.onCreateView(inflater,container,savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_noticia,container,false);

        nombre = (TextView)v.findViewById(R.id.textoTitulo);
        nombre.setText(noticia.getNombre());

        texto = (TextView)v.findViewById(R.id.textoNoticia);
        texto.setText(noticia.getTexto());

        fecha = (TextView)v.findViewById(R.id.textoFecha);
        fecha.setText(noticia.getFecha().toString());

        return v;
    }
}
