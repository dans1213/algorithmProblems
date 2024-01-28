import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LivestockLineup {
    static ArrayList<String> CowOrder = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"}
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int input = Integer.parseInt(r.readLine());
        int[] count = new int[8];
        String[][] arr = new String[input][2];
        for(int i=0;i<input;i++){
            String[] temp = r.readLine().split(" ");
            count[CowOrder.indexOf(temp[0])]++;
            count[CowOrder.indexOf(temp[0])]++;
            arr[i][0]=temp[0];
            arr[i][1]=temp[6];
        }
        String[] ans = new String[input];
        for(int i=0;i<input;i++){
            
        }
    }
}
