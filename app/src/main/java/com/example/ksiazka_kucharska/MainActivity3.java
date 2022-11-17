package com.example.ksiazka_kucharska;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    public static final String EXTRA_IDPRZEPISU = "id_przepisu";
    public static final String EXTRA_KATEGORIA = "id_kategoria";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        int ktoryPrzepis = getIntent().getExtras().getInt(MainActivity2.EXTRA_IDPRZEPISU,0);
        int kategoria = getIntent().getExtras().getInt(MainActivity.EXTRA_KATEGORIA,0);
        Przepis przepis = RepozytoriumPrzepisow.wybierzPrzepisy(kategoria).get(ktoryPrzepis);
        ImageView img = findViewById(R.id.imageView);
        img.setImageResource(przepis.getIdObrazka());
        TextView tvTytul  = findViewById(R.id.textViewTytul);
        TextView tvOpis  = findViewById(R.id.textViewSkladniki);
        tvTytul.setText(przepis.getNazwa());
        tvOpis.setText(przepis.getListaSkladnikow());
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            //Musisz kazda aktywnosc zrobic w manifescie
            //W manifescie dodac filtr do wysylania sms
            Intent intencja = new Intent();
            intencja.setAction(Intent.ACTION_SEND);
            intencja.putExtra(Intent.EXTRA_TEXT, przepis.getNazwa() + " " + przepis.getListaSkladnikow() + " Smacznego! Jak se zrobisz ");
            intencja.setType("text/plain");
            Intent podzielSieIntencja = Intent.createChooser(intencja, null);
            startActivity(podzielSieIntencja);
        });

    }
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);

    }
}