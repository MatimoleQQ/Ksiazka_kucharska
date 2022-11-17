package com.example.ksiazka_kucharska;

import static com.example.ksiazka_kucharska.MainActivity.EXTRA_KATEGORIA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
//    public static final String EXTRA_KATEGORIA = "id_kategoria";

    ArrayAdapter<Przepis> adapterPrzepisy;
    ListView listViewPrzepisy;
    public static final String EXTRA_IDPRZEPISU = "id_przepisu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int kategoria = (int) getIntent().getExtras().get(MainActivity.EXTRA_KATEGORIA);
        Toast.makeText(this, Integer.toString(kategoria), Toast.LENGTH_SHORT).show();
        ArrayList<Przepis> wybranePrzepisy = RepozytoriumPrzepisow.wybierzPrzepisy(kategoria);
        adapterPrzepisy = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wybranePrzepisy );

        listViewPrzepisy = findViewById(R.id.listView);
        listViewPrzepisy.setAdapter(adapterPrzepisy);
        listViewPrzepisy.setOnItemClickListener(
                (adapterView, view, i, l) -> {
                    Intent intencja = new Intent(MainActivity2.this, MainActivity3.class);
                    intencja.putExtra(EXTRA_IDPRZEPISU, i);
                    intencja.putExtra(EXTRA_KATEGORIA,kategoria);
                    startActivity(intencja);
                }
        );
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(view -> {
            EditText text = findViewById(R.id.editText);
            String nazwaPrzepisu = text.getText().toString();
            Przepis przepisDodany = new Przepis(nazwaPrzepisu,2, "safaedthh",R.drawable.lody);
            wybranePrzepisy.add(przepisDodany);
            adapterPrzepisy.notifyDataSetChanged();
        });
    }
}