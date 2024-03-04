#include<stdio.h>

    int main() {
        int a;
        int b;
        scanf("%d %d", &a, &b);
        int n = b;
        int n1 = n / 100;
        int n2 = (n % 100)/10;
        int n3 = (n % 100) % 10;
        printf("%d\n", a * n3);
        printf("%d\n", a * n2);
        printf("%d\n", a * n1);
        printf("%d\n", a * b);
        return 0;
}