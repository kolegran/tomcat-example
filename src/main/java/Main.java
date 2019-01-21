import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8082);

        Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());

        Tomcat.addServlet(ctx, "Embedded", new LoginServlet());

        ctx.addServletMapping("/*", "Embedded");

        tomcat.start();
        tomcat.getServer().await();
    }
}
