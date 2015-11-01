package com.example.sebastien.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
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
            if(mega.isChecked()){
                result.setText(R.string.libelleMegaIsOk);
            }
            else {
                String t = taille.getText().toString();
                String p = poids.getText().toString();

                float tailleValue = 0;
                float poidsValue = 0;

                if((!t.isEmpty())&&(!p.isEmpty())) {
                    tailleValue = Float.valueOf(t);
                    poidsValue = Float.valueOf(p);
                }

                if ((tailleValue <= 0) || (poidsValue <= 0) ) {
                    result.setText(R.string.libelleResultatError);
                } else {
                    if(group.getCheckedRadioButtonId() == R.id.radioCentimetre) {
                        tailleValue = tailleValue / 100;
                    }
                    float imc = poidsValue / (float)Math.pow(tailleValue,2);
                    String imcString = getResources().getString(R.string.libelleResultatCalcul) + " " + String.valueOf(imc);
                    result.setText(imcString);
                }
            }
        }
    };

    public OnClickListener clickListenerBoutonRaz = new OnClickListener() {
        @Override
        public void onClick(View v) {
            result.setText(R.string.libelleAucunResultat);
            taille.getText().clear();
            poids.getText().clear();
            group.check(R.id.radioMetre);
            mega.setChecked(false);
        }
    };

    public OnClickListener checkMega = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!((CheckBox)v).isChecked() && result.getText().equals(getResources().getString(R.string.libelleMegaIsOk)))
                result.setText(R.string.libelleAucunResultat);
        }
    };


    private TextWatcher textWatcher = new TextWatcher(){
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
          result.setText(R.string.libelleAucunResultat);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
          int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* Premier exercice avec Layout  */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculerIMC = (Button) findViewById(R.id.buttonCalculerIMC);
        raz = (Button) findViewById(R.id.buttonRAZ);

        result = (TextView)findViewById(R.id.textViewAucunResultat);
        poids = (EditText)findViewById(R.id.editTextPoids);
        taille = (EditText)findViewById(R.id.editTextTaille);
        mega = (CheckBox)findViewById(R.id.checkBoxMegaFonction);
        group = (RadioGroup)findViewById(R.id.radioGroup);

        group.check(R.id.radioMetre);

        calculerIMC.setOnClickListener(clickListenerBoutonCalculIMC);
        raz.setOnClickListener(clickListenerBoutonRaz);
        mega.setOnClickListener(checkMega);
        taille.addTextChangedListener(textWatcher);
        poids.addTextChangedListener(textWatcher);

    }


}
