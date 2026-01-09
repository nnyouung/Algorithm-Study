import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            String str = bf.readLine();

            Stack<Character> stack = new Stack<>();
            char[] strToChar = str.toCharArray();

            boolean answer = true;

            for (int j = 0; j < strToChar.length; j++) {
                if(strToChar[j]=='('){
                    stack.push(strToChar[j]);
                }
                else{ // ')'
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    else{
                        answer = false;
                        break;
                    }
                }

            }
            if(!stack.isEmpty()){
                answer = false;
            }

            if(answer){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}
