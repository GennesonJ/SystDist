package fr.polytech.TPHibernate.Servlet.Metier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity //Qualifie la classe comme une entité qui existe en bdd
@Table(name = "personnage") //Précise le nom de la table coté bdd
public class Perso implements Serializable {
    @Id//Précise que l'attribut de la classe est la clé primaire de la table
    @Column(name = "id")//Précise le nom de la colonne coté bdd
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Permet l'auto-incrémentation
    private int Id;
    @Column(name = "nom")
    private String Nom;
    @Column(name = "niveau")
    private String Niveau;
    @OneToOne//Précise que l'attribut est associé à une relation de type OneToOne
    @JoinColumn(name = "idDetails", referencedColumnName = "id")//Précise que les attribut liés sont idDetails de la table personnage et id de la table detail
    private PersoDetails idDetails;
    @OneToMany( targetEntity=Compétence.class, mappedBy="perso" ) ////Présice que l'attribut est associé à une relation de type OneToMany (@ManyToOne dans la classe metier Competence)
    private List<Compétence> idCompetence = new ArrayList<>();
    @ManyToMany//Précise que l'attribut est associé à une relation de type ManyToMany
    @JoinTable( name = "persoequipement",
            joinColumns = @JoinColumn( name = "idPerso" ),
            inverseJoinColumns = @JoinColumn( name = "idEquipement" ) )//Précise que les attribut liés sont idPerso et idEquipement de la table persoequipement(table d'association)
    private List<Equipement> idEquipement;


    //Constructeurs
    public Perso() {
    }

    public Perso(int id, String nom, String niveau, PersoDetails idDetails, List<Compétence> idCompetence, List<Equipement> idEquipement) {
        Id = id;
        Nom = nom;
        Niveau = niveau;
        this.idDetails = idDetails;
        this.idCompetence = idCompetence;
        this.idEquipement = idEquipement;
    }


    //Getters and Setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String niveau) {
        Niveau = niveau;
    }

    public PersoDetails getIdDetails() {
        return idDetails;
    }

    public void setIdDetails(PersoDetails idDetails) {
        this.idDetails = idDetails;
    }

    public List<Compétence> getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(List<Compétence> idCompetence) {
        this.idCompetence = idCompetence;
    }

    public List<Equipement> getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(List<Equipement> idEquipement) {
        this.idEquipement = idEquipement;
    }

    //Ajout un équipement à l'objet
    public void addEquipement (Equipement e){
        this.idEquipement.add(e);
    }

    //Format d'affichage de données
    @Override
    public String toString() {
        return "Perso{" +
                "Id=" + Id +
                ", Nom='" + Nom + '\'' +
                ", Niveau='" + Niveau + '\'' +
                ", idDetails=" + idDetails +
                ", idCompetence=" + idCompetence +
                ", idEquipement=" + idEquipement +
                '}';
    }
}


