package com.DAO;
import com.Beans.Etudiant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EtudiantsDaoImp implements EtudiantsDAO{
    public static List<Etudiant> etudiants = new ArrayList<>();

    public EtudiantsDaoImp(){

    }

    @Override
    public List<Etudiant> afficherEtudiants() {
        return etudiants;
    }

    @Override
    public void ajouterEtudiants(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    @Override
    public void supprimerEtudiants(Integer id) {
        etudiants.removeIf(etudiant -> etudiant.getId() == id);
    }

    @Override
    public void updateEtudiants() {

    }
}
