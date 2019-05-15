package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText input_uang;
    Button rp_usd,rp_eur,rp_yen;
    TextView hasil_konversi;
    double angka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_uang =(EditText) findViewById(R.id.input_uang);
        rp_usd=(Button) findViewById(R.id.rp_usd);
        rp_eur=(Button) findViewById(R.id.rp_eur);
        rp_yen=(Button) findViewById(R.id.rp_yen);
        hasil_konversi=(TextView) findViewById(R.id.hasil_konversi);

    }
    public boolean cek(){
        if(input_uang.getText().toString().isEmpty()){
            Toast.makeText(this,"Silahkan Masukkan Jumlah Uang",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void toYEN(View v) {
        if (!cek()) {
            return;
        }
        try {
            angka = Double.parseDouble(input_uang.getText().toString());
        } catch (Exception ex) {
            Toast.makeText(this, "masukkan Angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka / 132;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.JAPAN).format(hasil));
        Toast.makeText(this, "1 YEN = Rp 132", Toast.LENGTH_SHORT).show();
    }
        public void toEUR(View v){
            if(!cek()){
                return;
            }
            try{
                angka= Double.parseDouble(input_uang.getText().toString());
            }catch(Exception ex){
                Toast.makeText(this,"masukkan Angka",Toast.LENGTH_SHORT).show();
            }

            double hasil=angka/17228;
            hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.GERMANY).format(hasil));
            Toast.makeText(this,"1 EUR = Rp 17228",Toast.LENGTH_SHORT).show();
        }
      public void toUSD(View v){
        if(!cek()){
            return;
        }
        try{
            angka= Double.parseDouble(input_uang.getText().toString());
        }catch(Exception ex){
            Toast.makeText(this,"masukkan Angka",Toast.LENGTH_SHORT).show();
        }

        double hasil=angka/14808;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.US).format(hasil));
        Toast.makeText(this,"1 USD = Rp 14808",Toast.LENGTH_SHORT).show();
    }

}
