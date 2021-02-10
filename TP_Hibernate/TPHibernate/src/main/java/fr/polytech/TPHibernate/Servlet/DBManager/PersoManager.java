package fr.polytech.TPHibernate.Servlet.DBManager;

import fr.polytech.TPHibernate.Servlet.Metier.Compétence;
import fr.polytech.TPHibernate.Servlet.Metier.Equipement;
import fr.polytech.TPHibernate.Servlet.Metier.Perso;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class PersoManager {

    //Créer un perso avec ses détails (OneToOne)
    public Perso create(Perso perso) {
        Session session = HibernateFactory.getSession();
        session.beginTransaction();
        session.save(perso.getIdDetails()); // Créer détails
        session.getTransaction().commit();
        session.beginTransaction();
        session.save(perso);                //Créer perso
        session.getTransaction().commit();
        return perso;
    }

    //Récup tout les perso
    public List<Perso> getAll() {
        Session session = HibernateFactory.getSession();
        Query query = session.createQuery("select perso from Perso as perso");
        return query.getResultList();
    }

    //Met à jour un perso
    public Perso update(Perso perso) {
        Session session = HibernateFactory.getSession();
        session.beginTransaction();
        session.update(perso);
        session.getTransaction().commit();
        return perso;
    }

    //Suppr un perso
    public Perso delete(Perso perso) {
        Session session = HibernateFactory.getSession();
        session.beginTransaction();
        session.delete(perso);
        session.getTransaction().commit();
        return perso;
    }

    //Ajout une compétence à un perso, on renseigne l'id du perso dans les attribut de la compétence (OneToMany - ManyToOne)
    public Compétence addCommpetence(Compétence comp) {
        Session session = HibernateFactory.getSession();
        session.beginTransaction();
        session.save(comp);
        session.getTransaction().commit();
        return comp;
    }

    //Ajout + création équipement ou ajout équipement existant (ManyToMany)
    public Perso addEquipement(Equipement equipement,int id) {
        Perso perso = findPerso(id);
        Session session = HibernateFactory.getSession();
        session.beginTransaction();
        if(findEquip(equipement.getId())==null){
            session.save(equipement);
        }
        perso.addEquipement(findEquip(equipement.getId()));
        session.merge(perso);
        session.getTransaction().commit();
        return perso;
    }

    //Recup un perso avec son id
    public Perso findPerso(int id) {
        Session session = HibernateFactory.getSession();
        Query query = session.createQuery("select perso from Perso as perso where perso.id = :id");
        query.setParameter("id",id);
        return (Perso) query.getSingleResult();
    }

    //Recup un equipement avec son id
    public Equipement findEquip(int id) {
        Session session = HibernateFactory.getSession();
        Query query = session.createQuery("select equip from Equipement as equip where equip.id = :id");
        query.setParameter("id",id);
        return (Equipement) query.getSingleResult();
    }
}