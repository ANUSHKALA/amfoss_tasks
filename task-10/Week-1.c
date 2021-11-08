#include <stdio.h>

int main(void)
{
    int n;
    printf("Enter an integer: ");
    scanf("%d", &n);
    //printf("Number = %d",n);



    int nr,r,c,nc;
    nr = n;
    nc = nr-1;

    for(r = 1 ; r<=nr ; r++){

        for(c = 1 ; c<=nc ; c++){
            printf(" ");

        }
        nc --;
        for(int c2 = 1 ; c2<=r ; c2++){

            printf("*");

        }
        printf("\n");

    }


}
