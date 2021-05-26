import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "ServletListUser")
public class ServletListUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java19", "root", "koodinh");
            PreparedStatement prp = conn.prepareStatement("SELECT * FROM users");
            ResultSet rs =  prp.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()){
                User user = new User(rs.getString("id"), rs.getString("username"), rs.getString("fullname"), rs.getString("address"));
                users.add(user);
            }

            request.setAttribute("users", users);

            //load view
            request.getRequestDispatcher("WEB-INF/listUser.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
