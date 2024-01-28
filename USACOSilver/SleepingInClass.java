import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SleepingInClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int in =Integer.parseInt(tokenizer.nextToken());
        for(int i=0;i<in;i++){
            tokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            String[] splitArray = br.readLine().split(" ");
            int[] array = new int[splitArray.length];
            for (int e = 0; e < splitArray.length; i++) {
                array[i] = Integer.parseInt(splitArray[i]);
            }
            pw.print(solve(n,array));
        }
        pw.close();
    }
    public static int solve(int n, int[] array){
        aa :
        for(int i=1;i<n;i++){
            if((double)n/i==(n/i)){
                int temp=0;
                int count=0;
                for(int e=0;e<array.length;e++){
                    if(temp==n/i){
                        temp=0;
                    }
                    else if (temp>n/i){
                        continue aa;
                    }
                    temp+=array[e];
                    count++;
                }
                return count;
            }
        }
        return -1;
    }
}