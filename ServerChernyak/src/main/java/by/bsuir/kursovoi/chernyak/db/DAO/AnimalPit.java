
package by.bsuir.kursovoi.chernyak.db.DAO;

import by.bsuir.kursovoi.chernyak.db.ConnectorDB;
import by.bsuir.kursovoi.chernyak.db.model.Animal;
import by.bsuir.kursovoi.chernyak.db.model.DBaseObjectAbsrt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnimalPit implements AnimalPitInter{
    @Override
    public List getAnimalPit() {
        Animal animal = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List animals = new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM animal");
            rs = ps.executeQuery();
            while(rs.next()) {
                animal = new Animal(rs.getInt("id_animal"));
                animal.setKind(rs.getString("kind"));
                animal.setSpecies(rs.getString("species"));
                animal.setSex(rs.getString("sex"));
                animal.setDate_of_capture(rs.getString("date_of_capture"));
                animal.setPlace_of_capture(rs.getString("place_of_capture"));
                animal.setSterilization(rs.getString("sterilization"));
                animal.setNum_aviary(rs.getInt("num_aviary"));
                animal.setId_vetdoctor(rs.getInt("id_vetdoctor"));
                animal.setId_brigade(rs.getInt("id_brigade"));
                animals.add(animal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnimalPit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return animals;
    }

    @Override
    public int create(DBaseObjectAbsrt object) {
        Animal animal = (Animal) object;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO animal (kind, species, sex, date_of_capture, place_of_capture, sterilization, num_aviary, id_vetdoctor, id_brigade) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, animal.getKind());
            ps.setString(2, animal.getSpecies());
            ps.setString(3, animal.getSex());
            ps.setString(4, animal.getDate_of_capture());
            ps.setString(5, animal.getPlace_of_capture());
            ps.setString(6, animal.getSterilization());
            ps.setInt(7, animal.getNum_aviary());
            ps.setInt(8, animal.getId_vetdoctor());
            ps.setInt(9, animal.getId_brigade());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AnimalPit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DBaseObjectAbsrt read(int id) {
        Animal animal = new Animal(id);
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT kind, species, sex, date_of_capture, place_of_capture, sterilization, num_aviary, id_vetdoctor, id_brigade FROM animal WHERE id_animal = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            animal.setKind(rs.getString("kind"));
            animal.setSpecies(rs.getString("species"));
            animal.setSex(rs.getString("sex"));
            animal.setDate_of_capture(rs.getString("date_of_capture"));
            animal.setPlace_of_capture(rs.getString("place_of_capture"));
            animal.setSterilization(rs.getString("sterilization"));
            animal.setNum_aviary(rs.getInt("num_aviary"));
            animal.setId_vetdoctor(rs.getInt("id_vetdoctor"));
            animal.setId_brigade(rs.getInt("id_brigade"));
        } catch (SQLException ex) {
            Logger.getLogger(AnimalPit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return animal;
    }

    @Override
    public void update( DBaseObjectAbsrt newObj) {
        Animal newAnimal = (Animal) newObj;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE animal SET kind = ?, species = ?, sex = ?, date_of_capture = ?, place_of_capture = ?, sterilization = ?, num_aviary = ?, id_vetdoctor = ?, id_brigade = ? WHERE id_animal = ?");
            ps.setString(1, newAnimal.getKind());
            ps.setString(2, newAnimal.getSpecies());
            ps.setString(3, newAnimal.getSex());
            ps.setString(4, newAnimal.getDate_of_capture());
            ps.setString(5, newAnimal.getPlace_of_capture());
            ps.setString(6, newAnimal.getSterilization());
            ps.setInt(7, newAnimal.getNum_aviary());
            ps.setInt(8, newAnimal.getId_vetdoctor());
            ps.setInt(9, newAnimal.getId_brigade());
            ps.setInt(10, newAnimal.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("DELETE FROM animal WHERE id_animal = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }
    
    private void finallyBlock(Statement ps, ResultSet rs) {
        try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DBaseObjectAbsrt getAnimalPitByName(String kind) {
        Animal animal = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_animal, kind, species, sex, date_of_capture, place_of_capture, sterilization, num_aviary, id_vetdoctor, id_brigade FROM animal WHERE kind = ?");
            ps.setString(1, kind);
            rs = ps.executeQuery();
            rs.next();
            animal = new Animal(rs.getInt("id_animal"));
            animal.setKind(rs.getString("kind"));
            animal.setSpecies(rs.getString("species"));
            animal.setSex(rs.getString("sex"));
            animal.setDate_of_capture(rs.getString("date_of_capture"));
            animal.setPlace_of_capture(rs.getString("place_of_capture"));
            animal.setSterilization(rs.getString("sterilization"));
            animal.setNum_aviary(rs.getInt("num_aviary"));
            animal.setId_vetdoctor(rs.getInt("id_vetdoctor"));
            animal.setId_brigade(rs.getInt("id_brigade"));
        } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return animal;
    }

    @Override
    public List getAnimalFilterByKind(String str) {
        Animal animal = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List animals = new ArrayList();
        try{
            connection = dbcp.getConnection();
            String sql = "SELECT * FROM animal WHERE kind LIKE '%" +str+ "%'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                animal = new Animal(rs.getInt("id_animal"));
            animal.setKind(rs.getString("kind"));
            animal.setSpecies(rs.getString("species"));
            animal.setSex(rs.getString("sex"));
            animal.setDate_of_capture(rs.getString("date_of_capture"));
            animal.setPlace_of_capture(rs.getString("place_of_capture"));
            animal.setSterilization(rs.getString("sterilization"));
            animal.setNum_aviary(rs.getInt("num_aviary"));
            animal.setId_vetdoctor(rs.getInt("id_vetdoctor"));
            animal.setId_brigade(rs.getInt("id_brigade"));
            animals.add(animal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return animals;
    }
    
    @Override
    public List getAnimalFilterBySpecies(String str) {
        Animal animal = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List animals = new ArrayList();
        try{
            connection = dbcp.getConnection();
            String sql = "SELECT * FROM animal WHERE species LIKE '%" +str+ "%'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                animal = new Animal(rs.getInt("id_animal"));
            animal.setKind(rs.getString("kind"));
            animal.setSpecies(rs.getString("species"));
            animal.setSex(rs.getString("sex"));
            animal.setDate_of_capture(rs.getString("date_of_capture"));
            animal.setPlace_of_capture(rs.getString("place_of_capture"));
            animal.setSterilization(rs.getString("sterilization"));
            animal.setNum_aviary(rs.getInt("num_aviary"));
            animal.setId_vetdoctor(rs.getInt("id_vetdoctor"));
            animal.setId_brigade(rs.getInt("id_brigade"));
            animals.add(animal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return animals;
    }
    
    @Override
    public List getAnimalFilterBySex(String str) {
        Animal animal = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List animals = new ArrayList();
        try{
            connection = dbcp.getConnection();
            String sql = "SELECT * FROM animal WHERE sex LIKE '%" +str+ "%'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                animal = new Animal(rs.getInt("id_animal"));
            animal.setKind(rs.getString("kind"));
            animal.setSpecies(rs.getString("species"));
            animal.setSex(rs.getString("sex"));
            animal.setDate_of_capture(rs.getString("date_of_capture"));
            animal.setPlace_of_capture(rs.getString("place_of_capture"));
            animal.setSterilization(rs.getString("sterilization"));
            animal.setNum_aviary(rs.getInt("num_aviary"));
            animal.setId_vetdoctor(rs.getInt("id_vetdoctor"));
            animal.setId_brigade(rs.getInt("id_brigade"));
            animals.add(animal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return animals;
    }
    
    @Override
    public int getStatCountCat(String str)
    {
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0; 
        try{
            connection = dbcp.getConnection();
            String sql = "SELECT * FROM animal WHERE kind LIKE '%" +str+ "%'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
            count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return count;
    }
    
    @Override
    public int getStatCountDog(String str)
    {
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0; 
        try{
            connection = dbcp.getConnection();
            String sql = "SELECT * FROM animal WHERE kind LIKE '%" +str+ "%'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
            count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return count;
    }
}
