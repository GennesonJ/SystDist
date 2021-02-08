package fr.polytech.TPRest.Servlet.DBManager;

import fr.polytech.TPRest.Servlet.Metier.Perso;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import static fr.polytech.TPRest.Servlet.DBManager.HibernateFactory.getSession;
public class PersoManager {
    /**
     * Permet de récupérer tous les magasins
     *
     * @return liste de tous les magasins
     */
    public Perso create(Perso perso) {
        Session session = getSession();
        session.beginTransaction();
        session.save(perso.getIdDetails());
        session.getTransaction().commit();
        session.beginTransaction();
        session.save(perso);
        session.getTransaction().commit();
        return perso;
    }

    public List<Perso> getAll() {
        Session session = getSession();
        Query query = session.createQuery("select perso from Perso as perso");
        return query.getResultList();
    }

    public Perso update(Perso perso) {
        Session session = getSession();
        session.beginTransaction();
        session.update(perso);
        session.getTransaction().commit();
        return perso;
    }

    public Perso delete(Perso perso) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(perso);
        session.getTransaction().commit();
        return perso;
    }

}