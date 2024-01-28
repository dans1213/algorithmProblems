import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CandyCaneFeast {
    public static void main(String[] args) throws IOException {
        // ---------------------- Initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        long[] cowsheight = new long[n];
        long[] candycaneheight = new long[m];

        // ---------------------- Inputs
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            cowsheight[i] = Long.parseLong(tokenizer.nextToken());
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            candycaneheight[i] = Long.parseLong(tokenizer.nextToken());

        // ---------------------- Simulation
        for (int i = 0; i < m; i++) {
            long currentBottom = 0;
            int idx = 0;
            while (idx < n) {
                if (cowsheight[idx] > currentBottom) {
                    long diff = Math.min(cowsheight[idx], candycaneheight[i]) - currentBottom;
                    cowsheight[idx] += diff;
                    currentBottom += diff;
                }
                idx++;
                if (currentBottom >= candycaneheight[i]) {
                    break;
                }
            }
        }

        // ---------------------- Output
        for (int i = 0; i < n; i++) {
            pw.println(cowsheight[i]);
        }
        pw.close();
    }
}
