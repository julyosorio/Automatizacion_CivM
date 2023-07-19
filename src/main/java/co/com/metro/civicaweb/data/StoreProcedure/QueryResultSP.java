package co.com.metro.civicaweb.data.StoreProcedure;

import co.com.metro.civicaweb.data.ConnectionDB;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QueryResultSP {

    public static List<Map<String, Object>> queryResultSP(String sql, String date1, String date2) {

        List<Map<String, Object>> listResulQuery = new ArrayList<>();

        try {
            ResultSetMetaData resultSetMetaData = null;
            ResultSet resultSet = null;

            ConnectionDB conectSQL = new ConnectionDB().conectBD_Oracle();

            resultSet = conectSQL.querySP(sql, date1, date2 );
            resultSetMetaData = resultSet.getMetaData();

            int totalcolumns = resultSetMetaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> row = new TreeMap<>();

                for (int col = 1; col <= totalcolumns; col++) {
                    row.put(resultSetMetaData.getColumnName(col), resultSet.getObject(col));

                }
                listResulQuery.add(row);

            }
        } catch (SQLException | IOException e) {
        }
        return listResulQuery;
    }


}
