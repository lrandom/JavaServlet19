import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCookieDemo")
public class ServletCookieDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //set cookie
        /*Cookie cookie = new Cookie("user_id", "001");
        cookie.setMaxAge(3600); //1 tiếng
        response.addCookie(cookie);//đẩy cookie và lưu trữ ở phía người dùng*/

        //reset cookie
        /*Cookie cookie1 = new Cookie("user_id", "002");
        cookie1.setMaxAge(3600);
        response.addCookie(cookie);*/
        
        /*Cookie cookie = new Cookie("user_id", "002");
        cookie.setMaxAge(0);//xoá cookie
        response.addCookie(cookie);*/


        Cookie[] cookies = request.getCookies();
        Cookie cookie = getCookie(cookies);
        System.out.println(cookie.getValue());
    }

    public Cookie getCookie(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user_id")) {
                return cookie;
            }
        }
        return null;
    }
}
