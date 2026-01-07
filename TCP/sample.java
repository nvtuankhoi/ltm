package TCP;

import java.io.*;
import java.net.*;

public class sample {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        DataInputStream din = new DataInputStream(in);
        DataOutputStream dout = new DataOutputStream(out);
        ObjectInputStream oin = new ObjectInputStream(in);
        ObjectOutputStream oout = new ObjectOutputStream(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

        in.close();
        out.close();
        socket.close();
    }
}
