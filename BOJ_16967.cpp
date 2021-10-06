// 16967
#include <cstdio>
using namespace std;

int mapA[500][500];
int mapB[1000][1000];

int main(){
    int H,W,X,Y;
    scanf("%d %d %d %d", &H,&W,&X,&Y);
    
    for(int i=0; i<H+W; i++){
        for(int j=0; j<W+Y; j++){
            scanf("%d", &mapB[i][j]);
        }
    }
    
    for(int i=0; i<H; i++){
        for(int j=0; j<W; j++){
            if(i>=X && j>=Y)
                mapA[i][j] = mapB[i][j]-mapA[i-X][j-Y];
            else mapA[i][j] = mapB[i][j];
        }
    }
    
//    for(int i=X; i<=H; i++){
//        for(int j=Y; j<=W; j++){
//            mapA[i][j] -= mapA[i-X][j-Y];
//        }
//    }
    
    for(int i=0; i<H; i++){
        for(int j=0; j<W; j++)
            printf("%d ", mapA[i][j]);
        printf("\n");
    }
    
    return 0;
}
