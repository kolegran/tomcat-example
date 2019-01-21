import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = readContentFromResource("form.jsp");
        resp.getOutputStream().println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("username: " + username);
        System.out.println("password: " + password);

        req.setAttribute("user", username);
        String html = readContentFromResource("resp.jsp");
        resp.getOutputStream().println(html.replaceAll("\\$\\{user\\}", username));
    }

    private String readContentFromResource(String resourceName) throws IOException {
        InputStream is = LoginServlet.class.getClassLoader().getResourceAsStream(resourceName);

        return new String(new BufferedInputStream(is).readAllBytes());
    }
}
