package a00jdbc.a01JDBC날것;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class MyDataSource {

    //커넥션을 얻기위한 DataSource : DB연동을 위한 기본 세팅값들
    public static DataSource getDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("org.h2.Driver"); //드라이버 정보
        hikariDataSource.setJdbcUrl("jdbc:h2:mem://localhost/~/jdbc-practice;Mode=MySQL;DB_CLOSE_DELAY=-1");//db주소
        hikariDataSource.setUsername("sa"); //db 사용자 id
        hikariDataSource.setPassword(""); // db 사용자 pwd

        return hikariDataSource;
    }
}
