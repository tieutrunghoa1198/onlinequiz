/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author songm
 */
public class Answer
{
    private int aid;
    private String answer;
    private boolean selected;

    public Answer(int aid, String answer, boolean selected)
    {
        this.aid = aid;
        this.answer = answer;
        this.selected = selected;
    }

    public Answer(int aid, String answer)
    {
        this.aid = aid;
        this.answer = answer;
        this.selected = false;
    }
    
    

    public Answer()
    {
    }

    public int getAid()
    {
        return aid;
    }

    public void setAid(int aid)
    {
        this.aid = aid;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setSelected(boolean selected)
    {
        this.selected = selected;
    }
    
    
}
