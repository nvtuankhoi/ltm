package WebService.B22DCCN466;

import vn.medianews.*;
import java.util.*;

public class TimSoLonNhat {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN466", qCode = "RiRH8wfk";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        List<String> a1 = new java.util.ArrayList<>();
        for (int x : a)
            a1.add(x + "");
        Collections.sort(a1);
        String ans = "";
        for (String x : a1)
            ans += x + ans;
        port.submitDataString(msv, qCode, ans);
    }
}
