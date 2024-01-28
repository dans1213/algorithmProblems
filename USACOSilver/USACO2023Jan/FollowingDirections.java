package USACO2023Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FollowingDirections {
    static int n;
    static int[][] price;
    static boolean[][] filled;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        int[] sidePrice = new int[n];
        int[] bottomPrice = new int[n];
        price = new int[n][n];
        filled = new boolean[n][n];
        StringTokenizer tokenizer;
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            String str = tokenizer.nextToken();
            for (int e = 0; e < n; e++) {
                arr[e][i] = str.charAt(e);
            }
            sidePrice[i] = Integer.parseInt(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bottomPrice[i] = Integer.parseInt(tokenizer.nextToken());
        }
        for (int i = 0; i < n; i++) {
            for (int e = 0; e < n; e++) {
                if (filled[i][e])
                    continue;
                setprice(arr, sidePrice, bottomPrice, i, e);
            }
        }
        int k = Integer.parseInt(br.readLine());
        while (k > 0) {
            tokenizer = new StringTokenizer(br.readLine());
            // int x=Integer.parseInt(tokenizer.nextToken());
            // int y=Integer.parseInt(tokenizer.nextToken());

        }
        pw.close();
    }

    public static int setprice(char[][] direction, int[] sidePrice, int[] bottomPrice, int x, int y) {
        filled[x][y] = true;
        if (x + 1 >= n && direction[x][y] == 'R') {
            price[x][y] = sidePrice[y];
            return price[x][y];
        } else if (y + 1 >= n && direction[x][y] == 'D') {
            price[x][y] = bottomPrice[x];
            return price[x][y];
        }
        if (direction[x][y] == 'R') {
            price[x][y] = setprice(direction, sidePrice, bottomPrice, x + 1, y);
        } else if (direction[x][y] == 'D') {
            price[x][y] = setprice(direction, sidePrice, bottomPrice, x, y + 1);
        }
        return price[x][y];
    }
}