package pack;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "CustomerService")
public class CustomerService {

    @WebMethod(operationName = "updateCustomer")
    public String updateCustomer(@WebParam(name = "customer") Customer customer) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb");

            // Prepare SQL query to update customer information
            PreparedStatement stmt = connection.prepareStatement("UPDATE customers SET name = ?, email = ? WHERE id = ?");
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setInt(3, customer.getId());

            // Execute update query
            int rowsAffected = stmt.executeUpdate();

            // Close statement
            stmt.close();

            if (rowsAffected > 0) {
                return "Customer updated successfully";
            } else {
                return "Failed to update customer";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "An error occurred while updating customer";
        } finally {
            // Close connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @WebMethod(operationName = "getAllCustomers")
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                customers.add(new Customer(id, name, email));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return customers;
    }
}
