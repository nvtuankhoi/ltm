package RMI.B22DCCN466;

import RMI.RMI.ObjectService;
import RMI.RMI.Order;

import java.rmi.*;
import java.rmi.registry.*;

public class TDMT {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Order order = (Order) sv.requestObject("B22DCCN466", "vLJWvWpf");
        System.out.println(order);
        // b.
        String x = order.getShippingType().substring(0, 2).toUpperCase(); // Hai ký tự đầu của shippingType
        String y = order.getCustomerCode().substring(order.getCustomerCode().length() - 3); // Ba ký tự cuối của
                                                                                            // customerCode
        String z = order.getOrderDate().substring(8, 10) + order.getOrderDate().substring(5, 7); // ddMM từ orderDate
        String orderCode = x + y + z;
        order.setOrderCode(orderCode);
        // c
        System.out.println(order);
        sv.submitObject("B22DCCN466", "vLJWvWpf", order);
    }
}
