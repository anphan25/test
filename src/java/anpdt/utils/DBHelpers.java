/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anpdt.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ASUS
 */
public class DBHelpers implements Serializable {

    public static Connection makeConnection() throws NamingException, SQLException{
        //1.get current system file
        Context context = new InitialContext();
        //2. get container context
        Context tomcatContext = (Context)context.lookup("java:comp/env");
        //3 get datasource from container
        DataSource ds= (DataSource) tomcatContext.lookup("DSBlink");
        //4 get connection
        Connection con = ds.getConnection();
       
        return con;

    }
}
