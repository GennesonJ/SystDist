import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "pers")
public class Product implements Serializable {

    //attribut de types private
    private int code;
    private String designation;
    private double prix;

    // necessite un constructeur sans paramètre
    public Product() {
        //super();
    }

    // éventuellement d'autre constructeurs avec paramètres
    public Product(int code, String designation, double prix) {
        //super();
        this.code = code;
        this.designation = designation;
        this.prix = prix;
    }

    // et les getters et setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", designation='" + designation + '\'' +
                ", prix=" + prix +
                '}';
    }
}
