package a00jdbc.a01JDBC날것;

import a00jdbc.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;





public class UserDaoTest {


    //테스트들을수행하기 전에 수행되어야할 테이블을 만드는 로직을 위해 HikariCP  ,  Spring JDBC 의 종속성을 추가해줬음
    @BeforeEach
    void setUp(){
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();//spring-jdbc 에 있는 클래스
        populator.addScript(new ClassPathResource("db_schema.sql")); //db_schema.sql 이라는 파일을 classPath 에서 읽어와서 스크립트에추가
        DatabasePopulatorUtils.execute(populator, MyDataSource.getDataSource());//HikariCP 는 hikariDatasource 가져올때 사용됨
    }


    //
    @Test
    void createTest() throws SQLException {
        UserDao userDao = new UserDao(); //Data Access Object 객체 생성
        User user1 = new User("myid", "pwd", "name", "email");
        userDao.create(user1);//db에 저장
        User user2 = userDao.findById("myid");
        assertThat(user2).isEqualTo(user1);

        User nullUser = userDao.findById("yourid");
        assertThat(nullUser).isNull();
    }


}


