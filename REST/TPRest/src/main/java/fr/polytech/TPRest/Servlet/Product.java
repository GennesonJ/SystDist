package fr.polytech.TPRest.Servlet;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
    String nom;
    int prix;

    public Product() {
    }

    public Product(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
