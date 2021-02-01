package fr.polytech.TPRest.Servlet;


public class Pokemon {
    String Nom;
    String Niveau;

    public Pokemon() {
    }

    public Pokemon(String Nom, String Niveau) {
        this.Nom = Nom;
        this.Niveau = Niveau;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String Niveau) {
        this.Niveau = Niveau;
    }

    @Override
    public String toString() {
        return "Pokemon[Nom=" + Nom + ", Niveau=" + Niveau + "]";
    }
}


