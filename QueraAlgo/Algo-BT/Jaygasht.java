import java.util.ArrayList;
import java.util.Scanner;

public class Jaygasht {

    static int n;
    static int k;
    static ArrayList<Integer> currentPer = new ArrayList<>();
    static int ans = 0;

    static int inversion() {
        int res = 0;
        for (int i = 0; i < currentPer.size() - 1; i++) {
            for (int j = i + 1; j < currentPer.size() ; j++) {
                if (currentPer.get(i) > currentPer.get(j))
                    res += 1;
            }
        }

        return res;
    }

    static void myprint() {
        for (int i = 0; i < n; i++) {
            System.out.print(currentPer.get(i) + " ");

        }
        System.out.println();
    }

    static void bt() {
        if (currentPer.size() == n) {
            if (inversion() == k) {
                ans += 1;
                //myprint();
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (!currentPer.contains(i)) {
                    currentPer.add(i);
                    bt();
                    currentPer.remove(currentPer.size() - 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();

        bt();
        System.out.println(ans);

    }

}
