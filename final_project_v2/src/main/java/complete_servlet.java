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

@WebServlet(name = "complete_servlet", urlPatterns={"/complete_servlet"})
public class complete_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This resource is not available directly.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List tipCollection = (ArrayList<List>) session.getAttribute("my_collection");
        tipCollection.clear();

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><link rel=\"stylesheet\" href=\"small.css\"></head><body>");
        out.println("<h1>Thank you for using the Tip Tracker</h1>");
        out.println("<form action=\"index.jsp\"><input class=\"grn\" type=\"submit\" value=\"Start Over\"></form>");
        out.println("<form action=\"shutdown_servlet\" method=\"get\"><input class=\"red\" type=\"submit\" value=\"Shut Down\"></form>");
        out.println("</body></html>");

    }
}
