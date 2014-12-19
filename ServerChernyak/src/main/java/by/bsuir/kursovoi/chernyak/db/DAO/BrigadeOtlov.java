package by.bsuir.kursovoi.chernyak.db.DAO;

import by.bsuir.kursovoi.chernyak.db.ConnectorDB;
import by.bsuir.kursovoi.chernyak.db.model.Brigade;
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

public class BrigadeOtlov implements BrigadeOtlovInter{
    
    @Override
    public List getBrigadeOtlov() {
        Brigade brigade = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List brigades = new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM brigade");
            rs = ps.executeQuery();
            while(rs.next()) {
                brigade = new Brigade(rs.getInt("id_brigade"));
                brigade.setSurname(rs.getString("surname"));
                brigade.setName(rs.getString("name"));
                brigade.setLastname(rs.getString("lastname"));
                brigade.setDate_of_birdth(rs.getString("date_of_birdth"));
                brigade.setNum_of_brigade(rs.getInt("num_of_brigade"));
                brigade.setAdress(rs.getString("adress"));
                brigade.setPhone_num(rs.getString("phone_num"));
                brigade.setHire_date(rs.getString("hire_date"));
                brigades.add(brigade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrigadeOtlov.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return brigades;
    }

    @Override
    public int create(DBaseObjectAbsrt object) {
        Brigade brigade = (Brigade) object;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO brigade (surname, name, lastname, date_of_birdth, num_of_brigade, adress, phone_num, hire_date) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, brigade.getSurname());
            ps.setString(2, brigade.getName());
            ps.setString(3, brigade.getLastname());
            ps.setString(4, brigade.getDate_of_birdth());
            ps.setInt(5, brigade.getNum_of_brigade());
            ps.setString(6, brigade.getAdress());
            ps.setString(7, brigade.getPhone_num());
            ps.setString(8, brigade.getHire_date());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BrigadeOtlov.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DBaseObjectAbsrt read(int id) {
        Brigade brigade = new Brigade(id);
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT surname, name, lastname, date_of_birdth, num_of_brigade, adress, phone_num, hire_date FROM brigade WHERE id_brigade = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            brigade.setSurname(rs.getString("surname"));
            brigade.setName(rs.getString("name"));
            brigade.setLastname(rs.getString("lastname"));
            brigade.setDate_of_birdth(rs.getString("date_of_birdth"));
            brigade.setNum_of_brigade(rs.getInt("num_of_brigade"));
            brigade.setAdress(rs.getString("adress"));
            brigade.setPhone_num(rs.getString("phone_num"));
            brigade.setHire_date(rs.getString("hire_date"));
        } catch (SQLException ex) {
            Logger.getLogger(BrigadeOtlov.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return brigade;
    }

    @Override
    public void update( DBaseObjectAbsrt newObj) {
        Brigade newBrigade = (Brigade) newObj;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE brigade SET surname = ?, name = ?, lastname = ?, date_of_birdth = ?,num_of_brigade = ?, adress = ?, phone_num = ?, hire_date = ? WHERE id_brigade = ?");
            ps.setString(1, newBrigade.getSurname());
            ps.setString(2, newBrigade.getName());
            ps.setString(3, newBrigade.getLastname());
            ps.setString(4, newBrigade.getDate_of_birdth());
            ps.setInt(5, newBrigade.getNum_of_brigade());
            ps.setString(6, newBrigade.getAdress());
            ps.setString(7, newBrigade.getPhone_num());
            ps.setString(8, newBrigade.getHire_date());
            ps.setInt   (9, newBrigade.getId());
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
            ps = connection.prepareStatement("DELETE FROM brigade WHERE id_brigade = ?");
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
    public DBaseObjectAbsrt getBrigadeOtlovByName(String surname) {
        Brigade brigade = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_brigade, surname, name, lastname, date_of_birdth, num_of_brigade, adress, phone_num, hire_date FROM brigade WHERE surname = ?");
            ps.setString(1, surname);
            rs = ps.executeQuery();
            rs.next();
            brigade = new Brigade(rs.getInt("id_brigade"));
            brigade.setSurname(rs.getString("surname"));
            brigade.setName(rs.getString("name"));
            brigade.setLastname(rs.getString("lastname"));
            brigade.setDate_of_birdth(rs.getString("date_of_birdth"));
            brigade.setNum_of_brigade(rs.getInt("num_of_brigade"));
            brigade.setAdress(rs.getString("adress"));
            brigade.setPhone_num(rs.getString("phone_num"));
            brigade.setHire_date(rs.getString("hire_date"));
        } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return brigade;
    }
    
    
    @Override
    public List getBrigadeFilter(String str) {
        Brigade brigade = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List brigads = new ArrayList();
        try{
            connection = dbcp.getConnection();
            String sql = "SELECT * FROM brigade WHERE surname LIKE '%" +str+ "%'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                brigade = new Brigade(rs.getInt("id_brigade"));
                brigade.setSurname(rs.getString("surname"));
                brigade.setName(rs.getString("name"));
                brigade.setLastname(rs.getString("lastname"));
                brigade.setDate_of_birdth(rs.getString("date_of_birdth"));
                brigade.setAdress(rs.getString("adress"));
                brigade.setPhone_num(rs.getString("phone_num"));
                brigade.setHire_date(rs.getString("hire_date"));
                brigads.add(brigade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBaseObjectAbsrt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return brigads;
    }

}
