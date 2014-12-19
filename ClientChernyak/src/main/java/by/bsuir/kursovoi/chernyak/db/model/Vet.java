package by.bsuir.kursovoi.chernyak.db.model;

import java.io.Serializable;
import java.util.Objects;

public class Vet extends DBaseObjectAbsrt implements Serializable{
    private String surname;
    private String name;
    private String lastname;
    private String date_of_birdth;
    private String adress;
    private String phone_num;
    private String hire_date;

    public Vet(){}
    
    public Vet(int id_vetdoctor) {
        this.setId(id_vetdoctor);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate_of_birdth() {
        return date_of_birdth;
    }

    public void setDate_of_birdth(String date_of_birdth) {
        this.date_of_birdth = date_of_birdth;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.getId();
        hash = 89 * hash + Objects.hashCode(this.surname);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.lastname);
        hash = 89 * hash + Objects.hashCode(this.date_of_birdth);
        hash = 89 * hash + Objects.hashCode(this.adress);
        hash = 89 * hash + Objects.hashCode(this.phone_num);
        hash = 89 * hash + Objects.hashCode(this.hire_date);
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
        final Vet other = (Vet) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.date_of_birdth, other.date_of_birdth)) {
            return false;
        }
        if (!Objects.equals(this.adress, other.adress)) {
            return false;
        }
        if (!Objects.equals(this.phone_num, other.phone_num)) {
            return false;
        }
        if (!Objects.equals(this.hire_date, other.hire_date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vet{" + "id=" + getId() + ", surname=" + surname + ", name=" + name + ", lastname=" + lastname + ", date_of_birdth=" + date_of_birdth + ", adress=" + adress + ", phone_num=" + phone_num + ", hire_date=" + hire_date + '}';
    }
    
    
}
