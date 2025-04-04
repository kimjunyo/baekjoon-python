import java.util.*;
import java.io.*;

public class Solution {
    static int N, B, min;
    static int[] member;
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            member = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
            	member[i]=Integer.parseInt(st.nextToken());
            }
            
            min = Integer.MAX_VALUE;
            comb(0, 0); // idx, sum
            
            sb.append("#").append(tc).append(" ").append(min-B).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
     
    }
    
    private static void comb(int idx, int sum) {
        if(sum >= B) {
            min = Integer.min(sum, min);
        	return;
        }
        
    	if(idx == N) {
        	return;
        }
        
        comb(idx+1, sum);
        comb(idx+1, sum+member[idx]);
    }
}