package Beans;

public class Etudiant {
    public Integer getId() {
        return id;
    }

    public void setId(Integer matricule) {
        this.id = matricule;
    }

    private Integer id;
    private String nom;
    private String email;
    private String message;

    // Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
