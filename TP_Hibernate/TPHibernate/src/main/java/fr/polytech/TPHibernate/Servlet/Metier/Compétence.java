package fr.polytech.TPHibernate.Servlet.Metier;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personnageCompétence")
public class Compétence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @ManyToOne
    @JoinColumn(name="idPerso", nullable=false)
    @JsonIgnore
    private Perso perso;

    public Compétence() {
    }

    public Compétence(int id, String nom, Perso perso) {
        this.id = id;
        this.nom = nom;
        this.perso = perso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Perso getPerso() {
        return perso;
    }

    public void setPerso(Perso perso) {
        this.perso = perso;
    }

    @Override
    public String toString() {
        return "Compétence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", perso=" + perso +
                '}';
    }
}
