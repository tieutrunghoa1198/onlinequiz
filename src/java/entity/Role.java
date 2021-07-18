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
public class Role
{

    private int id;
    private String name;
    private List<Feature> featureList;

    public Role()
    {
    }

    public Role(int id, String name, List<Feature> featureList)
    {
        this.id = id;
        this.name = name;
        this.featureList = featureList;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Feature> getFeatureList()
    {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList)
    {
        this.featureList = featureList;
    }

}
