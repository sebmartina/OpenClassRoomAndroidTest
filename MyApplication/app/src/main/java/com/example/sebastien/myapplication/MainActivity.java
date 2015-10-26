package com.example.sebastien.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button calculerIMC = null;
    Button raz = null;

    EditText poids = null;
    EditText taille = null;

    RadioGroup group = null;

    TextView result = null;

    CheckBox mega = null;

    public OnClickListener clickListenerBoutonCalculIMC = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String t = taille.getText().toString();
            String p = poids.getText().toString();

            float tailleValue = Float.valueOf(t);
            float poidsValue = Float.valueOf(p);

            if((tailleValue == 0)||(poidsValue == 0)) {

            }
            else {
                float imc = poidsValue / tailleValue;
                result.setText("Votre IMC est " + String.valueOf(imc));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* Premier exercice avec Layout  */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculerIMC = (Button) findViewById(R.id.buttonCalculerIMC);
        result = (TextView)findViewById(R.id.textViewAucunResultat);
        poids = (EditText)findViewById(R.id.editTextPoids);
        taille = (EditText)findViewById(R.id.editTextTaille);

        calculerIMC.setOnClickListener(clickListenerBoutonCalculIMC);

    }
}
