package org.denys;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

@WebServlet("/param")
public class ParamsServlet extends HttpServlet {

    /**
     * Example of url for testing this.
     * <p>
     * http://localhost:8888/param?first=one&second=two1&second=two2
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("first");
        System.out.println("=====> param first is: " + param);

        String[] params = req.getParameterValues("second");
        System.out.println("\n=====> params second is: ");
        Stream.of(params).forEach(System.out::println);

        System.out.println("\n=====> all param names is: ");
        req.getParameterNames().asIterator().forEachRemaining(System.out::println);
    }
}
