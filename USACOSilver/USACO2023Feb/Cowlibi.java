package USACO2023Feb;

import java.util.*;

public class Cowlibi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int G = scanner.nextInt();
        int N = scanner.nextInt();

        // Read grazing locations
        int[][] grazings = new int[G][3];
        for (int i = 0; i < G; i++) {
            grazings[i][0] = scanner.nextInt();
            grazings[i][1] = scanner.nextInt();
            grazings[i][2] = scanner.nextInt();
        }
        // Read cows' alibis
        int[][] alibis = new int[N][3];
        for (int i = 0; i < N; i++) {
            alibis[i][0] = scanner.nextInt();
            alibis[i][1] = scanner.nextInt();
            alibis[i][2] = scanner.nextInt();
        }
        Arrays.sort(alibis, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[2] > b[2])
                    return 1;
                else if (b[2] > a[2])
                    return -1;
                return 0;
            }
        });
        Arrays.sort(grazings, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[2] > b[2])
                    return 1;
                else if (b[2] > a[2])
                    return -1;
                return 0;
            }
        });
        // Check innocence of each cow
        int innocentCount = 0;
        for (int i = 0; i < N; i++) {
            boolean isGuilty = false;
            for (int j = 0; j < G; j++) {
                int distance = (int) Math.sqrt(Math.pow(Math.abs(grazings[j][0] - alibis[i][0]), 2.0)
                        + Math.pow(Math.abs(grazings[j][1] - alibis[i][1]), 2.0));
                int timeRequired = distance;
                if (timeRequired > Math.abs(alibis[i][2] - grazings[j][2])) {
                    // Cow cannot reach this grazing location before or at the same time as grazing
                    continue;
                }
                isGuilty = true;
                break;
            }
            if (!isGuilty) {
                System.out.println(i);
                // Cow is innocent
                innocentCount++;
            }
        }

        // Output the result
        System.out.println(innocentCount);
    }
}