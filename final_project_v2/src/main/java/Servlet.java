
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

@WebServlet(name = "Servlet", urlPatterns={"/Servlet"})
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><link rel=\"stylesheet\" href=\"small.css\"></head><body>");
        String orderId = request.getParameter("order_id");
        String sale = request.getParameter("sale");
        String tip = request.getParameter("tip");

        if (orderId.isEmpty()) {
            orderId = "N/A";
        }
        if (sale.isEmpty()) {
            sale = "N/A";
        }
        if (tip.isEmpty()) {
            tip = "N/A";
        }

        boolean orderIdExc = new int_exception(orderId).getBoolean();
        boolean saleExc = new double_exception(sale).getBoolean();
        boolean tipExc = new double_exception(tip).getBoolean();

        String errHead = "<h1>One or more of your inputs are incorrect</h1>" +
                "<h2>This is what you entered</h2>";
        String errOrderId = "<p class=\"err-inp\">Order ID: " + orderId + "</p><p class=\"err-msg\">The order ID must be a whole number</p>";
        String errSale = "<p class=\"err-inp\">Sale Amount: " + sale + "</p><p class=\"err-msg\">The sale amount must be a number</p>";
        String errTip = "<p class=\"err-inp\">Tip Amount: " + tip + "</p><p class=\"err-msg\">The tip amount must be a number</p>";

        String goodHead = "<h1>This is what you entered</h1>";
        String goodOrderId = "<p>Order ID: " + orderId + "</p>";

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
                out.println("<p>Sale Amount: " + formatter.format(Double.parseDouble(sale)) + "</p>");
            }
            if (!tipExc) {
                out.println(errTip);
            } else {
                out.println("<p>Tip Amount: " + formatter.format(Double.parseDouble(tip)) + "</p>");
            }
            out.println("<form action=\"tip_tracker.html\"><input class=\"red\" type=\"submit\" value=\"Try Again\"></form>");
        } else {
            String goodSale = "<p>Sale Amount: " + formatter.format(Double.parseDouble(sale)) + "</p>";
            String goodTip = "<p>Tip Amount: " + formatter.format(Double.parseDouble(tip)) + "</p>";
            out.println(goodHead + goodOrderId + goodSale + goodTip);
            out.println("<form action=\"collection_servlet\" method=\"post\"><input class=\"grn\" type=\"submit\" value=\"Log Entry\"></form>");
            out.println("<form action=\"tip_tracker.html\"><input class=\"red\" type=\"submit\" value=\"Re-Enter Tip\"></form>");
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
