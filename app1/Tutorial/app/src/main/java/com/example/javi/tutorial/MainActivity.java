package com.example.javi.tutorial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends FragmentActivity {
    private static String FRAGMENTO="com.example.javi.tutorial.fragmento";
    private Noticia noticia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fm = getSupportFragmentManager();
        NoticiaFragment fragment = (NoticiaFragment)fm.findFragmentById(R.id.frame_activity);
        UUID id = (UUID)getIntent().getSerializableExtra(NoticiaFragment.EXTRA_ID);

        if(fragment==null){
            fragment = NoticiaFragment.newInstance(id);
            fm.beginTransaction()
                    .add(R.id.frame_activity,fragment)
                    .commit();
        }

    }
}
