import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.ws.Endpoint;
import java.io.File;

public class Application {

    public static void main(String[] args) { //throws JAXBException {
        // traite les exceptions
/*
        // Sérialisation avec la classe Personne
        // Résultat dans result.xml

        try{
            JAXBContext jc = JAXBContext.newInstance(Personne.class);
            Personne p = new Personne(1,"GENNESON","Jérémy");
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(p,new File("result.xml"));



        }catch (JAXBException e){
            e.printStackTrace();
            System.out.println("Je ne trouve pas la classe");
        }
        System.out.println("Fin de programme");
*/

        // WebService avec la classe MonService et Product

        String url = "http://localhost:8989/";
        Endpoint.publish(url, new MonService());
        System.out.println("http://localhost:8989/?wsdl");


    }

}
