package a00jdbc.a04싱글톤매니저;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public enum MyConnectionManager {

    INSTANCE;
    private final String DB_DRIVER = "org.h2.Driver";
    private final String DB_URL = "jdbc:h2:mem://localhost/~/jdbc-practice;Mode=MySQL;DB_CLOSE_DELAY=-1";
    private final String DB_USER = "sa";
    private final String DB_PASSWORD = "";
    private final int MAX_POOL_SIZE = 40;

    private final DataSource ds ;

    MyConnectionManager() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(DB_DRIVER);
        hikariDataSource.setJdbcUrl(DB_URL);
        hikariDataSource.setUsername(DB_USER);
        hikariDataSource.setPassword(DB_PASSWORD);
        hikariDataSource.setMaximumPoolSize(MAX_POOL_SIZE);
        hikariDataSource.setMinimumIdle(MAX_POOL_SIZE);
        this.ds = hikariDataSource;
    }



    public DataSource getDataSource(){
        return ds;
    }
    //데이터소스는 하나이고, 커넥션은 이 하나의 데이터소스로부터 나옴
    public Connection getConnection()  {
        try{
            return ds.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
