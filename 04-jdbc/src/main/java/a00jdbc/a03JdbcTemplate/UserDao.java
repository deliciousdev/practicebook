package a00jdbc.a03JdbcTemplate;


import a00jdbc.User;

import java.sql.SQLException;

public class UserDao {


    //todo try with resource
    public void create(User user) throws SQLException {

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "INSERT INTO USERS values(?,?,?,?)";
        jdbcTemplate.executeUpdate(sql, pstmt -> {
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

        });
    }

    public User findById(String userId) throws SQLException {

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "SELECT userId,password,name,email FROM USERS WHERE userId=?";

        return (User)jdbcTemplate.executeQuery(sql,
                pstmt -> pstmt.setString(1,userId),
                rs -> new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                )
        );
    }


}
