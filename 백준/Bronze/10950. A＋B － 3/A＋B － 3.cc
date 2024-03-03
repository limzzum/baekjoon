#include<stdio.h>
int main() {
    int C;
    int i;
    int a[100], b[100];
    scanf("%d", &C);
    for (i = 0; i < C;i++) {
        scanf("%d %d", &a[i], &b[i]); }
    for (i = 0; i < C; i++) {
        printf("%d\n", a[i] + b[i]);   }
    return 0;
}