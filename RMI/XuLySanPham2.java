package RMI.B22DCCN466;

import java.rmi.*;
import java.rmi.registry.*;

import RMI.RMI.ObjectService;
import RMI.RMI.ProductX;

public class XuLySanPham2 {
    public static void main(String[] args) throws Exception {
        // a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        ProductX product = (ProductX) sv.requestObject("B22DCCN466", "PY43T66m");
        System.out.println(product);
        // b. Thực hiện chuẩn hóa sản phẩm:
        int tong = 0;
        for (char x : product.getDiscountCode().toCharArray()) {
            if (Character.isDigit(x))
                tong += Character.getNumericValue(x);
        }
        product.setDiscount(tong);
        // c. Triệu gọi phương thức submitObject để gửi đối tượng đã chuẩn hóa trở lại
        // server
        System.out.println(product);
        sv.submitObject("B22DCCN466", "PY43T66m", product);
    }
}
