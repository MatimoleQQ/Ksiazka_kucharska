package com.example.ksiazka_kucharska;

public class Przepis {
    private String nazwa;
    private int kategoria;
    private String listaSkladnikow;
    private int idObrazka;

    public Przepis(String nazwa, int kategoria, String listaSkladnikow, int idObrazka) {
        this.nazwa = nazwa;
        this.kategoria = kategoria;
        this.listaSkladnikow = listaSkladnikow;
        this.idObrazka = idObrazka;
    }

    @Override
    public String toString() {
        return "Przepis{" +
                "nazwa='" + nazwa + '\'' +
                '}';
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getKategoria() {
        return kategoria;
    }

    public String getListaSkladnikow() {
        return listaSkladnikow;
    }

    public int getIdObrazka() {
        return idObrazka;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setKategoria(int kategoria) {
        this.kategoria = kategoria;
    }

    public void setListaSkladnikow(String listaSkladnikow) {
        this.listaSkladnikow = listaSkladnikow;
    }

    public void setIdObrazka(int idObrazka) {
        this.idObrazka = idObrazka;
    }
}
