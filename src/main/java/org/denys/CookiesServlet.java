package org.denys;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

@WebServlet("/cookie")
public class CookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[]cookies = req.getCookies();
        Stream.of(cookies).map(Cookie::getName).forEach(System.out::println);
        Cookie cookie = new Cookie("myCookie", "value of my cookie");
        cookie.setMaxAge(5);
        resp.addCookie(cookie);
    }
}
