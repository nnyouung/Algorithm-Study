import java.io.*;

public class Main {
    static class Node {
        int idx, move;
        Node next, prev;

        Node(int idx, int move) {
            this.idx = idx;
            this.move = move;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] s = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();

        Node head = new Node(1, Integer.parseInt(s[0]));
        Node tail = head;

        // 양방향 원형 연결 리스트 구현
        for (int i = 2; i <= N; i++) {
            Node node = new Node(i, Integer.parseInt(s[i-1]));
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        tail.next = head;
        head.prev = tail;

        Node curr = head;

        // 양수 음수 판단 및 출력
        for (int i = 0; i < N; i++) {
            sb.append(curr.idx);
            if (i < N - 1) sb.append(' ');
            int move = curr.move;

            if (i == N - 1) break;

            Node nextCurr = (move > 0) ? curr.next : curr.prev; // 삭제 후 시작 위치 미리 잡기

            // curr 삭제
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            curr = nextCurr;

            if (move > 0) { // 양수: 이미 next로 한 칸 간 상태이므로 move-1번 추가 이동
                for (int j = 1; j < move; j++) curr = curr.next;
            } else {        // 음수: prev로 시작했으므로 |move|-1번이 아니라 |move|만큼
                for (int j = 1; j < -move; j++) curr = curr.prev;
            }
        }
        System.out.println(sb);
    }
}
