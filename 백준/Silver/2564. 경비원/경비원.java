import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int width = scan.nextInt();
        int height = scan.nextInt();

        int market = scan.nextInt();
        int[] dir = new int[market];
        int[] dot = new int[market];
        for (int i = 0; i < market; i++) {
            dir[i] = scan.nextInt();
            dot[i] = scan.nextInt();
        }

        int 동근방향 = scan.nextInt();
        int 동근점 = scan.nextInt();

        int sum = 0;
        for (int i = 0; i < market; i++) {
            if (동근방향 == dir[i])
                sum += Math.abs(동근점 - dot[i]);
            else if (동근방향 + dir[i] == 3)
                sum += Math.min(dot[i] + 동근점 + height, 2 * width - dot[i] - 동근점 + height);
            else if (동근방향 + dir[i] == 7)
                sum += Math.min(dot[i] + 동근점 + width, 2 * height - dot[i] - 동근점 + width);
            else if ((동근방향 == 3 && dir[i] == 1) || (동근방향 == 1 && dir[i] == 3))
                sum += 동근점 + dot[i];
            else if (동근방향 == 4 && dir[i] == 1)
                sum += 동근점 + width - dot[i];
            else if (동근방향 == 1 && dir[i] == 4)
                sum += dot[i] + width - 동근점;
            else if (동근방향 == 3 && dir[i] == 2)
                sum += dot[i] + height - 동근점;
            else if (동근방향 == 2 && dir[i] == 3)
                sum += 동근점 + height - dot[i];
            else
                sum += width + height - dot[i] - 동근점;
        }
        System.out.println(sum);
    }
}