package a00jdbc.a02DB커넥션풀;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:mem://localhost/~/jdbc-practice;Mode=MySQL;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
    private static final int MAX_POOL_SIZE = 40;


    private static final DataSource ds ;


    static {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(DB_DRIVER);
        hikariDataSource.setJdbcUrl(DB_URL);
        hikariDataSource.setUsername(DB_USER);
        hikariDataSource.setPassword(DB_PASSWORD);
        hikariDataSource.setMaximumPoolSize(MAX_POOL_SIZE);
        hikariDataSource.setMinimumIdle(MAX_POOL_SIZE);
        ds = hikariDataSource;
    }



    public static DataSource getDataSource(){
        return ds;
    }


    //데이터소스는 하나이고, 커넥션은 이 하나의 데이터소스로부터 나옴

    public static Connection getConnection()  {
        try{
            return ds.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


}
