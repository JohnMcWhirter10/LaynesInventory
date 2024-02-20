package Connection;

import java.sql.*;

import TableObject.*;
import javafx.scene.control.Tab;

public class ConnectionManager {
    private Connection conn = null;
    final private String teamNumber = "19";
    final private String sectionNumber = "903";
    final private String dbName = "csce315" + sectionNumber + "_" + teamNumber + "db";
    final private String dbConnectionString = "jdbc:postgresql://csce-315-db.engr.tamu.edu/" + dbName;
    final private String userName = "csce315" + sectionNumber + "_" + teamNumber + "user";
    final private String userPassword = "ARGVBMRS";

    public ConnectionManager(){
        try {
            conn = DriverManager.getConnection(dbConnectionString,userName, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        System.out.println("Opened database successfully");
    }

    public boolean endConnection(){
        try {
            conn.close();
            System.out.println("Connection Closed.");
            return true;
        } catch(Exception e) {
            System.out.println("Connection NOT Closed.");
            return false;
        }
    }

    public int INSERT(TableObject ObjectToInsertInToTable){
        String sqlStatement = "INSERT INTO " + ObjectToInsertInToTable.getName() + " VALUES " + ObjectToInsertInToTable.toString() + ";";
        return parseUpdate(sqlStatement);
    }

    public int DELETE(TableObject ObjectToDeleteFromTable){
        String sqlStatement = "DELETE FROM " + ObjectToDeleteFromTable.getName() + " WHERE " + ObjectToDeleteFromTable.getSelectedKey() + ";";
        return parseUpdate(sqlStatement);
    }

    public int SUM(TableObject ObjectTypeOfTableToSeeData, String values){
        String sqlStatement = "SELECT SUM(" + values + ") FROM " + ObjectTypeOfTableToSeeData.getName() + ";";
        return parseUpdate(sqlStatement);
    }

    public int DROPTABLE(TableObject ObjectTypeOfTableToDrop){
        String sqlStatement = "DROP TABLE " + ObjectTypeOfTableToDrop.getName() + ";";
        return parseUpdate(sqlStatement);
    }

    public ResultSet selectStar(TableObject ObjectTypeOfTableToSeeData){
        String sqlStatement = "SELECT * FROM " + ObjectTypeOfTableToSeeData.getName() + ";";
        return parseQuery(sqlStatement);
    }

    public ResultSet selectBlank(TableObject ObjectTypeOfTableToSeeData, String values){
        String sqlStatement = "SELECT " + values + " FROM " + ObjectTypeOfTableToSeeData.getName() + ";";
        return parseQuery(sqlStatement);
    }

    public int createTable(TableObject ObjectTypeOfTableToCreate){
        String statement = "CREATE TABLE " + ObjectTypeOfTableToCreate.getName() + " (" + ObjectTypeOfTableToCreate.allAttributes() + ")" + ";";
        System.out.println("\n\n" + statement +"\n\n");
        return parseUpdate(statement);
    }

    public int updateEntryOnSelectedKey(TableObject OpjectToUpdate){
        String statement = "UPDATE " + OpjectToUpdate.getName() + " set " + OpjectToUpdate.values()
        + " where " + OpjectToUpdate.getSelectedKey() + ";";
        return parseUpdate(statement);
    }

    private int parseUpdate(String toParse){
        try{
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(toParse);
        } catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            endConnection();
            System.exit(0);
            return 0;
        }
    }

    private ResultSet parseQuery(String toParse){
        try{
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(toParse);
        } catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            endConnection();
            System.exit(0);
            return null;
        }
    }
}
