import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "collection_servlet", urlPatterns={"/collection_servlet"})
public class collection_servlet extends HttpServlet {

    List tipCollection = new ArrayList();
    Date oldDate = new Date();
    SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
    String myDate = sdfr.format(oldDate);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head></head><body>");

        HttpSession session = request.getSession();
        String orderId = (String) session.getAttribute("order_id");
        String sale = (String) session.getAttribute("sale");
        String tip = (String) session.getAttribute("tip");

        tipCollection.add(myDate);
        tipCollection.add(orderId);
        tipCollection.add(sale);
        tipCollection.add(tip);

        out.println("<h1>Entry has been logged</h1>");
        out.println("<form action=\"tip_tracker.html\"><input type=\"submit\" value=\"Enter Another Tip\"></form>");
        out.println("<form action=\"display_collection_servlet\" method=\"post\"><input type=\"submit\" value=\"Done for the Day\"></form>");


        out.println("</body></html>");

        session.setAttribute("my_collection", tipCollection);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This resource is not available directly.");
    }
}
