import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Parenthese {

    static Stack stack = new Stack();
    static String string;
    static ArrayList<Pair> pairs = new ArrayList<>();


    static boolean check() {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.size() == 0)
                    return false;
                pairs.add(new Pair((int) stack.pop(), i));
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        string = scanner.next();

        if (check()) {
            pairs.sort((p1, p2) -> p1.s - p2.s);
            for (int i = 0; i < pairs.size(); i++) {
                System.out.println(pairs.get(i).toString());
            }
        } else
            System.out.println(-1);

    }


}

class Pair {
    int f;
    int s;

    public Pair(int f, int s) {
        this.f = f;
        this.s = s;
    }

    @Override
    public String toString() {
        return (1 + this.f) + " " + (1 + this.s);
    }
}
