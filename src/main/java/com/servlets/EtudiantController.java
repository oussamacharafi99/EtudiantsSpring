package com.servlets;
import com.Beans.Etudiant;
import com.DAO.EtudiantsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EtudiantController {

    @Autowired
    private EtudiantsDAO etudiantsDAO;

    @RequestMapping (value = "/" )
    public String showHome(Model model) {
        return "home";
    }

    @RequestMapping (value = "/library" )
    public String ShowBooks(Model model) {
        return "library";
    }

    @RequestMapping (value = "/add" )
    public String showEtudiantForm(Model model) {
        model.addAttribute("Etudiant", new Etudiant());
        return "Etudiant";
    }

    @RequestMapping(value = "/saveEtudiant")
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

    @RequestMapping(value = "/deleteEtudiant/{id}")
    public String deleteEtudiant(@PathVariable("id") Integer id) {
        etudiantsDAO.supprimerEtudiants(id);
        return "redirect:/etudiants";
    }


    @RequestMapping(value = "/updateEtudiant/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Etudiant etudiant = etudiantsDAO.getEtudiantById(id);
        model.addAttribute("etudiant", etudiant);
        return "UpdateE";
    }

    @RequestMapping(value = "/updateEtudiant")
    public String getEtudiantById( Integer id, Etudiant etudiant) {
        etudiantsDAO.updateEtudiant(id, etudiant);
        return "redirect:/etudiants";
    }

    @GetMapping(value = "/searchByName")
    public String searchE(@RequestParam("search") String nom, Model model ) {
        model.addAttribute("Etudiants", etudiantsDAO.SearchEtudiant(nom) );
        return "Etudiants";
    }


}
