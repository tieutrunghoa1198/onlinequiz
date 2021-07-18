/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.BaseDAO;
import entity.Feature;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author songm
 */
public class UserDAO extends BaseDAO
{

    public int register(User u)
    {
        try
        {
            String sql = "INSERT dbo.USERS\n"
                    + "(\n"
                    + "    username,\n"
                    + "    pass,\n"
                    + "    email\n"
                    + ")\n"
                    + "VALUES\n"
                    + "(   ?, -- username - nvarchar(150)\n"
                    + "    ?, -- pass - nvarchar(150)\n"
                    + "    ?  -- email - nvarchar(100)\n"
                    + "    )";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, u.getUsername());
            stm.setString(2, u.getPass());
            stm.setString(3, u.getEmail());
            return stm.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return -1;
    }

    public int addRole(int role, String username)
    {
        try
        {
            String sql = "INSERT dbo.USER_ROLE\n"
                    + "(\n"
                    + "    username,\n"
                    + "    rid\n"
                    + ")\n"
                    + "VALUES\n"
                    + "(   ?, -- username - nvarchar(150)\n"
                    + "    ?    -- rid - int\n"
                    + "    )";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setInt(2, role);
            return stm.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return -1;
    }

    public User getUser(String username, String pass)
    {
        try
        {
            String sql = "SELECT * FROM dbo.USERS AS u\n"
                    + "WHERE username = ? AND pass = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            if (rs.next())
            {
                return new User(
                        rs.getInt("userid"),
                        rs.getString("username"),
                        getFeature(username)
                );
            }
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return null;
    }

    public List<Feature> getFeature(String username)
    {
        List<Feature> fList = new ArrayList<>();
        try
        {
            String sql = "SELECT ur.username, f.fname FROM dbo.USER_ROLE AS ur\n"
                    + "LEFT JOIN dbo.ROLE_FEATURE ON ROLE_FEATURE.rid = ur.rid\n"
                    + "LEFT JOIN dbo.FEATURE AS f ON f.fid = ROLE_FEATURE.fid\n"
                    + "WHERE ur.username = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                fList.add(new Feature(username, rs.getString("fname")));
            }
            return fList;
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return null;
    }
}
