package by.bsuir.kursovoi.chernyak.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ConnectorDB {
    private static String driverClassName;
    private static String url, username, password;
    private static int maxConnect;
    private static ArrayBlockingQueue<Connection> freeConnect;
    private static ArrayBlockingQueue<Connection> allConnect;
    private static ConnectorDB connectordb;
    
    private ConnectorDB() {
        ResourceBundle bundle = ResourceBundle.getBundle("database_properties");
        driverClassName = bundle.getString("jdbc.driverClassName");
        url = bundle.getString("jdbc.url");
        username = bundle.getString("jdbc.username");
        password = bundle.getString("jdbc.password");
        maxConnect = Integer.parseInt(bundle.getString("jdbc.maxCon"));
        this.freeConnect = new ArrayBlockingQueue<Connection>(maxConnect);
        this.allConnect = new ArrayBlockingQueue<Connection>(maxConnect);
    }

    /**
     * Inits connection pool 
     * @return database.controller.DBConnectionPool object
     */
    public static ConnectorDB init() {
        if (connectordb == null) {
            connectordb = new ConnectorDB();
            try {
                Driver driver = (Driver) Class.forName(driverClassName).newInstance();
                DriverManager.registerDriver(driver);
                int i = 0;
                while (i != maxConnect) {
                    freeConnect.add(newConnection());
                    i++;
                }
                allConnect.addAll(freeConnect);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connectordb;
    }

    /**
     *
     * @return java.sql.Connection;
     */
    public Connection getConnection() {
        Connection con;
        if (!freeConnect.isEmpty()) {
            con = (Connection) freeConnect.poll();
            try {
                if (con.isClosed()) {
                    allConnect.remove();
                    con = newConnection();
                    allConnect.add(con);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else {
            con = newConnection();
        }
        return con;
    }

    private static Connection newConnection() {
        Connection con = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    /**
     * Return java.sql.Connection to the database.controller.DBConnectionPool object
     * @param con
     */
    public synchronized void freeConnection(Connection con) {
        if ((con != null) && (freeConnect.size() <= maxConnect)) {
            freeConnect.add(con);
        }
    }

    /**
     * Close all java.sql.Connection in database.controller.DBConnectionPool
     */
    public void release() {
        for (Connection con : allConnect) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        freeConnect.clear();
    }

    /**
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        release();
    }
}
