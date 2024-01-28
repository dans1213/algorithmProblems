import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MooOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int q = Integer.parseInt(r.readLine());
        // ------------ All cases where output is -1
        for (int i = 0; i < q; i++) {
            String input = r.readLine();
            if (input.length() < 3) {
                pw.println(-1);
                continue;
            }
            String temp = input.substring(1, input.length() - 1);
            if (temp.indexOf("O") == -1) {
                pw.println(-1);
                continue;
            }
            // ------- All cases have a value >0
            int ans = -1;
            if (input.indexOf("OOM") != -1) {
                ans = 2 + input.length() - 3; // 2(OOM case) + input.length() -3 (actions to delete)
            }
            if (input.indexOf("MOM") != -1 || input.indexOf("OOO") != -1) {
                ans = 1 + input.length() - 3; // 1(MOM or OOO case) + input.length() -3 (actions to delete)
            }
            if (input.indexOf("MOO") != -1) {
                ans = input.length() - 3; // 0(MOO case) + input.length() -3 (actions to delete)
            }
            pw.println(ans);
        }
        pw.close();
    }
}
