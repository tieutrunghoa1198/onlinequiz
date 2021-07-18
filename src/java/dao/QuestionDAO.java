/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.BaseDAO;
import entity.Question;
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
            String sql = "SELECT COUNT(*) AS bankquest FROM dbo.QUESTION";
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
