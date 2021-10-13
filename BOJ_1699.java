// boj 1699 : 제곱수의 합

import java.util.Arrays;
import java.util.Scanner;

public class boj_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int dp[] = new int[N+1]; // dp[N] : N을 만드는 최소 개수

        // 1 2 3 4 5 6 7 8 9 10 11 32
        // 1 2 3 1 2 3 4 2 1  2  3  2

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0]=1;
        for(int i=1; i<=(int)Math.sqrt(N); i++)
            dp[(int)Math.pow(i,2)] = 1;

        for(int i=2; i<=N; i++) {
            for(int j=(int)Math.sqrt(i); j>=1; j--){

                int nn = (int) Math.pow(j, 2);
                int rest = i - nn;

                if(dp[i]>dp[rest]+dp[nn]) dp[i]=dp[rest]+dp[nn];
                else continue;
            }
        }

        System.out.println(dp[N]);

    }
}
