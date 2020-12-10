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

@WebServlet(name = "hibernate_servlet", urlPatterns={"/hibernate_servlet"})
public class hibernate_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        List tipCollection = (ArrayList<List>) session.getAttribute("my_collection");

        try {
            TipsDAO tipsDAO = new TipsDAO();
            for ( int i = 0; i < tipCollection.size(); i++) {
                tipsDAO.addTipInfo((String)tipCollection.get(i++),(String)tipCollection.get(i++),(String)tipCollection.get(i++),(String)tipCollection.get(i));
            }
            response.sendRedirect("complete_servlet");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This resource is not available directly.");
    }
}
