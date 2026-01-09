// 목요일
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        // 괄호 닫히는지 여부 () 쌍이 맞아야함
        String input;

        boolean isValid = true;
        for(int i=0; i<n; i++) {
            // 왼쪽괄호 개수 변수, 오른쪽괄호 개수 변수 선언
            isValid = true;
            int left_p=0;
            int right_p=0;
            input = br.readLine();

            for(int j=0; j<input.length(); j++){
                // 만약 오른쪽괄호가 왼쪽괄호보다 많아지는 상황이 오면 no 출력
                if(input.charAt(j)=='(') left_p++; // charAt으로 접근
                else right_p++;

                // 오른쪽이 더 크면 
                if(right_p > left_p) {
                    bw.write("NO\n");
                    isValid = false;
                    break;
                }
            }
            // 만약 왼쪽괄호가 더 많으면 no 출력
            // 위에서 no가 출력이 안됐을때
            if(isValid==true){
            if(left_p > right_p) bw.write("NO\n");
            else bw.write("YES\n");
            }
        }
        bw.flush();
    }
}