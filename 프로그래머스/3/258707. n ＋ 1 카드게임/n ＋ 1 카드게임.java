class Solution {
    
    static int[] haveCard;
    static int keyCnt;
    static int N;
    static int answer;
    static int coin;
    static int[] cards;
    
    public int solution(int coi, int[] card) {
        N = card.length;
        haveCard = new int[N+1];
        coin = coi;
        cards = card;
        for(int i=0; i<N/3; i++){
            haveCard[cards[i]] = 2;
            if(haveCard[N + 1 - cards[i]] == 2){
                keyCnt += 1;
                haveCard[cards[i]] = 0;
                haveCard[N + 1 - cards[i]] = 0;
            }
        }
        
        for(int i=1; i<=(N-(N/3))/2; i++){
            if(coin == 0){
                answer = Math.min((N-(N/3))/2 + 1, i + keyCnt);
                break;
            }
            int idx = (N/3) + i*2 - 2;

            haveCard[cards[idx]] = 1;
            haveCard[cards[idx+1]] = 1;
            if(haveCard[N+1 - cards[idx]] == 2 && coin != 0){
                coin -= 1;
                haveCard[N+1 - cards[idx]] = 0;
                haveCard[cards[idx]] = 0;
                keyCnt += 1;
            }
            if(haveCard[N+1 - cards[idx+1]] == 2 && coin != 0){
                coin -= 1;
                haveCard[N+1 - cards[idx+1]] = 0;
                haveCard[cards[idx+1]] = 0;
                keyCnt += 1;
            }
            
            if(keyCnt == 0 && !makeKey(i)){
                answer = i;
                break;
            }
            keyCnt -= 1;
            answer = i+1;
        }
        return answer;
    }
    
    private static boolean makeKey(int round){
        for(int i=N/3; i<= (N/3-1) + round*2; i++){
            if(coin < 2){
                return false;
            }

            if(haveCard[cards[i]] == 1 && haveCard[N+1 - cards[i]] == 1){
                coin -= 2;
                haveCard[cards[i]] = 0;
                haveCard[N+1 - cards[i]] = 0;
                keyCnt += 1;
                return true;
            }
        }
        return false;
    }
}