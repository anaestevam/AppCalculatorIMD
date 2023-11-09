package com.example.cursoandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private Fragmento1 frag1;
    private Fragmento2 frag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag1 = new Fragmento1();
        frag2 = new Fragmento2();
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.frameL01, frag1);
        fm.commit();
    }
    public void irFragmento1(View view){
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.frameL01, frag1);
        fm.commit();
    }

    public void irFragmento2(View view){
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.frameL01, frag2);
        fm.commit();
    }
}