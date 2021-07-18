/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;

/**
 *
 * @author songm
 */
public abstract class BaseDAO
{

    protected Connection connection;

    public BaseDAO()
    {
        try
        {
            String dbName = "OnlineQuiz";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=" + dbName;
            String user = "sa";
            String pass = "123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex)
        {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException
    {
        if (rs != null && !rs.isClosed())
        {
            rs.close();
        }
        if (ps != null && !ps.isClosed())
        {
            ps.close();
        }
        if (con != null && !con.isClosed())
        {
            con.close();
        }
    }

}
