import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "display_collection_servlet", urlPatterns={"/display_collection_servlet"})
public class display_collection_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List tipCollection = (ArrayList<List>) session.getAttribute("my_collection");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><style>" +
                ".mytable {text-align: center; margin-bottom: 25px;}" +
                ".mytable, .mytable * {border: 1px solid black; border-collapse: collapse;}" +
                ".mytable * {padding: 5px;}" +
                "</style></head><body>");
        out.println("<h1>Here are your tips for today</h1>");
        out.println("<table class=\"mytable\">" +
                "<thead>" +
                "<tr>" +
                "<th>DATE</th>" +
                "<th>ORDER ID</th>" +
                "<th>SALE</th>" +
                "<th>TIP</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>");

        for (int i = 0; i < tipCollection.size(); i++) {
            out.println("<tr>" +
                    "<td>" + tipCollection.get(i++) + "</td>" +
                    "<td>" + tipCollection.get(i++) + "</td>" +
                    "<td>" + tipCollection.get(i++) + "</td>" +
                    "<td>" + tipCollection.get(i) + "</td>" +
                    "</tr>");
        }

        out.println("</tbody>" +
                "</table>");

        out.println("<form action=\"hibernate_servlet\" method=\"post\"><input type=\"submit\" value=\"Log all entries\"></form>");
        out.println("<form action=\"index.jsp\"><input type=\"submit\" value=\"Delete All Entries\"></form>");

        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This resource is not available directly.");

    }
}
