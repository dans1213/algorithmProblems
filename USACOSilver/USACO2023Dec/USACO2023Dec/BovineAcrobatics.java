package USACO2023Dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Comparator;

public class BovineAcrobatics {
    static int stack;
    static int gap;
    static ArrayList<Integer> cows = new ArrayList<Integer>();
    static ArrayList<Integer> amount = new ArrayList<Integer>();
    static int ans;
    static int n;
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        stack = Integer.parseInt(tokenizer.nextToken());
        gap = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<Integer> temp2 = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            temp.add(Integer.parseInt(tokenizer.nextToken()));
            temp2.add(Integer.parseInt(tokenizer.nextToken()));
            cows.add(temp.get(i));
        }
        cows.sort(Comparator.naturalOrder());
        for (int i = 0; i < n; i++) {
            amount.add(temp2.get(temp.indexOf(cows.get(i))));
        }
        solve(cows.get(0), 1, amount.get(0), cows.get(0));
        pw.print(ans);
        pw.close();
    }

    public static void solve(int currentCow, int layers, int minCow, int minCowNum) {
        if (cows.indexOf(currentCow) == cows.size() - 1) {
            for (int i = 0; i <= cows.indexOf(currentCow); i++) {
                amount.set(i, amount.get(i) - Math.min(minCow, amount.get(cows.indexOf(currentCow))));
            }
            ans += layers * Math.min(minCow, amount.get(cows.indexOf(currentCow)));
            pw.print(ans + "d ");
            remove();
            return;
        }
        for (int i = layers; i < cows.size(); i++) {
            if (cows.get(i) - currentCow >= gap) {
                if (minCow > amount.get(cows.indexOf(currentCow) + 1)) {
                    solve(cows.get(cows.indexOf(currentCow) + 1), layers + 1, amount.get(cows.indexOf(currentCow) + 1),
                            cows.get(cows.indexOf(currentCow) + 1));
                } else {
                    solve(cows.get(cows.indexOf(currentCow) + 1), layers + 1, minCow, minCowNum);
                }
                break;
            }
        }
        int minCowCount = cows.indexOf(minCowNum);
        if (minCowCount != -1 && cows.indexOf(currentCow) != -1) {
            minCow = amount.get(minCowCount);
            minCowNum = cows.get(minCowCount);
            for (int i = 0; i <= cows.indexOf(currentCow); i++) {
                amount.set(i, amount.get(i) - minCow);
            }
            ans += (cows.indexOf(currentCow) + 1) * minCow;
            pw.print(ans + "d ");
            remove();
        }
        // if (cows.indexOf(currentCow) != -1) {
        // int newMin = Integer.MAX_VALUE;
        // int diffMin=minCowNum-cows.indexOf(minCowNum);
        // if(diffMin>minCowNum){
        // for (int i = 0; i < cows.indexOf(currentCow); i++) {
        // newMin = Math.min(amount.get(i), newMin);
        // }
        // }
        // for (int i = 0; i <= cows.indexOf(currentCow); i++) {
        // amount.set(i, amount.get(i) - newMin);
        // }
        // ans += (cows.indexOf(currentCow) + 1) * newMin;
        // pw.print(layers);
        // remove();
        // }
    }

    public static void remove() {
        int index = amount.indexOf(0);
        while (index != -1) {
            amount.remove(index);
            cows.remove(index);
            index = amount.indexOf(0);
        }
    }
}