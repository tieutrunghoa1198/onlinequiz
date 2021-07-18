/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author songm
 */
public class User
{

    private int id;
    private String username;
    private String pass;
    private String email;
    private List<Feature> feature;

    public User(String username, String pass, String email)
    {
        this.username = username;
        this.pass = pass;
        this.email = email;
    }

    public User(int id, String username, List<Feature> feature)
    {
        this.id = id;
        this.username = username;
        this.feature = feature;
    }

    public User()
    {

    }

    public List<Feature> getFeature()
    {
        return feature;
    }

    public void setFeature(List<Feature> feature)
    {
        this.feature = feature;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
