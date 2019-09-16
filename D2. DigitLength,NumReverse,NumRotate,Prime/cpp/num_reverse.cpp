#include<iostream>
using namespace std;
int main(){
    int n=12345;
    int n2=n;
    cout<<n2<<endl;
    int rev=0;
    int rem=0;
    while(n2>0){
        rem=n2%10;
        rev=rev*10+rem;
        n2/=10;
    }
    cout<<rev;
}