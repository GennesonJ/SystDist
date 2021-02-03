package fr.polytech.TPRest.Servlet;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
    int code;
    String nom;
    double prix;

    public Product() {
    }

    public Product(int code, String nom, double prix) {
        this.code = code;
        this.nom = nom;
        this.prix = prix;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
