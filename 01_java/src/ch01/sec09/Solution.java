package ch01.sec09;

public class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = k;

        for (int i = k; i < enemy.length; i++) {
            if (n <= 0) {
                answer++;
                break;
            }
                n -= enemy[i];
                answer++;
        }
    }
}
