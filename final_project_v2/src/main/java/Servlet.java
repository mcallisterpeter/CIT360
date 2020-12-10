
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns={"/Servlet"})
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head></head><body>");
        String orderId = request.getParameter("order_id");
        String sale = request.getParameter("sale");
        String tip = request.getParameter("tip");

        boolean orderIdExc = new int_exception(orderId).getBoolean();
        boolean saleExc = new double_exception(sale).getBoolean();
        boolean tipExc = new double_exception(tip).getBoolean();

        String errHead = "<h1>One or more of your inputs are incorrect</h1>" +
                "<h2>This is what you entered</h2>";
        String errOrderId = "<p style=\"color: red; font-weight: bold;\">Order ID: " + orderId + " The order ID must be a whole number</p>";
        String errSale = "<p style=\"color: red; font-weight: bold;\">Sale Amount: " + sale + " The sale amount must be a number</p>";
        String errTip = "<p style=\"color: red; font-weight: bold;\">Tip Amount: " + tip + " The tip amount must be a number</p>";

        String goodHead = "<h1>This is what you entered</h1>";
        String goodOrderId = "<p>Order ID: " + orderId + "</p>";
        String goodSale = "<p>Sale Amount: " + sale + "</p>";
        String goodTip = "<p>Tip Amount: " + tip + "</p>";

        if (!orderIdExc || !saleExc || !tipExc) {
            out.println(errHead);
            if (!orderIdExc) {
                out.println(errOrderId);
            } else {
                out.println(goodOrderId);
            }
            if (!saleExc) {
                out.println(errSale);
            } else {
                out.println(goodSale);
            }
            if (!tipExc) {
                out.println(errTip);
            } else {
                out.println(goodTip);
            }
            out.println("<form action=\"tip_tracker.html\"><input type=\"submit\" value=\"Try Again\"></form>");
        } else {
            out.println(goodHead + goodOrderId + goodSale + goodTip);
            out.println("<form action=\"tip_tracker.html\"><input type=\"submit\" value=\"Re-Enter Tip\"></form>");
            out.println("<form action=\"collection_servlet\" method=\"post\"><input type=\"submit\" value=\"Log Entry\"></form>");
        }
        out.println("</body></html>");

        HttpSession session = request.getSession();
        session.setAttribute("order_id", orderId);
        session.setAttribute("sale", sale);
        session.setAttribute("tip", tip);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This resource is not available directly.");
    }

}
