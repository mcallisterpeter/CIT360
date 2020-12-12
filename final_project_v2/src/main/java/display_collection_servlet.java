import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "display_collection_servlet", urlPatterns={"/display_collection_servlet"})
public class display_collection_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        HttpSession session = request.getSession();
        List tipCollection = (ArrayList<List>) session.getAttribute("my_collection");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><link rel=\"stylesheet\" href=\"small.css\"></head><body>");
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
                    "<td>" + formatter.format(Double.parseDouble((String)tipCollection.get(i++))) + "</td>" +
                    "<td>" + formatter.format(Double.parseDouble((String)tipCollection.get(i))) + "</td>" +
                    "</tr>");
        }

        out.println("</tbody>" +
                "</table>");

        out.println("<form action=\"hibernate_servlet\" method=\"post\"><input class=\"grn\" type=\"submit\" value=\"Log all entries\"></form>");
        out.println("<form action=\"complete_servlet\" method=\"get\"><input class=\"red\" type=\"submit\" value=\"Delete all entries\"></form>");

        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This resource is not available directly.");

    }
}
