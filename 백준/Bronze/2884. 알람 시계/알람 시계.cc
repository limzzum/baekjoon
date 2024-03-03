#include<stdio.h>
int main() {
    int hour,minute;
    scanf("%d %d", &hour,&minute);
    if (minute >= 45) {
        printf("%d %d", hour, minute - 45);
    }
    else {
        hour -= 1;
        if (hour < 0) { hour = 23; }
        printf("%d %d", hour, minute + 15);
    }
    
    return 0;
}