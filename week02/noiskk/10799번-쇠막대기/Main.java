/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10799                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10799                          #+#        #+#      #+#    */
/*   Solved: 2026/01/14 07:00:07 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 자료구조 Stack 사용
        Stack<Character> stack = new Stack<>();

        char recent = ' ';
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            // ( -> stack 에 추가
            // ) -> 이전 기호 확인하고 () 완성되면 그동안 쌓았던 ( 개수만큼 조각 추가

            char c = input.charAt(i);

            if(c == '('){
                stack.push('(');
            } else if (!stack.isEmpty() && recent == '('){
                // 현재 기호 ')' + 이전 기호 '('
                // pop 하고 남은 개수 sum 에 추가
                stack.pop();
                if(!stack.isEmpty()){
                    sum += stack.size();
                }
            } else if (!stack.isEmpty()){ // 현재 기호 ')' + 이전 기호 ')'
                stack.pop();
                sum += 1;
            }

            recent = c;
        }

        System.out.println(sum);
    }
}