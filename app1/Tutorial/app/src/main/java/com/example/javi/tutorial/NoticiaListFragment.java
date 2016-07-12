package com.example.javi.tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Javi on 12/07/2016.
 */
public class NoticiaListFragment extends ListFragment {
    ArrayList<Noticia> noticias;
    private static String ID="com.example.javi.tutorial.uuid";




    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        noticias = Generador.getInstance();


        NoticiasAdapter adapter = new NoticiasAdapter(noticias);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        //conocer la noticia seleccionada
        Noticia n = ((NoticiasAdapter)getListAdapter()).getItem(position);

        Intent i = new Intent(getActivity(),MainActivity.class);
        i.putExtra(NoticiaFragment.EXTRA_ID,n.getId());
        startActivity(i);

    }


    private class NoticiasAdapter extends ArrayAdapter<Noticia>{

        public NoticiasAdapter(ArrayList<Noticia> noticias){
            super(getActivity(),0,noticias);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            Noticia noticia = getItem(position);
            if(convertView == null){
                convertView = getActivity().getLayoutInflater()
                                .inflate(R.layout.fragment_list_noticias,null);
            }
            TextView titulo = (TextView)convertView.findViewById(R.id.fragment_list_text);

            titulo.setText(noticia.getNombre());

            return convertView;
        }


    }

}
