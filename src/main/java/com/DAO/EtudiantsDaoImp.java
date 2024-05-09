package com.DAO;
import com.Beans.Etudiant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
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
    public void updateEtudiant(Integer id, Etudiant updatedEtudiant) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getId() == id) {
                etudiant.setNom(updatedEtudiant.getNom());
                etudiant.setEmail(updatedEtudiant.getEmail());
                etudiant.setMessage(updatedEtudiant.getMessage());
                break; // Once updated, exit loop
            }
        }
    }

    @Override
    public Etudiant getEtudiantById(Integer id) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getId() == id) {
                return etudiant;
            }
        }

        return null;
    }

    @Override
    public List<Etudiant> SearchEtudiant(String name) {
            List<Etudiant> etudiantSearch = new ArrayList<>();
            for (Etudiant etudiant : etudiants) {
                if (etudiant.getNom().toLowerCase().contains(name.toLowerCase())) {
                    etudiantSearch.add(etudiant);
                }
            }
        return etudiantSearch;
    }


}
