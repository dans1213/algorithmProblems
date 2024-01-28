package USACO2023Feb;

import java.util.*;

public class Bakery2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            long tC = sc.nextLong();
            long tM = sc.nextLong();
            List<Order> orders = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                long a = sc.nextLong();
                long b = sc.nextLong();
                long c = sc.nextLong();
                orders.add(new Order(a, b, c));
            }
            long ans = solve(orders, tC, tM);
            System.out.println(ans);
        }
        sc.close();
    }

    static long solve(List<Order> orders, long tC, long tM) {
        Collections.sort(orders);
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < orders.size(); i++) {
            long a = orders.get(i).a;
            long b = orders.get(i).b;
            long c = orders.get(i).c;
            long time = a * tC + b * tM;
            if (time <= c) {
                ans = 0;
                break;
            }
            for (long j = 0; j < tC && j <= ans; j++) {
                long tc = tC - j;
                long tm = tM;
                if (tc == 0) {
                    continue;
                }
                long x = (time - c + tc - 1) / tc;
                long y = Math.min(x, b);
                long z = x - y;
                long newTime = (a + y) * (tC - j) + z * tm;
                if (newTime <= c) {
                    ans = Math.min(ans, j + x);
                }
            }
            for (long j = 0; j < tM && j <= ans; j++) {
                long tc = tC;
                long tm = tM - j;
                if (tm == 0) {
                    continue;
                }
                long x = (time - c + tm - 1) / tm;
                long y = Math.min(x, a);
                long z = x - y;
                long newTime = (b + y) * (tM - j) + z * tc;
                if (newTime <= c) {
                    ans = Math.min(ans, j + x);
                }
            }
        }
        return ans;
    }

    static class Order implements Comparable<Order> {
        long a;
        long b;
        long c;

        Order(long a, long b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo(Order other) {
            return Long.compare(this.c, other.c);
        }
    }
}