package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Con {

    Connection connection;
    Statement statement;
    //create a constructor
    public Con(){
        //all connections are made in try
        try{
           connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","Sourav@2005");
           statement=connection.createStatement();

        }catch(Exception E){
            E.printStackTrace();
        }
    }
}
