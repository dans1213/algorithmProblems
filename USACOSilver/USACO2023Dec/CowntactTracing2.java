import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class CowntactTracing2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        // ------------ Input
        int n= Integer.parseInt(tokenizer.nextToken());
        tokenizer=new StringTokenizer(br.readLine());
        int[] cows = new int[n];
        for(int i=0;i<n;i++){
            cows[i]=Integer.parseInt(tokenizer.nextToken());
        }
        int[] temp=new int[n];
        int idx=0;
        for(int i=0;i<n-1;i++){
            if(cows[i]==cows[i+1]&&cows[i]==0){
                continue;
            }
            if(cows[i+1]==0){
                idx++;
            }
            temp[idx]++;
        }
        if(cows[n-1]==1){
            temp[idx]++;
        }
        int[] groupArr=new int[idx+1];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<idx+1;i++){
            groupArr[i]=temp[i];
            min=Math.min(min,temp[i]);
        }
        int minDays=0;
        if(min%2==1){
            minDays=min/2;
        }
        else{
            minDays=min/2-1;
        }
        
        pw.close();
    }
}
