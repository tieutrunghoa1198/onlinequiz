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
public class Exam
{

    private long timeForExam;
    private List<Question> questionList;
    private int currentIndex;
    private long endTime;
    private boolean finish;

    public boolean isFinish()
    {
        return finish;
    }

    public void setFinish(boolean finish)
    {
        this.finish = finish;
    }
    
    public long getEndTime()
    {
        return endTime;
    }

    public long getTimeForExam()
    {
        return timeForExam;
    }

    public void setTimeForExam(long timeForExam)
    {
        this.timeForExam = timeForExam;
    }

    public void setEndTime(long endTime)
    {
        this.endTime = endTime;
    }

    public int getCurrentIndex()
    {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex)
    {
        if (currentIndex >= this.questionList.size())
        {
            this.currentIndex = 0;
        } else if (currentIndex < 0)
        {
            this.currentIndex = this.questionList.size() - 1;
        } else
        {
            System.out.println(this.currentIndex);
            this.currentIndex = currentIndex;
        }
    }

    public Exam()
    {
    }

    public Exam(int time, double score, List<Question> questionList, Question currentQuestion)
    {
        this.timeForExam = time;
        this.questionList = questionList;
        this.finish = false;
    }

    public List<Question> getQuestionList()
    {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList)
    {
        this.questionList = questionList;
    }

}
