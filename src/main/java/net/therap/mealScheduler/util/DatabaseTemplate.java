package net.therap.mealScheduler.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
public class DatabaseTemplate {

    public static <E> List<E> queryForObject(ObjectRowMapper<E> objectRowMapper, String query, Object... parameters) {
        ResultSet resultSet;
        Connection dbConnection = null;
        PreparedStatement statement = null;

        List<E> listOfElement = new ArrayList<E>();
        try {
            statement = getPreparedStatement(dbConnection, query);
            putValues(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listOfElement.add(objectRowMapper.mapRowToObject(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnectionAndStatement(dbConnection, statement);
        }
        return listOfElement;
    }

    public static void executeUpdate(String query, Object... parameters) {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        try {
            statement = getPreparedStatement(dbConnection, query);
            putValues(statement, parameters);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnectionAndStatement(dbConnection, statement);
        }
    }

    private static PreparedStatement getPreparedStatement(Connection dbConnection, String query) throws SQLException {
        dbConnection = DatabaseConnectionPool.getConnection();
        return dbConnection.prepareStatement(query);
    }

    private static void putValues(PreparedStatement statement, Object... values) throws SQLException {
        int i = 1;
        for (Object parameter : values) {
            if (parameter instanceof String) {
                statement.setString(i, (String) parameter);
            } else if (parameter instanceof Integer) {
                statement.setInt(i, (Integer) parameter);
            } else if (parameter instanceof Long) {
                statement.setLong(i, (Long) parameter);
            } else if (parameter instanceof Float) {
                statement.setFloat(i, (Float) parameter);
            } else if (parameter instanceof Double) {
                statement.setDouble(i, (Double) parameter);
            } else if (parameter instanceof Date) {
                statement.setDate(i, (Date) parameter);
            } else if (parameter instanceof Blob) {
                statement.setBlob(i, (Blob) parameter);
            } else if (parameter instanceof Timestamp) {
                statement.setTimestamp(i, (Timestamp) parameter);
            }
            i++;
        }
    }

    private static void closeConnectionAndStatement(Connection dbConnection, Statement statement) {
        try {
            if (dbConnection != null) {
                statement.close();
                dbConnection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
