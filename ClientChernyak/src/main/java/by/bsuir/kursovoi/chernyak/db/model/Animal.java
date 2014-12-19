package by.bsuir.kursovoi.chernyak.db.model;

import java.io.Serializable;
import java.util.Objects;

public class Animal extends DBaseObjectAbsrt implements Serializable{
    private String kind;
    private String species;
    private String sex;
    private String date_of_capture;
    private String place_of_capture;
    private String sterilization;
    private int num_aviary;
    private int id_vetdoctor;
    private int id_brigade;
    
    public Animal(){}
    
    public Animal(int id_animal) {
        this.setId(id_animal);
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate_of_capture() {
        return date_of_capture;
    }

    public void setDate_of_capture(String date_of_capture) {
        this.date_of_capture = date_of_capture;
    }

    public String getPlace_of_capture() {
        return place_of_capture;
    }

    public void setPlace_of_capture(String place_of_capture) {
        this.place_of_capture = place_of_capture;
    }

    public String getSterilization() {
        return sterilization;
    }

    public void setSterilization(String sterilization) {
        this.sterilization = sterilization;
    }

    public int getNum_aviary() {
        return num_aviary;
    }

    public void setNum_aviary(int num_aviary) {
        this.num_aviary = num_aviary;
    }

    public int getId_vetdoctor() {
        return id_vetdoctor;
    }

    public void setId_vetdoctor(int id_vetdoctor) {
        this.id_vetdoctor = id_vetdoctor;
    }

    public int getId_brigade() {
        return id_brigade;
    }

    public void setId_brigade(int id_brigade) {
        this.id_brigade = id_brigade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.getId();
        hash = 89 * hash + Objects.hashCode(this.kind);
        hash = 89 * hash + Objects.hashCode(this.species);
        hash = 89 * hash + Objects.hashCode(this.sex);
        hash = 89 * hash + Objects.hashCode(this.date_of_capture);
        hash = 89 * hash + Objects.hashCode(this.place_of_capture);
        hash = 89 * hash + Objects.hashCode(this.sterilization);
        hash = 89 * hash + this.num_aviary;
        hash = 89 * hash + this.id_vetdoctor;
        hash = 89 * hash + this.id_brigade;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (!Objects.equals(this.kind, other.kind)) {
            return false;
        }
        if (!Objects.equals(this.species, other.species)) {
            return false;
        }
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        if (!Objects.equals(this.date_of_capture, other.date_of_capture)) {
            return false;
        }
        if (!Objects.equals(this.place_of_capture, other.place_of_capture)) {
            return false;
        }
        if (!Objects.equals(this.sterilization, other.sterilization)) {
            return false;
        }
        if (this.num_aviary != other.num_aviary) {
            return false;
        }
        if (this.id_vetdoctor != other.id_vetdoctor) {
            return false;
        }
        if (this.id_brigade != other.id_brigade) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" +  "id=" + getId() +  ", kind=" + kind + ", species=" + species + ", sex=" + sex + ", date_of_capture=" + date_of_capture + ", place_of_capture=" + place_of_capture + ", sterilization=" + sterilization + ", num_aviary=" + num_aviary + ", id_vetdoctor=" + id_vetdoctor + ", id_brigade=" + id_brigade + '}';
    }
    
    
}
