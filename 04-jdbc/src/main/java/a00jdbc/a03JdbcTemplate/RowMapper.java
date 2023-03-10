package a00jdbc.a03JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface RowMapper {

    Object map(ResultSet rs) throws SQLException;
}
