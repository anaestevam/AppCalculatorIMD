package com.example.cursoandroid;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.cursoandroid.R;

public class Fragmento1 extends Fragment {

    public Fragmento1() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Button bt08;

        View view = inflater.inflate(R.layout.fragment_fragmento1, container, false);
        bt08 = view.findViewById(R.id.bt08);

        bt08.setOnClickListener(view1 -> Toast.makeText(getActivity(), "Olá Mundo", Toast.LENGTH_LONG).show());
        return view;
    }

    void testar(View v){

    }
}
