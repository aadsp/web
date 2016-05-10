
package org.aadsp.utils.settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoSQLServer 
{
    public static Connection conexao() throws SQLException
    {
        Connection con=DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;databaseName=AADSP","sa","12345"); 
        return con;
    }
}
