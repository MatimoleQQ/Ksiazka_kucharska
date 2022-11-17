package com.example.ksiazka_kucharska;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listViewKategorie;
    public static final String EXTRA_KATEGORIA = "idKategorii";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewKategorie = findViewById(R.id.listView);
        listViewKategorie.setOnItemClickListener(
                (adapterView, view, i, l) -> {
//                    String kategoria = adapterView.getItemAtPosition(i).toString();
//                    Toast.makeText(this, kategoria + " pod indeksem " + i, Toast.LENGTH_SHORT).show();

                    wyswietlNowaAktywnosc(i);
                });
    }
    private void wyswietlNowaAktywnosc(int kategoria){
        Intent intencja = new Intent(this, MainActivity2.class);
        intencja.putExtra(EXTRA_KATEGORIA,kategoria);
                startActivity(intencja);
    }
}
//MainActivity2 - Lista przepisow