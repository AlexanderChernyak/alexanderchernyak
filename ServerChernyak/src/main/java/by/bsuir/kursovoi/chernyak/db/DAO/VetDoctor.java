package by.bsuir.kursovoi.chernyak.db.DAO;

import by.bsuir.kursovoi.chernyak.db.ConnectorDB;
import by.bsuir.kursovoi.chernyak.db.model.DBaseObjectAbsrt;
import by.bsuir.kursovoi.chernyak.db.model.Vet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VetDoctor implements VetDoctorInter {

    @Override
    public List getVetDoctor() {
        Vet vet = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List vetDoctors = new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM vetdoctor");
            rs = ps.executeQuery();
            while(rs.next()) {
                vet = new Vet(rs.getInt("id_vetdoctor"));
                vet.setSurname(rs.getString("surname"));
                vet.setName(rs.getString("name"));
                vet.setLastname(rs.getString("lastname"));
                vet.setDate_of_birdth(rs.getString("date_of_birdth"));
                vet.setAdress(rs.getString("adress"));
                vet.setPhone_num(rs.getString("phone_num"));
                vet.setHire_date(rs.getString("hire_date"));
                vetDoctors.add(vet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VetDoctor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return vetDoctors;
    }

    @Override
    public int create(DBaseObjectAbsrt object) {
        Vet vet = (Vet) object;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO vetdoctor (surname, name, lastname, date_of_birdth, adress, phone_num, hire_date) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, vet.getSurname());
            ps.setString(2, vet.getName());
            ps.setString(3, vet.getLastname());
            ps.setString(4, vet.getDate_of_birdth());
            ps.setString(5, vet.getAdress());
            ps.setString(6, vet.getPhone_num());
            ps.setString(7, vet.getHire_date());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VetDoctor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DBaseObjectAbsrt read(int id) {
        Vet vet = new Vet(id);
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT surname, name, lastname, date_of_birdth, adress, phone_num, hire_date FROM vetdoctor WHERE id_vetdoctor = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            vet.setSurname(rs.getString("surname"));
            vet.setName(rs.getString("name"));
            vet.setLastname(rs.getString("lastname"));
            vet.setDate_of_birdth(rs.getString("date_of_birdth"));
            vet.setAdress(rs.getString("adress"));
            vet.setPhone_num(rs.getString("phone_num"));
            vet.setHire_date(rs.getString("hire_date"));
        } catch (SQLException ex) {
            Logger.getLogger(VetDoctor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return vet;
    }

    @Override
    public void update( DBaseObjectAbsrt newObj) {
        Vet newVet = (Vet) newObj;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE vetdoctor SET surname = ?, name = ?, lastname = ?, date_of_birdth = ?, adress = ?, phone_num = ?, hire_date = ? WHERE id_vetdoctor = ?");
            ps.setString(1, newVet.getSurname());
            ps.setString(2, newVet.getName());
            ps.setString(3, newVet.getLastname());
            ps.setString(4, newVet.getDate_of_birdth());
            ps.setString(5, newVet.getAdress());
            ps.setString(6, newVet.getPhone_num());
            ps.setString(7, newVet.getHire_date());
            ps.setInt   (8, newVet.getId());
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
            ps = connection.prepareStatement("DELETE FROM vetdoctor WHERE id_vetdoctor = ?");
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
    public DBaseObjectAbsrt getVetDoctorByName(String surname) {
        Vet vet = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_vetdoctor, surname, name, lastname, date_of_birdth, adress, phone_num, hire_date FROM vetdoctor WHERE surname = ?");
            ps.setString(1, surname);
            rs = ps.executeQuery();
            rs.next();
            vet = new Vet(rs.getInt("id_vetdoctor"));
            vet.setSurname(rs.getString("surname"));
            vet.setName(rs.getString("name"));
            vet.setLastname(rs.getString("lastname"));
            vet.setDate_of_birdth(rs.getString("date_of_birdth"));
            vet.setAdress(rs.getString("adress"));
            vet.setPhone_num(rs.getString("phone_num"));
            vet.setHire_date(rs.getString("hire_date"));
        } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return vet;
    }

    @Override
    public List getVetFilter(String str) {
        Vet vet = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List vets = new ArrayList();
        try{
            connection = dbcp.getConnection();
            String sql = "SELECT * FROM vetdoctor WHERE surname LIKE '%" +str+ "%'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                vet = new Vet(rs.getInt("id_vetdoctor"));
                vet.setSurname(rs.getString("surname"));
                vet.setName(rs.getString("name"));
                vet.setLastname(rs.getString("lastname"));
                vet.setDate_of_birdth(rs.getString("date_of_birdth"));
                vet.setAdress(rs.getString("adress"));
                vet.setPhone_num(rs.getString("phone_num"));
                vet.setHire_date(rs.getString("hire_date"));
                vets.add(vet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return vets;
    }
    
    @Override
    public int getId_vet(String str) {
        Vet vet = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_vetdoctor FROM vetdoctor WHERE surname = ?");
            ps.setString(1, str);
            rs = ps.executeQuery();
            rs.next();
            vet = new Vet(rs.getInt("id_vetdoctor"));
            
        } catch (SQLException ex) {
            Logger.getLogger(VetDoctor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return vet.getId();
    }
 }
