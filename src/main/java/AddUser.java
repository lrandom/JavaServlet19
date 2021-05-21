import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "AddUser")
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String username = req.getParameter("username");
        String fullName = req.getParameter("fullName");
        String address = req.getParameter("address");
        String id = req.getParameter("id");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java19", "root", "koodinh");
            PreparedStatement prp = conn.prepareStatement("INSERT INTO users(id,fullname,username,address) VALUES(?,?,?,?)");
            prp.setInt(1, new Integer(id).intValue());
            prp.setString(2, fullName);
            prp.setString(3, username);
            prp.setString(4, address);
            prp.execute();
        }catch (Exception e){

        }
    }
}
