import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONExample {

    public static String customerToJSON(Customer customer) {

        ObjectMapper mapper = new ObjectMapper();
        String s = "";

        try {
            s = mapper.writeValueAsString(customer);
        } catch (JsonProcessingException e) {
            System.err.println(e.toString());
        }

        return s;
    }

    public static Customer JSONToCustomer(String s) {

        ObjectMapper mapper = new ObjectMapper();
        Customer customer = null;

        try {
            customer = mapper.readValue(s, Customer.class);
        } catch (JsonProcessingException e) {
            System.err.println(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customer;
    }

    public static void main(String[] args) {

        Customer cust = new Customer();
        cust.setName("Troy");
        cust.setPhone(12345);

        String json = JSONExample.customerToJSON(cust);
        System.out.println(json);

        Customer cust2 = JSONExample.JSONToCustomer(json);
        System.out.println(cust2);
    }

}
