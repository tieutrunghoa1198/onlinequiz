/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author songm
 */
public final class Question
{

    private String question;
    private String ans_1, ans_2, ans_3, ans_4;
    private String correctAns;
    private User owner;
    private Date createdDate;
    
    public Question(String question, String ans_1, String ans_2, String ans_3, String ans_4, String correctAns, Date createdDate, User owner)
    {
        setQuestion(question);
        setAns_1(ans_1);
        setAns_2(ans_2);
        setAns_3(ans_3);
        setAns_4(ans_4);
        this.correctAns = correctAns;
        this.createdDate = createdDate;
        this.owner = owner;
    }

    public Question(String question, String ans_1, String ans_2, String ans_3, String ans_4, String correctAns)
    {
        this.question = question;
        this.ans_1 = ans_1;
        this.ans_2 = ans_2;
        this.ans_3 = ans_3;
        this.ans_4 = ans_4;
        this.correctAns = correctAns;
    }

    public Question()
    {
    }

    public String getCreatedDateString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        sdf.format(createdDate);
        return sdf.format(createdDate);
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        if (question.isEmpty())
        {
            this.question = "";
        }
        this.question = question;
    }

    public String getAns_1()
    {
        return ans_1;
    }

    public void setAns_1(String ans_1)
    {
        if (ans_1.isEmpty())
        {
            this.ans_1 = "";
        }
        this.ans_1 = ans_1;
    }

    public String getAns_2()
    {
        return ans_2;
    }

    public void setAns_2(String ans_2)
    {
        if (ans_2.isEmpty())
        {
            this.ans_2 = "";
        }
        this.ans_2 = ans_2;
    }

    public String getAns_3()
    {
        return ans_3;
    }

    public void setAns_3(String ans_3)
    {
        if (ans_3.isEmpty())
        {
            this.ans_3 = "";
        }
        this.ans_3 = ans_3;
    }

    public String getAns_4()
    {
        return ans_4;
    }

    public void setAns_4(String ans_4)
    {
        if (ans_4.isEmpty())
        {
            this.ans_4 = "";
        }
        this.ans_4 = ans_4;
    }

    public String getCorrectAns()
    {
        return correctAns;
    }

    public void setCorrectAns(String correctAns)
    {
        if (correctAns.isEmpty())
        {
            this.correctAns = "";
        }
        this.correctAns = correctAns;
    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }

}
