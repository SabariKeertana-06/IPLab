package pack;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.List;

public class CustomerServiceClient {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/exp14/CustomerService?WSDL");
            QName qname = new QName("http://pack/", "CustomerService");
            Service service = Service.create(url, qname);
            CustomerService customerService = service.getPort(CustomerService.class);
            Customer customerToUpdate = new Customer(1, "sss", "sss@example.com");
            String updateResult = customerService.updateCustomer(customerToUpdate);
            System.out.println("Update Result: " + updateResult);
            List<Customer> customers = customerService.getAllCustomers();
            System.out.println("All Customers:");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
