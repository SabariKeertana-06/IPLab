package newpackage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int seatsRequested = Integer.parseInt(request.getParameter("seats"));
        HttpSession session = request.getSession(true);
        Integer reservedSeats = (Integer) session.getAttribute("reservedSeats");
        if (reservedSeats == null) {
            reservedSeats = 0;
        }

        int availableSeats = 100 - reservedSeats;
        if (seatsRequested > availableSeats) {
            response.getWriter().println("<html><head><title>Error</title></head><body>");
            response.getWriter().println("<h2>Sorry, there are not enough seats available.</h2>");
            response.getWriter().println("<p>Please try reserving fewer seats.</p>");
            response.getWriter().println("</body></html>");
        } else {
            reservedSeats += seatsRequested;
            session.setAttribute("reservedSeats", reservedSeats);
            response.getWriter().println("<html><head><title>Reservation Confirmation</title></head><body>");
            response.getWriter().println("<h2>Reservation Successful!</h2>");
            response.getWriter().println("<p>Hello, " + name + ". You have successfully reserved " + seatsRequested + " seat(s).</p>");
            response.getWriter().println("<p>Available seats: " + (100 - reservedSeats) + "</p>");
            response.getWriter().println("</body></html>");
        }
    }
}
