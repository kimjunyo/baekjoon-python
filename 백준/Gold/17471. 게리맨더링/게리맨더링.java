import java.util.*;

public class Main {
    static int N;
    static int[] people;
    static List<Integer>[] graph;
    static boolean[] selected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        people = new int[N + 1];
        graph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            people[i] = sc.nextInt();
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                int neighbor = sc.nextInt();
                graph[i].add(neighbor);
            }
        }

        selected = new boolean[N + 1];
        dfs(1);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void dfs(int idx) {
        if (idx > N) {
            List<Integer> areaA = new ArrayList<>();
            List<Integer> areaB = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                if (selected[i]) areaA.add(i);
                else areaB.add(i);
            }

            if (areaA.isEmpty() || areaB.isEmpty()) return;

            if (isConnected(areaA) && isConnected(areaB)) {
                int sumA = 0, sumB = 0;
                for (int a : areaA) sumA += people[a];
                for (int b : areaB) sumB += people[b];
                min = Math.min(min, Math.abs(sumA - sumB));
            }

            return;
        }

        selected[idx] = true;
        dfs(idx + 1);
        selected[idx] = false;
        dfs(idx + 1);
    }

    static boolean isConnected(List<Integer> area) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(area.get(0));
        visited[area.get(0)] = true;

        int count = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visited[next] && area.contains(next)) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }

        return count == area.size();
    }
}
