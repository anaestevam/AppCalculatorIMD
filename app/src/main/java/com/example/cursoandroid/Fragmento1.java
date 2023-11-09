package com.example.cursoandroid;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import com.example.cursoandroid.R;

public class Fragmento1 extends Fragment implements View.OnClickListener {

    private TextView resultTextView;
    private StringBuilder currentNumber = new StringBuilder();
    private double firstOperand = Double.NaN;
    private String operator = "";

    public Fragmento1() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_fragmento1, container, false);

            resultTextView = view.findViewById(R.id.resultTextView);

            // Encontre e configure os botões numéricos e operadores
            for (int i = 0; i <= 9; i++) {
                int buttonId = getResources().getIdentifier("bt" + i, "id", getActivity().getPackageName());
                Button button = view.findViewById(buttonId);
                button.setOnClickListener((View.OnClickListener) this);
            }

            Button btSoma = view.findViewById(R.id.bt_soma);
            btSoma.setOnClickListener((View.OnClickListener) this);

            Button btSub = view.findViewById(R.id.bt_sub);
            btSub.setOnClickListener((View.OnClickListener) this);

            Button btIgual = view.findViewById(R.id.bt_igual);
            btIgual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    atualizarResultTextView();
                }
            });

            Button btDel = view.findViewById(R.id.bt_del);
            btDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clear();
                }
            });

            return view;
        }

        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            String buttonText = button.getText().toString();

            if (buttonText.matches("[0-9]")) {
                appendNumber(buttonText);
            } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("X") || buttonText.equals("/")) {
                operator = buttonText;
                operandos();
            } else if (buttonText.equals("DEL")) {
                clear();
            }
        }

        private void appendNumber(String number) {
            currentNumber.append(number);
            atualizarResultTextView();
        }

        private void operandos() {
            if (!currentNumber.toString().isEmpty()) {
                double secondOperand = Double.parseDouble(currentNumber.toString());
                switch (operator) {
                    case "+":
                        firstOperand += secondOperand;
                        break;
                    case "-":
                        firstOperand -= secondOperand;
                        break;
                    case "X":
                        firstOperand *= secondOperand;
                        break;
                    case "/":
                        firstOperand /= secondOperand;
                        break;
                    default:
                        firstOperand = secondOperand;
                }
            }

            clear();
            atualizarResultTextView();
        }

        private void clear() {
            currentNumber.setLength(0);
        }

        private void atualizarResultTextView() {
            resultTextView.setText(currentNumber.toString());
        }

}
