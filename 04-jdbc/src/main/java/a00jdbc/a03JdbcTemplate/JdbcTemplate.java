package a00jdbc.a03JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

    public void executeUpdate(String sql, PreparedStatementSetter preparedStatementSetter) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            preparedStatementSetter.set(pstmt);

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }

    //todo 제네릭으로 하면 Object타입 안해도되어서 더 일반적으로 가능
    public Object executeQuery(String sql, PreparedStatementSetter pstmtSetter, RowMapper rowMapper) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs= null;
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmtSetter.set(pstmt);
            rs= pstmt.executeQuery();
            if (rs.next()) {
                return rowMapper.map(rs);
            }
        }finally {
            if(rs!=null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
        }

        return null;
    }




}
