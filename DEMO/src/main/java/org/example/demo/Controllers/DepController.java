package org.example.demo.Controllers;

import org.example.demo.Models.Departement;
import org.example.demo.Models.Professeur;
import org.example.demo.ServiceImpl.IMetierImpl;

import java.sql.Date;
import java.sql.SQLException;

public class DepController {
    private IMetierImpl DepService;
    public DepController(){
        DepService = new IMetierImpl();
    }
    public boolean addDep(String nom) throws SQLException {
        if (nom.isEmpty())
            return false;
        else {
            Departement Dep = new Departement(nom); // ID auto-incremented
            DepService.AddDep(Dep);
            return true;
        }

    }
}
