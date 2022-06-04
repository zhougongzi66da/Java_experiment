package Experiment_7;

public class test {
    public static void main(String[] args) {
        String s = "adcbeb";
        String p = "a*b?b";
        boolean res = isMatch(s, p);
        System.out.println("字符串s：" + s);
        System.out.println("字符串p：" + p);
        if(res)
            System.out.println("匹配成功");
        else System.out.println("匹配失败");
    }

    public static boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        boolean[][] dp = new boolean[lens + 1][lenp + 1];

        //处理dp数组的边界情况
        for (int i = 1; i <= lenp; i++) {
            if (p.charAt(i - 1) == '*')
                dp[0][i] = true;
            else break;
        }

        //起点位置初始化为true
        dp[0][0] = true;

        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lenp; j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }

        return dp[lens][lenp];
    }

}
