package fr.polytech.TPHibernate.Servlet.Metier;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personnageDetails")
public class PersoDetails implements Serializable{

        @javax.persistence.Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int Id;
        @Column(name = "age")
        private int Age;
        @Column(name = "sexe")
        private String Sexe;

    public PersoDetails() {
    }

    public PersoDetails(int id, int age, String sexe) {
        Id = id;
        Age = age;
        Sexe = sexe;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String sexe) {
        Sexe = sexe;
    }

    @Override
    public String toString() {
        return "PersoDetails{" +
                "Id=" + Id +
                ", Age='" + Age + '\'' +
                ", Sexe='" + Sexe + '\'' +
                '}';
    }
}
