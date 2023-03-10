package a00servlet.b01servlet;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class WebApplicationServer {

    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

    public static void main(String[] args) throws LifecycleException {

        String webappDirLocation = "03-servlet/webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        //contextPath를 "/" 로 입력햇을때 , 루트디렉토리를 webappDirLocation(webapp/) 으로 설정하고 여기 하위에서 톰캣은 파일들을 찾을거임
        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        log.info("configuring app with basedir: {}", new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();

        //이 메서드를 실행하면 빌드된 WebApplicationServer가  webapp아래로 들어가게됨.

        //톰캣이 실행되면서 webapp 폴더가 만들어지고, 빌드된 WebApplicationServer 가 module compile output path 로 들어가게됨
        //톰캣이 실행되면 output path 인 webapp/WEB-INF/classes 에서 파일들을 찾게됨
    }
}