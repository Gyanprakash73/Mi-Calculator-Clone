package com.gyan.calculator.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gyan.calculator.R;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class EqualtoFragment extends Fragment {

    TextView workingsTV;
    TextView resultsTV;
    Button btnAc,btnPercent,btn7,btn8,btn9,btn4,btn5,btn6,btn1,btn2,btn3,btn0,btnDot;
    ImageButton btnBackspace,btnDivide,btnMultiply,btnMinus,btnPlus,btnMoreOpt,btnEqual;
    String workings = "";
    int lastindex;
    char last;

    public EqualtoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_equalto, container, false);

        workingsTV=view.findViewById(R.id.workingsTextView);
        resultsTV=view.findViewById(R.id.resultTextView);
        btnAc=view.findViewById(R.id.btnAc);
        btnPercent=view.findViewById(R.id.btnPercent);
        btn7=view.findViewById(R.id.btn7);
        btn8=view.findViewById(R.id.btn8);
        btn9=view.findViewById(R.id.btn9);
        btn4=view.findViewById(R.id.btn4);
        btn5=view.findViewById(R.id.btn5);
        btn6=view.findViewById(R.id.btn6);
        btn1=view.findViewById(R.id.btn1);
        btn2=view.findViewById(R.id.btn2);
        btn3=view.findViewById(R.id.btn3);
        btn0=view.findViewById(R.id.btn0);
        btnDot=view.findViewById(R.id.btnDot);
        btnBackspace=view.findViewById(R.id.btnBackspace);
        btnDivide=view.findViewById(R.id.btnDivide);
        btnMultiply=view.findViewById(R.id.btnMultiply);
        btnMinus=view.findViewById(R.id.btnMinus);
        btnPlus=view.findViewById(R.id.btnPlus);
        btnMoreOpt=view.findViewById(R.id.btnMoreOpt);
        btnEqual=view.findViewById(R.id.btnEqual);

        btnMoreOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Clear Button
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workingsTV.setText("0");
                workings="";
                resultsTV.setText("");
            }
        });

        //Back Button
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()>=1){
                    workings=workings.substring(0,workings.length()-1);
                    workingsTV.setText(workings);
                }
                if (workings.length()<1){
                    workingsTV.setText("0");
                    resultsTV.setText("");
                }
            }
        });

        //Equalto Button
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();

                //If last charecter is (+, -, * and /) the remove this charecter
                char lc=workings.charAt(workings.length()-1);
                if (lc=='+'||lc=='−'||lc=='×'||lc=='÷'){
                    workings = workings.replaceAll(".$", "");
                }

                workings=workings.replaceAll("−","-");
                workings=workings.replaceAll("×","*");
                workings=workings.replaceAll("÷","/");

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult="";
                Scriptable scriptable=rhino.initStandardObjects();
                finalResult=rhino.evaluateString(scriptable,workings,"Javascript",1,null).toString();

                resultsTV.setText(finalResult);
                workingsTV.setText(finalResult);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()<=1) {
                    char fc=workings.charAt(0);
                    if (fc=='1'||fc=='2'||fc=='3'||fc=='4'||fc=='5'||fc=='6'||fc=='7'||fc=='8'||fc=='9'){
                        setworking("0");
                    }
                }else {
                    setworking("0");
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()<=1) {
                    if (workings.charAt(0)=='0'){
                        workingsTV.setText("1");
                    }else {
                        setworking("1");
                    }
                }else {
                    setworking("1");
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()<=1) {
                    if (workings.charAt(0)=='0'){
                        workingsTV.setText("2");
                    }else {
                        setworking("2");
                    }
                }else {
                    setworking("2");
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()<=1) {
                    if (workings.charAt(0)=='0'){
                        workingsTV.setText("3");
                    }else {
                        setworking("3");
                    }
                }else {
                    setworking("3");
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()<=1) {
                    if (workings.charAt(0)=='0'){
                        workingsTV.setText("4");
                    }else {
                        setworking("4");
                    }
                }else {
                    setworking("4");
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()<=1) {
                    if (workings.charAt(0)=='0'){
                        workingsTV.setText("5");
                    }else {
                        setworking("5");
                    }
                }else {
                    setworking("5");
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()<=1) {
                    if (workings.charAt(0)=='0'){
                        workingsTV.setText("6");
                    }else {
                        setworking("6");
                    }
                }else {
                    setworking("6");
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()<=1) {
                    if (workings.charAt(0)=='0'){
                        workingsTV.setText("7");
                    }else {
                        setworking("7");
                    }
                }else {
                    setworking("7");
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()<=1) {
                    if (workings.charAt(0)=='0'){
                        workingsTV.setText("8");
                    }else {
                        setworking("8");
                    }
                }else {
                    setworking("8");
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()<=1) {
                    if (workings.charAt(0)=='0'){
                        workingsTV.setText("9");
                    }else {
                        setworking("9");
                    }
                }else {
                    setworking("9");
                }
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                lastindex=workings.indexOf(last);
                int dotcompair = workings.indexOf('.',lastindex);
                if (dotcompair==-1){
                    setworking(".");
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()!=0){
                    last = workings.charAt(workings.length() -1);
                    if(last=='+' || last=='−' || last=='×' || last=='÷'){
                        workings=workings.substring(0, workings.length()-1) + "+";
                        workingsTV.setText(workings);
                    }else {
                        setworking("+");
                    }
                }else {
                    setworking("+");
                }
                workings=workingsTV.getText().toString();
                last = workings.charAt(workings.length() -1);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()!=0){
                    last = workings.charAt(workings.length() -1);
                    if(last=='+' || last=='−' || last=='×' || last=='÷'){
                        workings=workings.substring(0, workings.length()-1) + "−";
                        workingsTV.setText(workings);
                    }else {
                        setworking("−");
                    }
                }else {
                    setworking("−");
                }
                workings=workingsTV.getText().toString();
                last = workings.charAt(workings.length() -1);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()!=0){
                    last = workings.charAt(workings.length() -1);
                    if(last=='+' || last=='−' || last=='×' || last=='÷'){
                        workings=workings.substring(0, workings.length()-1) + "×";
                        workingsTV.setText(workings);
                    }else {
                        setworking("×");
                    }
                }else {
                    setworking("×");
                }
                workings=workingsTV.getText().toString();
                last = workings.charAt(workings.length() -1);
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();
                if (workings.length()!=0){
                    last = workings.charAt(workings.length() -1);
                    if(last=='+' || last=='−' || last=='×' || last=='÷'){
                        workings=workings.substring(0, workings.length()-1) + "÷";
                        workingsTV.setText(workings);
                    }else {
                        setworking("÷");
                    }
                }else {
                    setworking("÷");
                }
                workings=workingsTV.getText().toString();
                last = workings.charAt(workings.length() -1);
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workings=workingsTV.getText().toString();

                char lc=workings.charAt(workings.length()-1);
                if (lc=='+'||lc=='−'||lc=='×'||lc=='÷'){
                    workings = workings.replaceAll(".$", "");
                }

                String newString=workings.substring(workings.indexOf(last)+1);
                if (workings.length()<=1){
                    char fc=workings.charAt(0);
                    if (fc=='1'||fc=='2'||fc=='3'||fc=='4'||fc=='5'||fc=='6'||fc=='7'||fc=='8'||fc=='9'){
                        double no = Double.parseDouble(newString) / 100;
                        workingsTV.setText(no+"");
                    }
                }else {
                    double no = Double.parseDouble(newString) / 100;
                    workingsTV.setText(no+"");
                }
            }
        });

        return view;
    }

    private void setworking(String i) {
        workings=workingsTV.getText().toString();
        workingsTV.setText(workings+i);
    }

}