#include<stdio.h>
int main() {
	int A[100], B[100];
	int a = 0, i;
	while (1) {
		scanf("%d %d", &A[a], &B[a]);
		if (A[a] == 0 && B[a] == 0) {
			break;
		}
		a += 1;
	}
	for (i = 0; i < a; i++) {
		printf("%d \n", A[i] + B[i]);
	}
}