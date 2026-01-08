import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int size = n*2+1;
        int[] deque = new int[size]; // 앞뒤 확장을 해야한다.
        int front=size/2;
        int back=size/2;

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");

            String command = split[0];

            switch(command) {
                case "push_front":
                    int value = Integer.parseInt(split[1]);
                    deque[--front] = value; // front++가 아님(왼쪽으로)
                    break;
                case "push_back":
                    value = Integer.parseInt(split[1]);
                    deque[back++] = value; // 전위 연산자가 아님(저장후)
                    break;
                case "pop_front":
                    if(front == back) bw.write(-1+"\n");
                    else bw.write(deque[front++]+"\n"); // --front가 아님(출력 후 증가)
                    break;
                case "pop_back":
                    if(front==back) bw.write(-1+"\n");
                    else bw.write(deque[--back]+"\n");
                    break;
                case "size":
                    bw.write(back-front+"\n");
                    break;
                case "empty":
                    if(front==back) bw.write(1+"\n");
                    else bw.write(0+"\n");
                    break;
                case "front":
                    if(front==back) bw.write(-1+"\n");
                    else bw.write(deque[front]+"\n");
                    break;
                case "back":
                    if(front==back) bw.write(-1+"\n");
                    else bw.write(deque[back-1]+"\n");
                    break;
            }
        }
        bw.flush();
    }
}