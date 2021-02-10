package fr.polytech.TPHibernate.Servlet.Metier;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "personnageEquipement")
public class Equipement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    @ManyToMany
    @JoinTable( name = "persoequipement",
            joinColumns = @JoinColumn( name = "idEquipement" ),
            inverseJoinColumns = @JoinColumn( name = "idPerso" ) )
    @JsonIgnore
    private List<Perso> listPerso;

    public Equipement() {
    }

    public Equipement(int id, String nom, List<Perso> listPerso) {
        this.id = id;
        this.nom = nom;
        this.listPerso = listPerso;
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

    public List<Perso> getListPerso() {
        return listPerso;
    }

    public void setListPerso(List<Perso> listPerso) {
        this.listPerso = listPerso;
    }

    @Override
    public String toString() {
        return "Equipement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", listPerso=" + listPerso +
                '}';
    }
}
