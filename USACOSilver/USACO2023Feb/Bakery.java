package USACO2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bakery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        PrintWriter pw = new PrintWriter(System.out);
        while (t > 0) {
            br.readLine();
            int ans1 = 0;
            int ans2 = 0;
            int ans3 = 0;
            tokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int cookie = Integer.parseInt(tokenizer.nextToken());
            int muffin = Integer.parseInt(tokenizer.nextToken());
            int[][] friends = new int[n][3];
            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int e = 0; e < 3; e++) {
                    friends[i][e] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            java.util.Arrays.sort(friends, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[2] > b[2])
                        return 1;
                    else if (b[2] > a[2])
                        return -1;
                    return 0;
                }
            });
            int muffin1 = 0;
            int muffin2 = Integer.MAX_VALUE;
            int cookie1 = 0;
            int cookie2 = Integer.MAX_VALUE;
            int combined1 = 0;
            int combined2 = Integer.MAX_VALUE;
            int cookieSum = 0;
            int muffinSum = 0;
            for (int i = 0; i < n; i++) {
                cookieSum += friends[i][0];
                muffinSum += friends[i][1];
                if ((double) cookieSum / friends[i][2] > cookie1 / cookie2) {
                    cookie1 = cookieSum;
                    cookie2 = friends[i][2];
                }
                if ((double) muffinSum / friends[i][2] > muffin1 / muffin2) {
                    muffin1 = muffinSum;
                    muffin2 = friends[i][2];
                }
                if ((double) (muffinSum + cookieSum) / friends[i][2] > combined1 / combined2) {
                    combined1 = muffinSum + cookieSum;
                    combined2 = friends[i][2];
                }
                // System.out.println((double) cookieSum / friends[i][2]);
                // System.out.println((double) muffinSum / friends[i][2]);
                // System.out.println((double) (muffinSum + cookieSum) / friends[i][2]);
            }
            if ((double) cookie1 > (double) cookie2 / cookie) {
                ans1 += (int) ((double) cookie - ((double) cookie2 / cookie1));
                cookie = cookie2 / cookie1;
            }
            if ((double) muffin1 > (double) muffin2 / muffin) {
                ans2 += (int) ((double) muffin - ((double) muffin2 / muffin1));
                muffin = muffin2 / muffin1;
            }
            if ((double) combined2 / combined1 < ((double) cookie + muffin)) {
                ans3 += (cookie + muffin) - (combined2 / combined1);
            }
            pw.println(ans1 + ans2 + ans3);
            t--;
        }
        pw.close();
    }
}