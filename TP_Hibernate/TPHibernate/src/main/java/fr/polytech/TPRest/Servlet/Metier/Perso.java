package fr.polytech.TPRest.Servlet.Metier;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personnage")
public class Perso implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "nom")
    private String Nom;
    @Column(name = "niveau")
    private String Niveau;
    @OneToOne
    @JoinColumn(name = "idDetails", referencedColumnName = "id")
    private PersoDetails idDetails;


    public Perso() {
    }

    public Perso(int id, String nom, String niveau, PersoDetails idDetails) {
        Id = id;
        Nom = nom;
        Niveau = niveau;
        this.idDetails = idDetails;
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

    public PersoDetails getIdDetails() {
        return idDetails;
    }

    public void setIdDetails(PersoDetails idDetails) {
        this.idDetails = idDetails;
    }

    @Override
    public String toString() {
        return "Perso{" +
                "Id=" + Id +
                ", Nom='" + Nom + '\'' +
                ", Niveau='" + Niveau + '\'' +
                ", idDetails=" + idDetails +
                '}';
    }
}


