package by.bsuir.kursovoi.chernyak.db.DAO;

import by.bsuir.kursovoi.chernyak.db.ConnectorDB;
import by.bsuir.kursovoi.chernyak.db.model.DBaseObjectAbsrt;
import by.bsuir.kursovoi.chernyak.db.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserAd implements UserAdInter{
   
    @Override
    public List getUserAd() {
        User user = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List users = new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM user");
            rs = ps.executeQuery();
            while(rs.next()) {
                user = new User(rs.getInt("id_user"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return users;
    }

    @Override
    public int create(DBaseObjectAbsrt object) {
        User user = (User) object;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO user (login, password) VALUES (?,?)");
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserAd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DBaseObjectAbsrt read(int id) {
        User user = new User(id);
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT login, password FROM user WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
        } catch (SQLException ex) {
            Logger.getLogger(UserAd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return user;
    }

    @Override
    public void update( DBaseObjectAbsrt newObject) {
        User newUser = (User) newObject;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE user SET login = ? , password = ? WHERE id = ?");
            ps.setString(1, newUser.getLogin());
            ps.setString(2, newUser.getPassword());
            ps.setInt   (3, newUser.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserAd.class.getName()).log(Level.SEVERE, null, ex);
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
            ps = connection.prepareStatement("DELETE FROM user WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserAd.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserAd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DBaseObjectAbsrt getUserAdByName(String login) {
        User user = null;
        Connection connection = null;
        ConnectorDB dbcp = ConnectorDB.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_user, login, password FROM user WHERE login = ?");
            ps.setString(1, login);
            rs = ps.executeQuery();
            rs.next();
            user = new User(rs.getInt("id_user"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
        } catch (SQLException ex) {
            Logger.getLogger(UserAd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return user;
    }
}
