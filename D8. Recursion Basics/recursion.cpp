#include<iostream>
using namespace std;

//1,7
//1 2 3 4 5 6 7
void printInc(int start,int end){
    if(start>end) return;
    cout<<start<<" ";
    printInc(start+1,end);
}
//1,7
//7 6 5 4 3 2 1
void printDec(int start,int end){
    if(start>end) return;
    printInc(start+1,end);
    cout<<start<<" ";
}
//1,5
//5 4 3 2 1
int printDecr(int start , int end){
   if(start==end){
       cout<<start<<" ";
       return start-1;
   }
   int temp=printDecr(start+1,end);
   cout<<temp<<" ";
   return temp-1;
}

int fact(int n){
    if(n<1) return 1;
    return n*fact(n-1);
}



int main(){
    printDecr(1,10);
    return 0;
}