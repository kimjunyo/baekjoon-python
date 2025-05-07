import java.util.*;
import java.io.*;

public class Main {
  static int[][] dp;
  static int[] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    arr = new int[N+1];
    dp = new int[N+1][N+1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1; i<N+1; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for(int i=1; i<=N; i++) {
      Arrays.fill(dp[i], -1);
      dp[i][i] = 1;
    }

    StringBuilder sb = new StringBuilder();
    int M = Integer.parseInt(br.readLine());
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      
      isDp(start, end);
      sb.append(dp[start][end]).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  private static boolean isDp(int start, int end) {
    if(dp[start][end] == -1) {
      if(arr[start] != arr[end]) {
        dp[start][end] = 0;
        return false;
      } else {
        if(start >= end) {
          dp[start][end] = 1;
          return true;
        }
        if(isDp(start+1, end-1)) {
          dp[start][end] = 1;
          return true;
        } else {
          dp[start][end] = 0;
          return false;
        }
      }
    } else if (dp[start][end] == 0) {
      return false;
    } else {
      return true;
    }
  
  }
}