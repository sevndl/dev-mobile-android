package fr.epsi.shop;

import java.io.Serializable;

public class Etudiants implements Serializable {

    private String  Nom;
    private String Prenom;
    private String Email;
    private String Groupe;
    private String Photo;

    public Etudiants (String nom, String prenom, String email, String groupe, String photo) {
        this.Nom = nom;
        this.Prenom = prenom;
        this.Email = email;
        this.Groupe = groupe;
        this.Photo = photo;
    }

    public String getNom() {
        return this.Nom;
    }

    public String getPrenom(){
        return this.Prenom;
    }

    public String getEmail(){
        return this.Email;
    }

    public String getGroupe(){
        return this.Groupe;
    }

    public String getPhoto(){
        return this.Photo;
    }



    public void setNom(String nom) {
        this.Nom = nom;
    }

    public void setPrenom(String prenom) {
        this.Prenom = prenom;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setGroupe(String groupe) {
        this.Groupe = groupe;
    }

    public void setPhoto(String photo){
        this.Photo = photo;
    }

}
