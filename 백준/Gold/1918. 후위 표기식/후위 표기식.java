import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Map<Character, Integer> map = new HashMap<>();
    static Stack<Character> op = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        char[] str = sc.nextLine().toCharArray();

        for (char c : str) {
            if (c == ')') {
                while (op.peek() != '(') {
                    sb.append(op.pop());
                }
                op.pop();
                continue;
            }

            if (c == '(') {
                op.push(c);
                continue;
            }

            if (map.containsKey(c)) {
                while (!op.isEmpty() && map.get(c) <= map.get(op.peek())) {
                    sb.append(op.pop());
                }
                op.push(c);
            } else {
                sb.append(c);
            }
        }

        while (!op.isEmpty()) {
            sb.append(op.pop());
        }

        System.out.println(sb);
    }
}