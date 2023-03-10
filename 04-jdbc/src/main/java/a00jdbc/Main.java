package a00jdbc;

import a00jdbc.a02DB커넥션풀.ConnectionManager;
import a00jdbc.a02DB커넥션풀.UserDao;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {


        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();//spring-jdbc 에 있는 클래스
        populator.addScript(new ClassPathResource("db_schema.sql")); //db_schema.sql 이라는 파일을 classPath 에서 읽어와서 스크립트에추가
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());//HikariCP 는 hikariDatasource 가져올때 사용됨

        UserDao userDao = new UserDao();
        User finduser = userDao.findById("asdf");
        System.out.println(finduser);

    }
}