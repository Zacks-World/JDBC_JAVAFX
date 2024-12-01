package org.example.demo.Controllers;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.example.demo.Models.Professeur;
import org.example.demo.ServiceImpl.IMetierImpl;

import java.sql.Date;
import java.sql.SQLException;

public class ProfController {
    private IMetierImpl professorService;
    public ProfController(){
        professorService = new IMetierImpl();
    }
    public boolean addProfessor(String nom, String prenom, String cin, String adresse, String telephone, String email, Date date_recrutement) throws SQLException {
        if (nom.isEmpty() || prenom.isEmpty() || cin.isEmpty() || adresse.isEmpty() || telephone.isEmpty() || email.isEmpty() || date_recrutement == null )
            return false;
        else {
            Professeur prof = new Professeur(nom, prenom, cin, adresse, telephone, email, date_recrutement); // ID auto-incremented
            professorService.AddProf(prof);
            return true;
        }

    }
    public void ProfReset(TextField NomField,TextField PrenomField,TextField CinField,TextField AdresseField,TextField TelephoneField,TextField EmailField,DatePicker DateRecrutementPicker){
        NomField.setText("");
        PrenomField.setText("");
        CinField.setText("");
        TelephoneField.setText("");
        EmailField.setText("");
        AdresseField.setText("");
        DateRecrutementPicker.setValue(null);

    }
    public void UpdateProfessor(int Id,String nom, String prenom, String cin, String adresse, String telephone, String email, Date date_recrutement) throws SQLException {
            Professeur prof = new Professeur(nom, prenom, cin, adresse, telephone, email, date_recrutement); // ID auto-incremented
            professorService.UpdateProfInfo(prof,Id);
    }
    public void DeleteProfessor(int Id) throws SQLException {
        professorService.DeleteProf(Id);
    }

}
