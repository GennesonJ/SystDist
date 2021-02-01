import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "pers")
public class Personne implements Serializable {// objet de la classe Personne seront sérialisable

    //attribut de types private
    private int numero;
    private String nom;
    private String premon;

    // necessite un constructeur sans paramètre
    public Personne() {
        //super();
    }

    // éventuellement d'autre constructeurs avec paramètres
    public Personne(int numero, String nom, String premon) {
        //super();
        this.numero = numero;
        this.nom = nom;
        this.premon = premon;
    }

    // et les getters et setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPremon() {
        return premon;
    }

    public void setPremon(String premon) {
        this.premon = premon;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", premon='" + premon + '\'' +
                '}';
    }


}
