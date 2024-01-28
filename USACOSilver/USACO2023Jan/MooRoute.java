package USACO2023Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MooRoute {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int[] cross = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            cross[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int pos = 1;
        while (pos != 0 && cross[pos] != 0) {
            while (cross[pos] > 0) {
                pw.print('R');
                cross[pos] -= 1;
                pos += 1;
            }
            while (pos > 1 && (cross[pos - 1] > 1 || cross[pos] == 0)) {
                pw.print('L');
                pos -= 1;
                cross[pos] -= 1;
            }
        }
        pw.close();
    }
}