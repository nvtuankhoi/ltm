package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;

public class Byte {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN466", "oeJljCIf"); // Thay MSV mã câu hỏi tương ứng
        // b. Xử lý
        // Giả sử sau rất nhiều bước xử lý, từ mảng byte []a, các bạn thu được mảng kết
        // quả byte []ans
        // c.
        sv.submitData("B22DCCN466", "oeJljCIf", ans); // Gửi lên sv, thay msv mã đề tương ứng
    }
}
