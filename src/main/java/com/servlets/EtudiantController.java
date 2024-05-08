package com.servlets;


import com.Beans.Etudiant;
import com.DAO.EtudiantsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EtudiantController {

    @Autowired
    private EtudiantsDAO etudiantsDAO;

    @RequestMapping (value = "/" ,method = RequestMethod.GET)
    public String showEtudiantForm(Model model) {
        model.addAttribute("Etudiant", new Etudiant());
        return "Etudiant";
    }

    @RequestMapping(value = "/saveEtudiant",method = RequestMethod.POST)
    public String saveEtudiant(Etudiant etudiant) {
        etudiantsDAO.ajouterEtudiants(etudiant);
        //etudiants.add(etudiant);
        return "redirect:/etudiants";
    }

    @RequestMapping("/etudiants")
    public String showEtudiants(Model model) {
        model.addAttribute("Etudiants", etudiantsDAO.afficherEtudiants());
        return "Etudiants";
    }

    @RequestMapping(value = "/deleteEtudiant/{id}", method = RequestMethod.GET)
    public String deleteEtudiant(@PathVariable("id") Integer id) {
        etudiantsDAO.supprimerEtudiants(id);
        return "redirect:/etudiants";
    }
}
