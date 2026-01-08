import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String alp = br.readLine();
        // 알파벳 대문자, 각 문자의 획수로 문자 변환
        int[] alphabet = {
            3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1
        }; // int alphabet[26] 불가능

        int[] current = new int[alp.length()]; // 사용할 숫자배열

        for (int i = 0; i < alp.length(); i++) {
            char c = alp.charAt(i); // 문자 가져오기
            current[i] = alphabet[c - 'A']; // 획수 지정
        }

        // int ans = 0; -> current값으로 갱신해야 한다
        while(current.length > 1) {
            int[] next = new int[(current.length+1) /2]; // +1은 홀수
            int index=0;

            // for(int i=0; i<alp.length(); i++) {
            for(int i=0; i+1 < current.length; i+=2) { // (i,i+1)쌍
                next[index++] = (current[i] + current[i+1]) % 10;
            }
            if(current.length %2 ==1) // 홀수 처리(while문 밖에서)
                next[index] = current[current.length-1];
            current = next; // 다음단계로
        }

        int ans = current[0]; // 값 갱신 필요
        
        // if 홀수면 win, 짝수면 lose
        // System.out.println(ans); // 디버깅
        if(ans %2==0) 
            bw.write("You're the winner?");
        else 
            bw.write("I'm a winner!");
        bw.flush(); // 버퍼 해제
    }
}