import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int arr0 = arr[0];
            int arr1 = arr[1];
            int arr2 = arr[2];

            arr[0] = Math.min(arr1 + a, arr2 + a);
            arr[1] = Math.min(arr0 + b, arr2 + b);
            arr[2] = Math.min(arr0 + c, arr1 + c);
        }
        System.out.println(Math.min(arr[2], Math.min(arr[0], arr[1])));
    }
}