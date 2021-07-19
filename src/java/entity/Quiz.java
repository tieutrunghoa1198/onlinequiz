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
public class Quiz
{

    private int qid;
    private String question;
    private List<Answer> listAnswers;
    private double score;
    private int numberOfCorrectAns;

    public int getNumberOfCorrectAns()
    {
        return numberOfCorrectAns;
    }

    public void setNumberOfCorrectAns()
    {
        int correctAns = 0;
        correctAns = this.listAnswers.stream().filter((a) -> (a.isSelected())).map((_item) -> 1).reduce(correctAns, Integer::sum);
        this.numberOfCorrectAns = correctAns;
    }

    public Quiz(int qid, String question, List<Answer> listAnswers)
    {
        this.qid = qid;
        this.question = question;
        this.listAnswers = listAnswers;
    }

    public Quiz()
    {
    }

    public int getQid()
    {
        return qid;
    }

    public void setQid(int qid)
    {
        this.qid = qid;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public List<Answer> getListAnswers()
    {
        return listAnswers;
    }

    public void setListAnswers(List<Answer> listAnswers)
    {
        this.listAnswers = listAnswers;
    }

    public double getScore()
    {
        return score;
    }

    public void setScore(double score)
    {
        this.score = score;
    }

}
