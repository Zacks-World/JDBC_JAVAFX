package org.example.demo.Utils.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SignletonConnexionDB {
    // Informations de connexion
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_professeurs";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // Instance unique de la connexion
    public static Connection connection = null;

    // Constructeur privé pour empêcher l'instanciation
    private SignletonConnexionDB() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion : " + e.getMessage());
        }
    }

    // Méthode publique pour obtenir l'instance unique de la connexion
    public static Connection getConnection() {
        if (connection == null) {
            synchronized (SignletonConnexionDB.class) { // Synchronisation pour la sécurité en multithreading
                if (connection == null) {
                    new SignletonConnexionDB();
                }
            }
        }
        return connection;
    }
}
