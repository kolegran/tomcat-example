import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws LifecycleException, ServletException {
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8082);

        Context ctx = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());

        Tomcat.addServlet(ctx, "Embedded", new LoginServlet());
        ctx.addServletMapping("/login", "Embedded");

        tomcat.start();
        tomcat.getServer().await();
    }
}
