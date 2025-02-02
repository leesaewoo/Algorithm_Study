package 기초1.Day17.정해영;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열4 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];
        // 값의 범위의 최솟값이 1이기 때문에
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        // dp배열 초기화
        for(int i = 1; i <= n; i++){
            int num = Integer.parseInt(st.nextToken());
            // 입력된 배열 값 저장
            arr[i] = num;
            // 입력된 배열 값과 이전의 값들을 비교한다.
            for(int j = 0 ; j < i; j++){
                // 비교한 값보다 큰경우
                if(arr[i] > arr[j]){
                    // 비교한 값의 dp값 + 1, 기존의 dp값 중 큰 값을 저장한다.
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    // 최장 길이인 답을 구하기 위해서 result값에
                    // 지금까지 구한 dp값 중 가장 큰 값을 저장한다.
                    result = Math.max(dp[i], result);
                }
            }
        }
        // 최장길이 추가
        sb.append(result + "\n");

        // 최장 길이 값
        int value = result;
        // 경로를 역추적 할 stack
        Stack<Integer> stack = new Stack<>();

        // value는 현재 찾는 길이에 해당하는 값이다.
        for(int i = n; i >= 1; i--){
            // 현재 찾는 길이와 같은 경우
            if(value == dp[i]) {
                // stack에 실제 값을 push한다.
                stack.push(arr[i]);
                // 찾는 길이를 찾았으므로 -1을 해주어
                // 다음에 찾을 길이를 설정해준다.
                value--;
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }

        // 출력 버퍼에 write 작업을 한다.
        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
