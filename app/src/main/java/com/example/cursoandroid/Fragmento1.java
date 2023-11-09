package com.example.cursoandroid;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

public class Fragmento1 extends Fragment implements View.OnClickListener {

    private TextView resultTextView;
    private StringBuilder currentNumber = new StringBuilder();
    private double firstOperand = Double.NaN;
    private String operator = "";
    private boolean newOperation = true; // Começa com uma nova operação

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

        for (int i = 0; i <= 9; i++) {
            int buttonId = getResources().getIdentifier("bt" + i, "id", getActivity().getPackageName());
            Button button = view.findViewById(buttonId);
            button.setOnClickListener(this);
        }

        Button btSoma = view.findViewById(R.id.bt_soma);
        btSoma.setOnClickListener(this);

        Button btSub = view.findViewById(R.id.bt_sub);
        btSub.setOnClickListener(this);

        Button btIgual = view.findViewById(R.id.bt_igual);
        btIgual.setOnClickListener(this);

        Button btDel = view.findViewById(R.id.bt_del);
        btDel.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttonText = button.getText().toString();

        if (buttonText.matches("[0-9]")) {
            if (newOperation) {
                currentNumber.setLength(0);
                newOperation = false;
            }
            appendNumber(buttonText);
        } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("X") || buttonText.equals("/")) {
            operator = buttonText;
            firstOperand = Double.parseDouble(currentNumber.toString());
            newOperation = true;
        } else if (buttonText.equals("DEL")) {
            clear();
        } else if (buttonText.equals("=")) {
            if (!Double.isNaN(firstOperand) && !newOperation) {
                operandos();
                newOperation = true;
            }
        }
    }

    private void appendNumber(String number) {
        currentNumber.append(number);
        atualizarResultTextView();
    }

    private void operandos() {
        double secondOperand = Double.parseDouble(currentNumber.toString());
        double result = firstOperand;

        switch (operator) {
            case "+":
                result += secondOperand;
                break;
            case "-":
                result -= secondOperand;
                break;
            case "X":
                result *= secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    result /= secondOperand;
                } else {
                    Toast.makeText(getActivity(), "Operação não permitida", Toast.LENGTH_SHORT).show();
                    clear();
                    atualizarResultTextView();
                    return;
                }
                break;
        }

        firstOperand = result;
        currentNumber.setLength(0);
        currentNumber.append(result);
        atualizarResultTextView();
    }

    private void clear() {
        currentNumber.setLength(0);
        firstOperand = Double.NaN;
        operator = "";
        atualizarResultTextView();
    }

    private void atualizarResultTextView() {
        resultTextView.setText(currentNumber.toString());
    }
}
