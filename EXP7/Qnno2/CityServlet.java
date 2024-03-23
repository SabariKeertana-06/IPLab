package city;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private City[] cities;

    public void init() throws ServletException {
        // Add some cities for demonstration
        cities = new City[]{
            new City("New York", 8623000),
            new City("Los Angeles", 3999759),
            new City("Chicago", 2716000),
            new City("Houston", 2329000)
        };
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortBy = request.getParameter("sortBy");
        if (sortBy != null && sortBy.equals("population")) {
            sortByPopulation();
        } else {
            sortByName();
        }

        response.setContentType("text/html");
        response.getWriter().println("<html><head><title>List of Cities</title></head><body>");
        response.getWriter().println("<h2>List of Cities</h2>");
        response.getWriter().println("<table border=\"1\">");
        response.getWriter().println("<tr><th>Name</th><th>Population</th></tr>");
        for (City city : cities) {
            response.getWriter().println("<tr><td>" + city.getName() + "</td><td>" + city.getPopulation() + "</td></tr>");
        }
        response.getWriter().println("</table>");
        response.getWriter().println("<p>Sort by: <a href=\"?sortBy=name\">Name</a> | <a href=\"?sortBy=population\">Population</a></p>");
        response.getWriter().println("</body></html>");
    }
    
    private void sortByPopulation() {
        for (int i = 0; i < cities.length - 1; i++) {
            for (int j = 0; j < cities.length - i - 1; j++) {
                if (cities[j].getPopulation() > cities[j + 1].getPopulation()) {
                    // Swap
                    City temp = cities[j];
                    cities[j] = cities[j + 1];
                    cities[j + 1] = temp;
                }
            }
        }
    }
    
    private void sortByName() {
        for (int i = 0; i < cities.length - 1; i++) {
            for (int j = 0; j < cities.length - i - 1; j++) {
                if (cities[j].getName().compareTo(cities[j + 1].getName()) > 0) {
                    // Swap
                    City temp = cities[j];
                    cities[j] = cities[j + 1];
                    cities[j + 1] = temp;
                }
            }
        }
    }
}

   