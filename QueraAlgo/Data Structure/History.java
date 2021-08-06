import java.util.Scanner;
import java.util.Stack;

public class History {

    static class Operation {
        String name;
        int index;
        char value;


        public Operation(String name, int index, char value) {
            this.name = name;
            this.index = index;
            this.value = value;
        }
    }

    static Stack<Operation> stack = new Stack<>();
    static StringBuilder history = new StringBuilder("");


    static void delete(int i) {
        i--;
        stack.push(new Operation("delete", i, history.charAt(i)));
        history = history.deleteCharAt(i);

    }

    static void insert(int i, char c) {
        i--;
        stack.push(new Operation("insert", i,c));
        history = history.insert(i, c);
    }

    static void undo() {
        Operation operation = stack.pop();
        if (operation.name.equals("delete")) {
            history = history.insert(operation.index, operation.value);
        } else {
            history = history.deleteCharAt(operation.index);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        String[] info = new String[3];
        for (int i = 0; i < q; i++) {
            info[0] = scanner.next();

            if (info[0].equals("delete")) {
                info[1] = scanner.next();
                delete(Integer.parseInt(info[1]));
            } else if (info[0].equals("insert")) {
                info[1] = scanner.next();
                info[2] = scanner.next();
                insert(Integer.parseInt(info[1]), info[2].charAt(0));
            } else
                undo();
        }

        System.out.println(history.toString());


    }

}

