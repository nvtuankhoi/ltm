package RMI.B22DCCN466;

import java.rmi.*;
import java.rmi.registry.*;

import RMI.RMI.ObjectService;
import RMI.RMI.Product;

public class XuLySanPham1 {
    public static void main(String[] args) throws Exception {
        // a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Product product = (Product) sv.requestObject("B22DCCN466", "dx3nt4Ij");
        System.out.println(product);
        // b. Thực hiện chuẩn hóa sản phẩm:
        product.setCode(product.getCode().toUpperCase());// Chuyển mã sản phẩm thành in hoa
        product.setExportPrice(product.getImportPrice() * 1.2f);
        System.out.println("Normalized product: " + product);
        // c. Triệu gọi phương thức submitObject để gửi đối tượng đã chuẩn hóa trở lại
        // server
        sv.submitObject("B22DCCN466", "dx3nt4Ij", product);
    }
}
