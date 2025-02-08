import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int apple = sc.nextInt();
        int[][] ground = new int[6][2];

        int maxHeight = 0;
        int maxWidth = 0;

        int maxFirst = -1;
        int maxSecond = -1;

        int[] num = new int[4];
        for (int i = 0; i < 6; i++) {
            ground[i][0] = sc.nextInt();
            ground[i][1] = sc.nextInt();
            num[ground[i][0] - 1]++;
        }

        for (int i = 0; i < 4; i++) {
            if (num[i] == 1 && maxFirst == -1) {
                maxFirst = i;
            } else if (num[i] == 1) {
                maxSecond = i;
                break;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (ground[i][0] == maxFirst + 1) {
                maxHeight = ground[i][1];
            } else if (ground[i][0] == maxSecond + 1) {
                maxWidth = ground[i][1];
            }
        }

        int[] combi = {maxFirst, maxSecond};

        if (!(combi[0] == 3 && combi[1] == 1) && !(combi[0] == 2 && combi[1] == 0) && !(combi[0] == 1 && combi[1] == 2) && !(combi[0] == 0 && combi[1] == 3)) {
            combi = new int[]{maxSecond, maxFirst};
        }

        int shortFirst = 0;
        int shortSecond = 0;

        for (int i = 0; i < 6; i++) {
            if (ground[i][0] == combi[1] + 1 && i + 2 < 6) {
                shortFirst = ground[i + 2][1];
                if (i + 3 < 6) {
                    shortSecond = ground[i + 3][1];
                } else {
                    shortSecond = ground[0][1];
                }
                break;
            } else if (ground[i][0] == combi[1] + 1 && i + 2 >= 6) {
                shortFirst = ground[i - 4][1];
                shortSecond = ground[i - 3][1];
                break;
            }

        }

        System.out.println((maxHeight * maxWidth - shortFirst * shortSecond) * apple);
    }
}