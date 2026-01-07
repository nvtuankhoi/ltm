package RMI.B22DCCN466;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.RMI.ByteService;

public class MaHoaCaesar2 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN466", "i0EVI2TB");
        for (byte x : a)
            System.out.print(x + " ");
        System.out.println("");
        int doDich = a.length;
        for (int i = 0; i < a.length; i++)
            a[i] += doDich;
        for (byte x : a)
            System.out.print(x + " ");
        // c.
        sv.submitData("B22DCCN466", "i0EVI2TB", a);
    }
}
