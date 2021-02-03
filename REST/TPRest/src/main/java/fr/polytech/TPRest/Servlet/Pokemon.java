package fr.polytech.TPRest.Servlet;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pokemon")
public class Pokemon implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "nom")
    private String Nom;
    @Column(name = "niveau")
    private String Niveau;


    public Pokemon() {
    }

    public Pokemon(int id, String nom, String niveau) {
        Id = id;
        Nom = nom;
        Niveau = niveau;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
        return "Pokemon{" +
                "Id=" + Id +
                ", Nom='" + Nom + '\'' +
                ", Niveau='" + Niveau + '\'' +
                '}';
    }
}


