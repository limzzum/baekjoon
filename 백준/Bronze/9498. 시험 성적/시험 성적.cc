#include<stdio.h>
int main() {
    int score;
    scanf("%d", &score);
    if (90<=score&&score<=100) {
        printf("A");
    }
    if(80<=score&&score<=89) {
        printf("B");
    }
    if (70 <= score &&score<=79) {
        printf("C");
    }
    if (60 <= score&&score <=69) {
        printf("D");
    }
    if(score<60) { printf("F"); }
}