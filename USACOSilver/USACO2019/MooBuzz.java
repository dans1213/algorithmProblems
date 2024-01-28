package USACO2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MooBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("moobuzz.in")));
        PrintWriter pw = new PrintWriter(new File("moobuzz.out"));
        int n = Integer.parseInt(br.readLine());
        int count = n / 8 * 15;
        int temp = n % 8;
        while (true) {
            if (temp == 0)
                break;
            if (temp % 3 != 0 && temp % 5 != 0) {
                count++;
            }
            temp--;
        }
        pw.print(count + temp);
        pw.close();
    }
}