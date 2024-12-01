package org.example.demo.Models;

import java.util.ArrayList;
import java.util.List;

public class Departement {
    private int id_depart;
    private String nom;
    private List<Professeur> Professeurs ;

    public Departement( String nom) {
        this.nom = nom;
        Professeurs = new ArrayList<>();
    }

    public Departement() {
    }

    public int getId_depart() {
        return id_depart;
    }

    public void setId_depart(int id_depart) {
        this.id_depart = id_depart;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Professeur> getProfesseurs() {
        return Professeurs;
    }

    public void setProfesseurs(Professeur professeur) {
        Professeurs.add(professeur);
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id_depart=" + id_depart +
                ", nom='" + nom + '\'' +
                '}';
    }
}

