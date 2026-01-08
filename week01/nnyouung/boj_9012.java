import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            boolean ok = true;
            Deque<Character> stack = new ArrayDeque<>();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    stack.push(s.charAt(j));
                } else {
                    if (stack.isEmpty()) {
                        ok = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (ok && stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}