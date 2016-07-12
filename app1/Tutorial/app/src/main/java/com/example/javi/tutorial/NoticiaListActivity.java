package com.example.javi.tutorial;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

import java.util.ArrayList;


/**
 * Created by Javi on 12/07/2016.
 */
public class NoticiaListActivity extends FragmentActivity {
    private NoticiaListFragment listFragment;


    @Override
    public void onCreate(Bundle savedStateInstance){
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_list_noticias);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if(fragment==null){
            fragment = new NoticiaListFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer,fragment)
                    .commit();
        }


    }

}
