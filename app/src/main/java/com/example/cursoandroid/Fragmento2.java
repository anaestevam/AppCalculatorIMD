package com.example.cursoandroid;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;


import com.example.cursoandroid.R;

public class Fragmento2 extends Fragment {
    private EditText nota01, nota02, nota03;
    private Button calcular;
    private TextView resultado;

    public Fragmento2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento2, container, false);
        return view;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento2, container, false);

        // Encontre os elementos da interface
        nota01 = view.findViewById(R.id.nota01);
        nota02 = view.findViewById(R.id.nota02);
        nota03 = view.findViewById(R.id.nota03);
        calcular = view.findViewById(R.id.calcular);
        resultado = view.findViewById(R.id.resultado);

        // Configurar o OnClickListener para o botão calcular
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularNotas();
            }
        });

        return view;
    }

    private void calcularNotas() {
        String nota01Str = nota01.getText().toString();
        String nota02Str = nota02.getText().toString();
        String nota03Str = nota03.getText().toString();

        if (nota01Str.isEmpty()) {
            Toast.makeText(getActivity(), "Digite a primeira nota.", Toast.LENGTH_SHORT).show();
            return;
        }

        double nota01Value = Double.parseDouble(nota01Str);

        if (nota02Str.isEmpty()) {
            // Calcula a nota necessária na 2ª e 3ª unidade para passar por média ou por nota
            double notaNecessariaMedia = (14.0 - nota01Value) / 2;
            double notaNecessariaNota = (10.0 - nota01Value) / 2;

            String mensagem = String.format("Com %.1f na 2ª e 3ª, você será aprovado por média e com %.1f, você será aprovado por nota.", notaNecessariaMedia, notaNecessariaNota);
            resultado.setText(mensagem);
        } else {
            double nota02Value = Double.parseDouble(nota02Str);

            if (nota03Str.isEmpty()) {
                // Calcula a nota necessária na 3ª unidade para passar
                double notaNecessaria = (21.0 - nota01Value - nota02Value);
                resultado.setText(String.format("Para passar, você precisa de %.1f na 3ª unidade.", notaNecessaria));
            } else {
                double nota03Value = Double.parseDouble(nota03Str);
                double media = (nota01Value + nota02Value + nota03Value) / 3.0;

                if (media >= 7.0) {
                    resultado.setText("Aprovado por média.");
                } else if (media >= 5.0) {
                    resultado.setText("Aprovado por nota.");
                } else {
                    resultado.setText("Reprovado.");
                }
            }
        }


    }


}