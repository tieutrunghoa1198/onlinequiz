/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.BaseDAO;
import entity.Answer;
import entity.Question;
import entity.Quiz;
import entity.User;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author songm
 */
public class QuestionDAO extends BaseDAO
{

    public int createQuest(Question question)
    {
        try
        {
            String sql = "INSERT dbo.QUESTION\n"
                    + "(\n"
                    + "    question,\n"
                    + "    option1,\n"
                    + "    option2,\n"
                    + "    option3,\n"
                    + "    option4,\n"
                    + "    correctAns,\n"
                    + "    createdDate,\n"
                    + "    [owner]\n"
                    + ")\n"
                    + "VALUES\n"
                    + "(   ?, -- question - nvarchar(250)\n"
                    + "    ?, -- option1 - nvarchar(250)\n"
                    + "    ?, -- option2 - nvarchar(250)\n"
                    + "    ?, -- option3 - nvarchar(250)\n"
                    + "    ?, -- option4 - nvarchar(250)\n"
                    + "    ?, -- correctAns - nvarchar(150)\n"
                    + "	?, -- date - nvarchar(150)\n"
                    + "    ?  -- owner - nvarchar(150)\n"
                    + "    )";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, question.getQuestion());
            stm.setString(2, question.getAns_1());
            stm.setString(3, question.getAns_2());
            stm.setString(4, question.getAns_3());
            stm.setString(5, question.getAns_4());
            stm.setString(6, question.getCorrectAns());
            stm.setDate(7, question.getCreatedDate());
            stm.setString(8, question.getOwner().getUsername());
            return stm.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return -1;
    }

    public int getTotalCorrectAnsByQuizID(int qid)
    {
        try
        {
            String sql = "SELECT COUNT(isTrue) AS correctAns FROM dbo.QuizBank\n"
                    + "INNER JOIN dbo.Answer ON Answer.qid = QuizBank.qid\n"
                    + "WHERE dbo.QuizBank.qid = ? AND isTrue = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, qid);
            ResultSet rs = stm.executeQuery();
            if (rs.next())
            {
                return rs.getInt("correctAns");
            }
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return -1;
    }

    public int createQuiz(String question, int userid)
    {
        try
        {
            String sql = "INSERT INTO dbo.QuizBank\n"
                    + "(\n"
                    + "    question,\n"
                    + "    createdAt,\n"
                    + "    userid\n"
                    + ")\n"
                    + "VALUES\n"
                    + "(   ?,       -- question - nvarchar(max)\n"
                    + "    GETDATE(), -- createdAt - date\n"
                    + "    ?          -- userid - int\n"
                    + "    )";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setNString(1, question);
            stm.setInt(2, userid);
            return stm.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return -1;
    }

    public int getInsertedRow()
    {
        try
        {
            String sql2 = "SELECT TOP(1) qid FROM dbo.QuizBank ORDER BY qid DESC";
            PreparedStatement stm2 = connection.prepareStatement(sql2);
            ResultSet rs = stm2.executeQuery();
            if (rs.next())
            {
                return rs.getInt("qid");
            }
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return -1;
    }

    public int insertAnswer(int qid, Answer a)
    {
        try
        {
            String sql = "INSERT dbo.Answer\n"
                    + "(\n"
                    + "    qid,\n"
                    + "    answer,\n"
                    + "    isTrue\n"
                    + ")\n"
                    + "VALUES\n"
                    + "(   ?,   -- qid - int\n"
                    + "    ?, -- answer - nvarchar(max)\n"
                    + "    ? -- isTrue - bit\n"
                    + "    )";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, qid);
            stm.setNString(2, a.getAnswer());
            stm.setBoolean(3, a.isSelected());
            return stm.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return -1;
    }

    public List<Question> getQuestionByUser(User user)
    {
        List<Question> qList = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM dbo.QUESTION \n"
                    + "WHERE [owner] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getUsername());
            ResultSet rs = stm.executeQuery();

            while (rs.next())
            {
                qList.add(
                        new Question(
                                rs.getString("question"),
                                rs.getString("option1"),
                                rs.getString("option2"),
                                rs.getString("option3"),
                                rs.getString("option4"),
                                rs.getString("correctAns"),
                                rs.getDate("createdDate"),
                                user));
            }
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return qList;
    }

    public List<Quiz> getListQuiz(int numberOfQuiz)
    {
        List<Quiz> listQuiz = new ArrayList<>();
        try
        {
            String sql = "SELECT TOP(?) * FROM dbo.QuizBank \n"
                    + "ORDER BY NEWID()";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, numberOfQuiz);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                int quizID = rs.getInt("qid");
                Quiz q = new Quiz(
                        quizID,
                        rs.getString("question"),
                        getAnswerByQuizID(quizID)
                );
                System.out.println(getAnswerByQuizID(quizID));
                listQuiz.add(q);
            }
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return listQuiz;
    }

    public List<Answer> getAnswerByQuizID(int qid)
    {
        List<Answer> listAnswers = new ArrayList<>();
        try
        {
            String sql = "SELECT aid, question, answer FROM dbo.QuizBank\n"
                    + "INNER JOIN dbo.Answer ON Answer.qid = QuizBank.qid\n"
                    + "WHERE dbo.QuizBank.qid = ?\n"
                    + "ORDER BY NEWID()";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, qid);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                Answer a = new Answer(
                        rs.getInt("aid"),
                        rs.getString("answer")
                );
                listAnswers.add(a);
            }
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return listAnswers;
    }

    public List<Answer> getCorrectAnswerByQuizID(int qid)
    {
        List<Answer> listAnswers = new ArrayList<>();
        try
        {
            String sql = "SELECT aid, question, answer, isTrue FROM dbo.QuizBank\n"
                    + "INNER JOIN dbo.Answer ON Answer.qid = QuizBank.qid\n"
                    + "WHERE dbo.QuizBank.qid = ?\n"
                    + "ORDER BY NEWID()";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, qid);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                Answer a = new Answer(
                        rs.getInt("aid"),
                        rs.getString("answer"),
                        rs.getBoolean("isTrue")
                );
                listAnswers.add(a);
            }
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return listAnswers;
    }

    public List<Question> createExam(int numberOfQuestion)
    {
        List<Question> examList = new ArrayList<>();
        try
        {
            String sql = "SELECT TOP (?) * FROM dbo.QUESTION\n"
                    + "ORDER BY NEWID()";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, numberOfQuestion);
            ResultSet rs = stm.executeQuery();

            while (rs.next())
            {
                examList.add(
                        new Question(
                                rs.getString("question"),
                                rs.getString("option1"),
                                rs.getString("option2"),
                                rs.getString("option3"),
                                rs.getString("option4"),
                                rs.getString("correctAns")
                        )
                );
            }
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return examList;
    }

    public int getAllQuests()
    {
        try
        {
            String sql = "SELECT COUNT(*) AS bankquest FROM dbo.QuizBank";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next())
            {
                return rs.getInt("bankquest");
            }
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return 0;
    }
}
