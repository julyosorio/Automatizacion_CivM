package co.com.metro.civicaweb.data;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QueryResult {

    public static List<Map<String, Object>> queryResult(String sql) {

        List<Map<String, Object>> listResulQuery = new ArrayList<>();

        try {
            ResultSetMetaData resultSetMetaData = null;
            ResultSet resultSet = null;

            ConnectionDB conectSQL = new ConnectionDB().conectBD_Oracle();
            conectSQL.runQuery(sql);

            resultSet = conectSQL.query(sql);
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
