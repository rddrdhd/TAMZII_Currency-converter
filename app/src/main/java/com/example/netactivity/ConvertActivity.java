package com.example.netactivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConvertActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        final EditText editNum1, editNum2;
        TextView txtStat1, txtNazev1, txtCena1, txtKod1,
                txtStat2, txtNazev2, txtCena2, txtKod2;
        ImageView vlajka1, vlajka2;


        Bundle extras = getIntent().getExtras();

        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        txtStat1 = findViewById(R.id.txtStat1);
        txtStat2 = findViewById(R.id.txtStat2);
        txtCena1 = findViewById(R.id.txtCena1);
        txtCena2 = findViewById(R.id.txtCena2);
        txtKod1 = findViewById(R.id.txtKod1);
        txtKod2 = findViewById(R.id.txtKod2);
        txtNazev1 = findViewById(R.id.txtNazev1);
        txtNazev2 = findViewById(R.id.txtNazev2);
        vlajka1 = findViewById(R.id.imageView1);
        vlajka2 = findViewById(R.id.imageView2);

        editNum1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                Bundle extras = getIntent().getExtras();
                Double czk = Double.valueOf(editNum1.getText().toString());
                Double kurz = Double.valueOf(extras.getString("cena"));

                editNum2.setText(Double.toString(czk/kurz));
            }
        });


        if(extras == null) {
            Toast.makeText(getApplicationContext(),"Neco se pokazilo, sorka", Toast.LENGTH_LONG).show();
        } else {
            //TODO set (czk?) values
            txtCena1.setText("1.00");
            txtStat1.setText("Česká republika");
            txtKod1.setText("CZK");
            txtNazev1.setText("koruna");
            vlajka1.setImageResource(R.drawable.flag_cz);

            //clicked currency values
            String kod = extras.getString("kod");
            String imgName = "flag_"+kod.toLowerCase();
            int id = getApplicationContext().getResources().getIdentifier(imgName, "drawable", getApplicationContext().getPackageName());
            vlajka2.setImageResource(id);

            txtCena2.setText(extras.getString("cena"));
            txtStat2.setText(extras.getString("stat"));
            txtKod2.setText(kod);
            txtNazev2.setText(extras.getString("nazev"));
        }
    }


}
