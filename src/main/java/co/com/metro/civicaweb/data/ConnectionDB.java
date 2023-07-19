package co.com.metro.civicaweb.data;


import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class ConnectionDB {

    private Connection connection;


    private Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ConnectionDB conectBD_Oracle() throws IOException {

        Properties properties = new Properties();
        properties.load(new FileReader("src/test/resources/config.properties"));

        String dataBaseURL = properties.getProperty("host_bd");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");


        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(dataBaseURL, user, password);
            if (getConnection() != null) {
                System.out.println("Conexion Exitosa");
            } else {
                System.out.println("Conexion Fallida");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
        return this;
    }

    public boolean runQuery(String sql) {
        try {
            Statement statement = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public ResultSet query(String sql) {
        ResultSet resultSet = null;

        try {
            Statement statement = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ResultSet querySP(String sql, String date1, String date2) {
        ResultSet resultSet = null;

        try {
            CallableStatement callableStatement = getConnection().prepareCall(sql);
            String dateIni = date1;
            String dateEnd = date2;
            Date dateInitial = Date.valueOf(dateIni);
            Date dateFinal = Date.valueOf(dateEnd);

            callableStatement.setDate(1, dateInitial);
            callableStatement.setDate(2, dateFinal);
            callableStatement.setString(3, null);
            callableStatement.setString(4, null);
            callableStatement.setString(5,null);
            callableStatement.registerOutParameter(6, Types.REF_CURSOR);

            callableStatement.execute();

            resultSet = (ResultSet) callableStatement.getObject(6);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
