package a00jdbc.a02DB커넥션풀;


import a00jdbc.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {



    //todo try with resource
    public void create(User user) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO USERS values(?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

            int i = pstmt.executeUpdate();
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();

        }
    }

    public User findById(String userId) throws SQLException {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
            con = ConnectionManager.getConnection();;
            String sql = "SELECT userId,password,name,email from USERS WHERE userid=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            User user= null;
            if (rs.next()) {
                user = new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }

            return user;
        }finally {
            if(rs!=null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(con!=null) con.close();
        }
    }


}
