import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    int M = Integer.parseInt(br.readLine());
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken())-1;
      int end = Integer.parseInt(st.nextToken())-1;
      boolean isPalindrome = true;
      
      while(start < end) {
        if(arr[start++] != arr[end--]) {
          isPalindrome = false;
          break;
        }
      }
      sb.append(isPalindrome ? 1 : 0).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }
}