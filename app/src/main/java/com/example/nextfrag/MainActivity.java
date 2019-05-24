package com.example.nextfrag;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements big {
    Toolbar toolbar;



    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Fragment one");

       setSupportActionBar(toolbar);



        final FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment1 f1 = new Fragment1();
        fragmentTransaction.add(R.id.frag1, f1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                List<Fragment> f= fragmentManager.getFragments();
                Fragment frag=f.get(0);
                String currentfragment = frag.getClass().getSimpleName();
                check(currentfragment);

            }
        });

    }

    private void check(String currentfragment) {
    switch (currentfragment){
        case "Fragment1":
           toolbar.setTitle(currentfragment);
           break;
        case "Fragment2":
            toolbar.setTitle(currentfragment);
            break;
        case "Fragment3":
            toolbar.setTitle(currentfragment);
            break;
    }

    }


    @Override
    public void bigfrag(Fragment fragment, String title) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        toolbar.setTitle(title);
        fragmentTransaction.replace(R.id.frag1,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}


