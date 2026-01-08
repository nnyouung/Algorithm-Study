import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class BOJ_20154 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = bf.readLine().toCharArray(); // 문자열
        int[] charToNum = new int[chars.length];  // 획수
        int result = 0;

        // 문자 -> 획수
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'C':
                case 'I':
                case 'J':
                case 'L':
                case 'O':
                case 'S':
                case 'U':
                case 'V':
                case 'Z':
                    charToNum[i] = 1;
                    break;

                case 'B':
                case 'D':
                case 'P':
                case 'Q':
                case 'R':
                case 'T':
                case 'W':
                case 'X':
                case 'Y':
                    charToNum[i] = 2;
                    break;

                case 'A':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'K':
                case 'M':
                case 'N':
                    charToNum[i] = 3;
                    break;
            }
        }

        for (int i = 0; i < charToNum.length; i++) {
            result += charToNum[i];
        }

        if(result>10){
            result = result%10;
        }

        if(result % 2 == 1){
            System.out.println("I'm a winner!");
        }
        else{
            System.out.println("You're the winner?");
        }

    }

}
