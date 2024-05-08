package com.servlets;


import Beans.Etudiant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
public class EtudiantController {

    private List<Etudiant> etudiants = new ArrayList<>();

    @RequestMapping (value = "/" ,method = RequestMethod.GET)
    public String showEtudiantForm(Model model) {
        model.addAttribute("Etudiant", new Etudiant());
        return "Etudiant";
    }

    @RequestMapping(value = "/saveEtudiant",method = RequestMethod.POST)
    public String saveEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        return "redirect:/etudiants";
    }

    @RequestMapping("/etudiants")
    public String showEtudiants(Model model) {
        model.addAttribute("Etudiants", etudiants);
        return "Etudiants";
    }

    @RequestMapping(value = "/deleteEtudiant/{id}", method = RequestMethod.GET)
    public String deleteEtudiant(@PathVariable("id") Integer id) {
        // Find the etudiant by ID and remove it from the list
        etudiants.removeIf(etudiant -> etudiant.getId() == id);
        return "redirect:/etudiants";
    }
}
