/**
 * <p>
 * This is the package for connectionUtil class 
 * </p>
 *
 * Copyright 2022 - ideas2it
 */
package com.ideas2it.employee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ideas2it.employee.common.Constants;

/**
 * <p>
 * Class connectionutil used for connection establishment
 * </p>
 *
 * @author  Ramachandran
 *
 * @version 1
 *
 * @since   2022-07-18
 */ 
public class ConnectionUtil {
   
    private static Connection connection = null;
    
    /**
     * <p>
     * This private constructor restrict the object creation
     * outside of the class
     * </p>
     */
    private ConnectionUtil() {

    }
  
    /**
     * <p>
     * This method establish the connection
     * </p>
     *
     * @return connection
     */
    public static Connection getInstance() throws SQLException {
        if(null == connection || connection.isClosed()) {
            connection = DriverManager.getConnection(Constants.dburl, Constants.username, Constants.password);                            
        }
        return connection;
    }    
}