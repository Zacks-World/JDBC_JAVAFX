package org.example.demo.Services;

import org.example.demo.Models.Departement;
import org.example.demo.Models.Professeur;

import java.sql.SQLException;
import java.util.List;

public interface IMetier {
    List<Professeur> ShowProfs() throws SQLException;
    List<Professeur> SearchProfsByKey(String Key) throws SQLException;
    void AddProf(Professeur Prof) throws SQLException;
    void DeleteProf(int Id_prof) throws SQLException;
    void UpdateProfInfo(Professeur Prof,int Id) throws SQLException;
    void AffectProfToDep(Professeur Prof,Departement Dep) throws SQLException;
    void AddDep(Departement departement) throws SQLException;
    List<Departement> ShowDep() throws SQLException;
    void DeleteDep(int int_depart) throws SQLException;
    void UpdateDep(Departement Dep,int Id) throws SQLException;
    List<Professeur> ShowDepProfs(Departement Dep) throws SQLException;











}
