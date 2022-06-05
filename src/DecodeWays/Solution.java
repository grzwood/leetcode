package DecodeWays;

public class Solution {

  public static void main(String[] args) {
    String input = "12";
    System.out.println(numDecodings(input));
  }

  public static int numDecodings(String s) {

    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    char[] sc = s.toCharArray();
    for (int i = 0; i < n; i++) {
      if (sc[i] != '0') { // i 单独是一个字母
        dp[i + 1] = dp[i];
      }
      if (i > 0) {// i 和 i-1 共同组成一个数字
        int num = (sc[i - 1] - '0') * 10 + (sc[i] - '0');
        if (num >= 10 && num <= 26) {
          dp[i + 1] += dp[i - 1];
        }

      }
    }
    return dp[n];
  }
}
