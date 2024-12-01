package org.example.demo.ServiceImpl;

import org.example.demo.Models.Departement;
import org.example.demo.Models.Professeur;
import org.example.demo.Services.IMetier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.demo.Utils.DBConnect.SignletonConnexionDB.connection;

public class IMetierImpl implements IMetier {

    @Override
    public List<Professeur> ShowProfs() throws SQLException {
        List<Professeur> professeurs = new ArrayList<>();
        Statement stm=connection.createStatement();
        String query = "SELECT * FROM professeur";
        ResultSet resultSet=stm.executeQuery(query);
        while (resultSet.next()) {
            Professeur professeur = new Professeur();
            professeur.setId_prof(resultSet.getInt("id_prof"));
            professeur.setNom(resultSet.getString("nom"));
            professeur.setPrenom(resultSet.getString("prenom"));
            professeur.setCin(resultSet.getString("cin"));
            professeur.setAdresse(resultSet.getString("adresse"));
            professeur.setTelephone(resultSet.getString("telephone"));
            professeur.setEmail(resultSet.getString("email"));
            professeur.setDate_recrutement(resultSet.getDate("date_recrutement"));
            // Add more fields based on your `professeurs` table structure
            professeurs.add(professeur);
        }
        return professeurs;
    }

    @Override
    public List<Professeur> SearchProfsByKey(String Key) throws SQLException {
        List<Professeur> professeurs = new ArrayList<>();
        String query = "SELECT * FROM professeur WHERE id_prof = ? OR nom LIKE ? OR prenom LIKE ? OR cin LIKE ? OR adresse LIKE ? OR telephone LIKE ? OR email LIKE ? OR date_recrutement = ?";
        String likeKeyword = "%" + Key + "%";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,likeKeyword);
        preparedStatement.setString(2,likeKeyword);
        preparedStatement.setString(3,likeKeyword);
        preparedStatement.setString(4,likeKeyword);
        preparedStatement.setString(5,likeKeyword);
        preparedStatement.setString(6,likeKeyword);
        preparedStatement.setString(7,likeKeyword);
        preparedStatement.setString(8,likeKeyword);

        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()) {
            Professeur professeur = new Professeur();
            professeur.setId_prof(resultSet.getInt("id_prof"));
            professeur.setNom(resultSet.getString("nom"));
            professeur.setPrenom(resultSet.getString("prenom"));
            professeur.setCin(resultSet.getString("cin"));
            professeur.setAdresse(resultSet.getString("adresse"));
            professeur.setTelephone(resultSet.getString("telephone"));
            professeur.setEmail(resultSet.getString("email"));
            professeur.setDate_recrutement(resultSet.getDate("date_recrutement"));
            // Add more fields based on your `professeurs` table structure
            professeurs.add(professeur);
        }
        return professeurs;
    }

    @Override
    public void AddProf(Professeur prof) throws SQLException {
        String query = "INSERT INTO professeur (nom, prenom, cin, adresse, telephone, email, date_recrutement) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,prof.getNom());
        preparedStatement.setString(2,prof.getPrenom());
        preparedStatement.setString(3,prof.getCin());
        preparedStatement.setString(4,prof.getAdresse());
        preparedStatement.setString(5,prof.getTelephone());
        preparedStatement.setString(6,prof.getEmail());
        preparedStatement.setDate(7,prof.getDate_recrutement());
        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new professor was inserted successfully!");
        }
        else System.out.println("A new professor was not inserted!");
    }
    @Override
    public void DeleteProf(int Id_prof) throws SQLException {
        String query="DELETE FROM professeur WHERE id_prof = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,Id_prof);
        int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A professor was deleted successfully!");
        }
        else System.out.println("A professor was not deleted!");
    }

    @Override
    public void UpdateProfInfo(Professeur Prof,int Id) throws SQLException {
        String query = "UPDATE professeur SET nom = ?, prenom = ?, cin = ?, adresse = ?, telephone = ?, email = ?, date_recrutement = ? WHERE id_prof = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,Prof.getNom());
        preparedStatement.setString(2,Prof.getPrenom());
        preparedStatement.setString(3,Prof.getCin());
        preparedStatement.setString(4,Prof.getAdresse());
        preparedStatement.setString(5,Prof.getTelephone());
        preparedStatement.setString(6,Prof.getEmail());
        preparedStatement.setDate(7,Prof.getDate_recrutement());
        preparedStatement.setInt(8,Id);
        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("A professor was updated successfully!");
        }
        else System.out.println("A professor was not updated!");

    }

    @Override
    public void AffectProfToDep(Professeur Prof,Departement Dep) throws SQLException {
        Prof.setDepartement(Dep);
        Dep.setProfesseurs(Prof);
        String query = "UPDATE professeur SET id_depart = ? WHERE id_prof = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,Prof.getDepartement().getId_depart());
        preparedStatement.setInt(2,Prof.getId_prof());
        int ProfAffectedToDep = preparedStatement.executeUpdate();
        if (ProfAffectedToDep > 0) {
            System.out.println("A professor was affected successfully!");
        }
        else System.out.println("A professor was not affected!");
    }

    @Override
    public void AddDep(Departement Dep) throws SQLException {
        String query = "INSERT INTO departement (nom) VALUES (?)";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,Dep.getNom());
        int RowsInserted = preparedStatement.executeUpdate();
        if (RowsInserted > 0) {
            System.out.println("A new department was inserted successfully!");
        }
        else System.out.println("A new department was not inserted!");

    }

    @Override
    public List<Departement> ShowDep() throws SQLException {
        List<Departement> Deps = new ArrayList<>();
        Statement stm=connection.createStatement();
        String query = "SELECT * FROM departement";
        ResultSet resultSet=stm.executeQuery(query);
        while (resultSet.next()) {
            Departement Dep = new Departement();
            Dep.setId_depart(resultSet.getInt("id_depart"));
            Dep.setNom(resultSet.getString("nom"));
            // Add more fields based on your `professeurs` table structure
            Deps.add(Dep);
        }
        return Deps;

    }

    @Override
    public void DeleteDep(int id_depart) throws SQLException {
        String query1="UPDATE professeur SET id_depart = NULL WHERE id_depart = ?";
        PreparedStatement preparedStatement1=connection.prepareStatement(query1);
        preparedStatement1.setInt(1,id_depart);
        preparedStatement1.executeUpdate();
        String query2="DELETE FROM departement WHERE id_depart = ?";
        PreparedStatement preparedStatement2=connection.prepareStatement(query2);
        preparedStatement2.setInt(1,id_depart);
        int rowsDeleted = preparedStatement2.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A departement was deleted successfully!");
        }
        else System.out.println("A departement was not deleted!");
    }

    @Override
    public void UpdateDep(Departement Dep,int Id) throws SQLException {
        String query = "UPDATE departement SET nom = ? where id_depart = Id";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,Dep.getNom());
        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("A departement was updated  successfully!");
        }
        else System.out.println("A departement was not updated!");
    }

    @Override
    public List<Professeur> ShowDepProfs(Departement Dep) throws SQLException {
        List<Professeur> professeurs = new ArrayList<>();
        String query = "SELECT * FROM professeur WHERE id_depart = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,Dep.getId_depart());
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()) {
            Professeur professeur = new Professeur();
            professeur.setId_prof(resultSet.getInt("id_prof"));
            professeur.setNom(resultSet.getString("nom"));
            professeur.setPrenom(resultSet.getString("prenom"));
            professeur.setCin(resultSet.getString("cin"));
            professeur.setAdresse(resultSet.getString("adresse"));
            professeur.setTelephone(resultSet.getString("telephone"));
            professeur.setEmail(resultSet.getString("email"));
            professeur.setDate_recrutement(resultSet.getDate("date_recrutement"));
            // Add more fields based on your `professeurs` table structure
            professeurs.add(professeur);
        }
        return professeurs;
    }
}
