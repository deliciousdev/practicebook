package a00jdbc.a03JdbcTemplate;


import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementSetter {

    void set(PreparedStatement preparedStatement) throws SQLException;

}
