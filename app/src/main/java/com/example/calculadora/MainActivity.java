package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//mmm
public class MainActivity extends AppCompatActivity {
    Button[] botones_numeros = new Button[10];
    Button[] botones_operacion = new Button[4];
    Button igual;
    Button limpiar;
    int operacion;
    TextView display;
    TextView display2;
    TextView display3;
    TextView display4;
    String str_display = "";
    int operando1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.resultado);
        display2 = findViewById(R.id.resultado2);
        display3 = findViewById(R.id.resultado3);
        display4 = findViewById(R.id.resultado4);
        igual = findViewById(R.id.respuesta);
        limpiar = findViewById(R.id.limpiar);
        AsignarBotones();
        AsignarEventos();
    }

    void AsignarBotones(){
        botones_numeros[0] = findViewById(R.id.btn0);
        botones_numeros[1] = findViewById(R.id.btn1);
        botones_numeros[2] = findViewById(R.id.btn2);
        botones_numeros[3] = findViewById(R.id.btn3);
        botones_numeros[4] = findViewById(R.id.btn4);
        botones_numeros[5] = findViewById(R.id.btn5);
        botones_numeros[6] = findViewById(R.id.btn6);
        botones_numeros[7] = findViewById(R.id.btn7);
        botones_numeros[8] = findViewById(R.id.btn8);
        botones_numeros[9] = findViewById(R.id.btn9);

        botones_operacion[0] = findViewById(R.id.sumar);
        botones_operacion[1] = findViewById(R.id.restar);
        botones_operacion[2] = findViewById(R.id.multiplicar);
        botones_operacion[3] = findViewById(R.id.dividir);

    }

    void AsignarEventos(){
        for(int i = 0; i <10 ; i++){
            final int finalI = i;
            botones_numeros[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    str_display += finalI;
                    display.setText(str_display);
                    display2.setText(str_display);
                    display.setText("");
                }
            });
        }

        for(int i = 0; i <4 ; i++){
            final int finalI = i;
            botones_operacion[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    EjecutarOperacion();
                    display3.setText(str_display);
                    display2.setText("");
                    display3.setText("");
                    display4.setText("");
                    display3.setText(str_display);
                    if (operacion == 0) {
                        display4.setText(" + ");
                    }else if (operacion == 1) {
                        display4.setText(" - ");
                    }else if (operacion == 2) {
                        display4.setText(" * ");
                    }else if (operacion == 3) {
                        display4.setText(" / ");
                    }
                    display4.setText("");

                    operando1 = Integer.parseInt(str_display);
                    operacion = finalI;
                    str_display = "";

                    if (operacion == 0) {
                        display4.setText(" + ");
                    }else if (operacion == 1) {
                        display4.setText(" - ");
                    }else if (operacion == 2) {
                        display4.setText(" * ");
                    }else if (operacion == 3) {
                        display4.setText(" / ");
                    }
                }
            });
        }


        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EjecutarOperacion();
            }
        });
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operando1 = 0 * Integer.parseInt(str_display);
                str_display = String.valueOf(operando1);
                display.setText(str_display);
                operando1 = 0;
                display2.setText("");
                display3.setText("");
                display4.setText("");
            }
        });
    }

    void EjecutarOperacion(){
        if (operando1 != 0 && !str_display.equals("")) {
            if (operacion == 0) {
                operando1 = operando1 + Integer.parseInt(str_display);
                display4.setText(" + ");
            } else if (operacion == 1) {
                operando1 = operando1 - Integer.parseInt(str_display);
                display4.setText(" - ");
            } else if (operacion == 2) {
                operando1 = operando1 * Integer.parseInt(str_display);
                display4.setText(" * ");
            } else if (operacion == 3) {
                operando1 = operando1 / Integer.parseInt(str_display);
                display4.setText(" / ");
            }
            display2.setText(str_display);

            str_display = String.valueOf(operando1);
            display.setText("= " + str_display);
            operando1 = 0;
        }
    }
}