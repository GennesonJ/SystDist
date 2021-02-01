import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(targetNamespace = "http://www.polytech.nancy.fr")
public class MonService {

    public static List<Product> produits = new ArrayList<>();

    static {
        produits.add(new Product(1, "Tablette", 890));
        produits.add(new Product(2, "Routeur", 210));
        produits.add(new Product(3, "Switch", 450));
        produits.add(new Product(4, "Câble", 300));
    }

    public List<Product> affToutLesProd() {
        return produits;
    }

    public void ajoutProd(int code, String designation, double prix) {
        produits.add(new Product(code, designation, prix));
    }

    public void supprProd(int code) {
        for (Product p : produits) {
            if (p.getCode() == code) {
                produits.remove(p);
            }
        }
    }

    public List<Product> affToutLesProdSup(int mt) {
        List<Product> aux = new ArrayList<>();
        for (Product p : produits) {
            if (p.getPrix() > mt) {
                aux.add(p);
            }
        }
        return aux;
    }


    @WebMethod(operationName = "convertir")
    public double convertir(@WebParam(name = "mt") double mt) {
        return mt * 1.6;
    }

    @WebMethod(operationName = "mamethodesomme")
    public double somme(double a) {
        return a + a;
    }

    public Product affProd(int code) {
        return new Product(code, "tablette", 1200);
    }



}
