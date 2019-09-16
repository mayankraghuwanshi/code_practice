#include<iostream>
#include<math.h>
using namespace std;


int getDigitLength1(int n){
    if(n==0){
        return 1;
    }
    return floor(log10(n)+1);
}

int getDigitLength2(int n){
    if(n==0){
        return 1;
    }
    int counter=0;
    while(n>0){
        counter++;
        n/=10; //n=n/10
    }
    return counter;
}
int main(){
    int counter=0;
    int n=0;
    cout<<"Enter No."<<endl;
    cin>>n;
    cout<<getDigitLength1(n)<<endl;
    cout<<getDigitLength2(n);
    return 0;
}