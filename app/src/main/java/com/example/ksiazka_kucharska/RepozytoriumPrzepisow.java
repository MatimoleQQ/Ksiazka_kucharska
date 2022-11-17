package com.example.ksiazka_kucharska;

import java.sql.Array;
import java.util.ArrayList;

public class RepozytoriumPrzepisow {
    public static final Przepis[] przepisy = {
            new Przepis("Mufinki", 2," mąka cukier mleko kakao ",R.drawable.mufinki),
            new Przepis("Piernik", 2," mąka cukier mleko kakao ",R.drawable.piernik),
            new Przepis("Gofry", 2," mąka cukier mleko kakao ",R.drawable.gofry),
            new Przepis("Lody", 2," mąka cukier mleko kakao ",R.drawable.lody)

    };
    public static ArrayList<Przepis> wybierzPrzepisy (int kategoria){
        ArrayList<Przepis> wybrane = new ArrayList<>();
        for (Przepis x: przepisy){
            if(x.getKategoria() == kategoria)
                wybrane.add(x);
        }

        return wybrane;
    }
}
