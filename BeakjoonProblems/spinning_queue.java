import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class spinning_queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int m = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        int[] input = new int[n];
        int ans = 0;
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(tokenizer.nextToken());
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i <= m; i++) {
            arr.add(i);
        }
        for (int i = 0; i < n; i++) {
            int index = arr.indexOf(input[i]);
            if (arr.size() - index >= index) {
                for (int e = 0; e < index; e++) {
                    ans++;
                    arr.add(arr.get(0));
                    arr.remove(0);
                }
            } else {
                for (int e = arr.size(); e > index; e--) {
                    ans++;
                    arr.add(0, arr.get(arr.size() - 1));
                    arr.remove(arr.size() - 1);
                }
            }
            arr.remove(0);
        }
        pw.print(ans);
        pw.close();
    }
}