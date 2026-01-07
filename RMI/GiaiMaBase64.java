package RMI.B22DCCN466;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;

import RMI.RMI.ByteService;

public class GiaiMaBase64 {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN466", "oeJljCIf");
        // b. Giải mã
        String s = new String(a); // Byte -->String
        System.out.println(s);
        byte[] ans = Base64.getDecoder().decode(s); // Giải mã Base64
        for (byte x : ans)
            System.out.print(x + " ");
        System.out.println();
        // c.
        sv.submitData("B22DCCN466", "oeJljCIf", ans);
    }
}
