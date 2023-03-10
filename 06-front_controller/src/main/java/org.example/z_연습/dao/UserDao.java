package org.example.z_연습.dao;

import org.example.z_연습.User;

import java.sql.*;

public class UserDao {

    private final String DB_URL = "jdbc:mysql://localhost:3306/board";
    private final String DB_USER = "hjy9399";
    private final String DB_PASSWORD = "hjy6398";


    public User findById(String id){

        String s = "select userId,password from users where userId= ?";
        Connection conn =null;
        PreparedStatement pstmt= null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            pstmt = conn.prepareStatement(s);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            User user=null;
            if(rs.next()){
                user= new User(
                        rs.getString("userId"),
                        rs.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }


}
