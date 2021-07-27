import java.util.Scanner;

public class LCS {

    static int[][] dp;
    static char[][] track;
    static String str1, str2;

    static void setDp() {

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    track[i][j] = 'o';
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (dp[i - 1][j] > dp[i][j - 1])
                        track[i][j] = 'l';
                    else
                        track[i][j] = 'u';
                }
            }
        }

    }

    static void myPrint() {
        int i = str1.length();
        int j = str2.length();
        String s = "";
        while (i > 0 && j > 0) {

            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                s += str1.charAt(i - 1);

                i--;
                j--;

            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }

        for (int k = s.length() - 1; k >= 0; k--) {
            System.out.print(s.charAt(k));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        str1 = scanner.next();
        str2 = scanner.next();

        dp = new int[str1.length() + 1][str2.length() + 1];
        track = new char[str1.length() + 1][str2.length() + 1];

        setDp();

        System.out.println(dp[str1.length()][str2.length()]);
        myPrint();
    }
}
