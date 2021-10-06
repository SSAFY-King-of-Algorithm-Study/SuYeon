// boj 17471 : 게리멘더링

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, ans=Integer.MAX_VALUE;
    static int person[];
    static List<Integer> nodes[];
    static boolean section[], checked[];

    private static void dfs(int x, boolean flag){
        for(int i=0; i<nodes[x].size(); i++){
            int next = nodes[x].get(i);

            if(section[next]==flag && !checked[next]){
                checked[next] = true;
                dfs(next, flag);
            }
        }
    }

    private static boolean checkSection(){
        // true 표시된 구역
        for(int i=1; i<=N; i++){
            if(section[i]){
                checked[i] = true;
                dfs(i, true);
                break;
            }
        }

        // false 표시된 구역
        for(int i=1; i<=N; i++){
            if(!section[i]){
                checked[i] = true;
                dfs(i,false);
                break;
            }
        }

        for(int i=1; i<=N; i++){
            if(!checked[i]) return false;
        }

        return true;
    }

    private static void comb(int cnt){
        if(cnt==N){
            // checked 초기화
            for(int i=1; i<=N; i++)
                checked[i] = false;

            if(checkSection()){
                int sum1=0, sum2=0;
                for(int i=1; i<=N; i++){
                    if(section[i]) sum1+=person[i];
                    else sum2+=person[i];
                }

                ans = Math.min(ans, Math.abs(sum1-sum2));
            }

            return;
        }

        cnt++;
        section[cnt] = true;
        comb(cnt);

        section[cnt] = false;
        comb(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        person = new int[N+1];
        section = new boolean[N+1];
        checked = new boolean[N+1];
        
        nodes = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
            nodes[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            person[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            if(m==0) cnt++;

            for(int j=0; j<m; j++)
                nodes[i].add(Integer.parseInt(st.nextToken()));
        }


        comb(0);

        if(ans==Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(ans);
    }
}
