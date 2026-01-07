import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alphabets = br.readLine();

        int[] stroke = { 3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};

        int alphaLength = alphabets.length();
        int[] alphaArr = new int[alphaLength];

        for (int i = 0; i < alphaLength; i++) {
            alphaArr[i] = stroke[alphabets.charAt(i) - 'A'];
        }

        int sum = 0;
        for (int j : alphaArr) {
            sum += j;
        }

        if (sum >= 10) {
            sum %= 10;
        }

        if (sum % 2 != 0) {
            System.out.print("I'm a winner!");
        } else {
            System.out.print("You're the winner?");
        }
//        System.out.print(Arrays.toString(alphaArr));
//        System.out.print(sum);
    }
}