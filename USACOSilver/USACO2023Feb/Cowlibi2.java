package USACO2023Feb;

import java.util.*;

public class Cowlibi2 {
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

        // Sort grazing locations and cows' alibis by time
        Arrays.sort(grazings, (a, b) -> Integer.compare(a[2], b[2]));
        Arrays.sort(alibis, (a, b) -> Integer.compare(a[2], b[2]));

        // Check innocence of each cow
        int innocentCount = N;
        int j = 0; // Index of the last grazing location considered
        for (int i = 0; i < N; i++) {
            while (j < G && grazings[j][2] <= alibis[i][2]) {
                j++;
            }
            for (int k = 0; k < j; k++) {
                int distance = Math.abs(grazings[k][0] - alibis[i][0]) +
                        Math.abs(grazings[k][1] - alibis[i][1]);
                int timeRequired = distance + (alibis[i][2] - grazings[k][2]);
                if (timeRequired <= grazings[k][2]) {
                    // Cow can reach this grazing location before or at the same time as grazing
                    innocentCount--;
                    break;
                }
            }
        }

        // Output the result
        System.out.println(innocentCount);
    }
}
