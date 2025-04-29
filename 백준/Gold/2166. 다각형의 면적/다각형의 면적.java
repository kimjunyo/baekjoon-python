import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] x = new int[N + 1];
		int[] y = new int[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		x[N] = x[0];
		y[N] = y[0];

		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (double) x[i] * y[i + 1] - (double) x[i + 1] * y[i];
		}

		bw.write(String.format("%.1f", 1.0 / 2 * Math.abs(sum)));
		bw.flush();
	}
}