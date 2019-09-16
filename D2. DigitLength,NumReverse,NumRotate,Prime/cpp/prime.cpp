#include<iostream>
#include<math.h>
using namespace std;

//time -o(n^1/2).
bool isPrime1(int n){
    if(n==1){
        return false;
    }
    int i=2;
    //note don't use sqrt function since sqtr will takee some time to calculate square root which increase time complexity of overall programme. 
    while(i*i<=n){
        if(n%i==0){
           return false;
        }
        i++;
    }
    return true;
}
int main(){
    int start=0,end=0;
    cout<<"Enter start and End"<<endl;
    cin>>start>>end;
    for(int i=start;i<=end;i++){
        if(isPrime1(i)){
            cout<<i<<" ";
        }
    }
    return 0;
}