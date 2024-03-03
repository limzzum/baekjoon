#include<stdio.h>
int main() {
	int C, i;
	int a[100], b[100];
	scanf("%d", &C);
	for (i = 0; i < C; i++) {
		scanf("%d %d", &a[i], &b[i]);
	}
	for (i = 0; i < C; i++) {
		printf("Case #%d: %d + %d = %d\n", i + 1,a[i],b[i], a[i] + b[i]);
	}
		return 0;
	}