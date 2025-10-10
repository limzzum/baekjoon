class Solution {
    static final int MOD = 10007;
    static int[] dpSpecial;
    static int[] dpCommon;

    public int solution(int n, int[] tops) {
        dpSpecial = new int[n];
        dpCommon = new int[n];
        
        dpSpecial[0] = 1;
        dpCommon[0] = 2;
        if(tops[0] == 1){
            dpCommon[0] += 1;
        }
        for(int i=1; i<n; i++){
            dpSpecial[i] = (dpCommon[i-1] + dpSpecial[i-1]) % MOD;
            int top = tops[i] == 1 ? 1 : 0;
            dpCommon[i] = (dpCommon[i-1] * (2+top) + dpSpecial[i-1] * (1+top)) % MOD;
        }
        return (dpSpecial[n-1] + dpCommon[n-1]) % MOD;
    }
}