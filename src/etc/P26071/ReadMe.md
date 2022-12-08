## P26071 오락실에 간 총총이

### 문제
곰곰 피규어를 생각하며 신나있는 총총이

우연히 들리게 된 오락실에서, 총총이는 귀여운 곰곰이가 잔뜩 등장하는 게임을 발견했다.

게임의 화면은 $N \times N$ 크기의 칸으로 나누어져 있고, 각 칸에는 곰곰이가 있거나 또는 비어있다.  
화면에는 최소 한 마리의 곰곰이가 존재한다.

게임은 상하좌우 네 개의 버튼을 눌러서 진행할 수 있다.  
각 버튼을 누르게 되면, 화면에 있는 모든 곰곰이들이 그 버튼에 해당하는 방향으로 한 칸 움직이게 된다.  
만약 이미 화면의 끝에 있어서 그 방향으로 이동하지 못하는 곰곰이들은 가만히 있는다.   
버튼을 잘 눌러서 모든 곰곰이들을 하나의 칸에 모으게 되면, 화면에 GOMGOM 이라는 글자가 뜨면서 승리하게 된다.

현재 오락실에서는 이 게임을 가장 적은 횟수의 버튼을 눌러서 승리한 플레이어에게 곰곰 피규어를 주는 이벤트를 진행하고 있다.   
귀여운 곰곰 피규어를 노리는 총총이를 위해, 최소 몇 번의 버튼을 눌러야 게임을 클리어할 수 있는지를 구해보자.

### 입력
첫째 줄에 정수 N이 주어진다. $(1 <= N <= 1,500)

둘째 줄부터 $N$개의 줄에 걸쳐 게임 화면의 상태가 주어진다.  
각 줄에는 N개의 문자가 공백없이 주어지고, 모든 문자는 $G$ 또는 $.$ 중 하나이다.  
$G$ 는 그 칸에 곰곰이가 있다는 뜻이고, $.$ 는 그 칸이 비어있음을 의미한다.

최소 하나 이상의 $G$ 문자가 주어짐이 보장된다.

### 출력
모든 곰곰이를 하나의 칸에 모으기 위해, 총총이가 최소 몇 번 버튼을 눌러야 하는지 구하시오.

## 기능 정리
    1. 곰곰이들이 하나로 모이는 곳은 대각석의 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 4곳이다.
    2. N x N 크기의 입력값을 받으며 곰곰이가 있는 좌표일 경우 4곳에 대해 가기위해 가로로 이동해야
       할 거리와 세로로 이동해야할 거리를 구한다.
    3. 네 곳에대해 가장 오래걸리는 가로, 세로 길이 더한다.
    4. 네 곳 중 가장 적은 이동인 곳이 최소 이동 이다.

```
예외) 곰곰이가 하나일 땐 움직이지 않아도 된다. == 정답 0번
     모든 곰곰이가 같은 행에 있거나 같은 열에 있으면 해당 행이나 열의 끝에서 만난다.
```
  