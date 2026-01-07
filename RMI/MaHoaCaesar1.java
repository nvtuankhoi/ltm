package RMI.B22DCCN466;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

import RMI.RMI.CharacterService;

public class MaHoaCaesar1 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN466", "j4rStb2a");
        System.out.println(s);
        // b.
        String ans = "";
        int dich = s.length() % 7;
        for (char x : s.toCharArray()) {
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            x = (char) ((x - base - dich + 26) % 26 + base);
            ans += x;
        }
        System.out.println(ans);
        // c.
        sv.submitCharacter("B22DCCN466", "j4rStb2a", ans);
    }
}
