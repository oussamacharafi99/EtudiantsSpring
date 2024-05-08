package com.DAO;

import com.Beans.Etudiant;

import java.util.List;

public interface EtudiantsDAO {
    public List<Etudiant> afficherEtudiants();
    public void ajouterEtudiants(Etudiant etudiant);
    public void supprimerEtudiants(Integer id);
    public void updateEtudiants();
}
