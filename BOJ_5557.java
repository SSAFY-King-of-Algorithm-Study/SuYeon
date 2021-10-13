// boj 5557 : 1학년

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num[] = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        long dp[][] = new long[101][21]; // dp[index][sum]
        dp[0][num[0]] = 1;

        for(int i=1; i<N-1; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j]!=0){
                    if(j+num[i]<=20)
                        dp[i][j+num[i]] += dp[i-1][j];
                    if(j-num[i]>=0)
                        dp[i][j-num[i]] += dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N-2][num[N-1]]);

    }
}
