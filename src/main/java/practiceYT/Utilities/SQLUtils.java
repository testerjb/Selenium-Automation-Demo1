/* *****************************************
 * NOTE THIS TEST WAS COMMENTED OUT
 * IT GIVES ERROR WHEN MIGRATED TO SELENIUM 4,
 * IF THE TEST IS NOT COMMENTED THE REST OF THE SUITE
 * WOULD HAS NOT RUN
 * THIS HAPPENS WHEN THERE ARE ERRORS IN ANY CLASS IN THE PROJECT
 * DatabaseManager error in SQLUtils class
 * *****************************************/

// THIS CLASS IS MADE TO SUPPORT SOE FUNCTIONS SQL TO SUPPORT INHERITANCE


package practiceYT.Utilities;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

/*public class SQLUtils {
    private static String username;
    private static String password;

    public static void setUsername(String username) {
        SQLUtils.username=username;
    }
    public static void setPassword(String password) {
        SQLUtils.password=password;
    }
    private static Connection getDatabaseConnection() throws Exception {
        if(username!=null && password!=null) {
            return DatabaseManager.getDBConnectionFor("master", username, password);
        }
        return DatabaseManager.getDBConnectionFor("master");
    }

    public static String executeSqlAndReturnSingleColumnValue(String query, String columnName) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String result = null;
        try (Connection connection=getDatabaseConnection()){
            if (connection != null) {
                stmt = connection.createStatement();
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    result = rs.getString(columnName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error executing executeSqlAndReturnSingleColumnValue:" + e);
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
        }
        return result;
    }

    public static void executeSql(String query) throws Exception {
        try (Connection connection = SQLUtils.getDatabaseConnection();
             Statement stmt = connection.createStatement();) {
            stmt.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error executing executeSql:" + e);
        }
    }

    public static ArrayList<String[]> executeSqlAndReturnResultsetAsArrayList(String query) {

        ArrayList<String[]> result = new ArrayList<String[]>();
        try(Connection connection=getDatabaseConnection();
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery(query);
        ){
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                String[] row = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getString(i + 1);
                }
                result.add(row);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> executeSqlAndReturnSingleColumnAsList(String query, String columnName) throws Exception {
        List<String> result = new ArrayList<String>();
        try (Connection connection = DatabaseManager.getDBConnectionFor("master");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query);) {
            if (connection != null) {

                while (rs.next()) {
                    result.add(rs.getString(columnName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error executing executeSqlAndReturnSingleColumnAsSet:" + e);
        }
        return result;
    }

}*/
