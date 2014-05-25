package net.therap.mealScheduler.util.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: rifatul islam
 */
public class DatabaseConnectionPool {
    private static DataSource dataSource = null;

    static {
        try {
            setupContextAndDataSource();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private static void setupContextAndDataSource() throws NamingException {
        Context context = new InitialContext();
        dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/MyLocalDB");
    }
}

