package by.bsuir.kursovoi.chernyak.db.model;

import java.io.Serializable;
import java.util.Objects;

public class Brigade extends DBaseObjectAbsrt implements Serializable{
    private String surname;
    private String name;
    private String lastname;
    private String date_of_birdth;
    private int num_of_brigade;
    private String adress;
    private String phone_num;
    private String hire_date;
    
    public Brigade(){}
    
    public Brigade(int id_brigade) {
        this.setId(id_brigade);
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

    public int getNum_of_brigade() {
        return num_of_brigade;
    }

    public void setNum_of_brigade(int num_of_brigade) {
        this.num_of_brigade = num_of_brigade;
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
        int hash = 3;
        hash = 37 * hash + this.getId();
        hash = 37 * hash + Objects.hashCode(this.surname);
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.lastname);
        hash = 37 * hash + Objects.hashCode(this.date_of_birdth);
        hash = 37 * hash + this.num_of_brigade;
        hash = 37 * hash + Objects.hashCode(this.adress);
        hash = 37 * hash + Objects.hashCode(this.phone_num);
        hash = 37 * hash + Objects.hashCode(this.hire_date);
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
        final Brigade other = (Brigade) obj;
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
        if (this.num_of_brigade != other.num_of_brigade) {
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
        return "Brigade{" + "id=" + getId() +  ", surname=" + name + ", name=" + name + ", lastname=" + lastname + ", date_of_birdth=" + date_of_birdth + ", num_of_brigade=" + num_of_brigade + ", adress=" + adress + ", phone_num=" + phone_num + ", hire_date=" + hire_date + '}';
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
    
}
