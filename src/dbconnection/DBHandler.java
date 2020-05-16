package dbconnection;

import dbconnection.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Config {

    Connection dbconnection;

    public Connection getConnection(){
        String connectionString="jdbc:mysql://"+Config.dbhost+":"+Config.dbport+"/"+Config.dbname;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbconnection= DriverManager.getConnection(connectionString, Config.dbuser, Config.dbpass);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return dbconnection;
    }
}