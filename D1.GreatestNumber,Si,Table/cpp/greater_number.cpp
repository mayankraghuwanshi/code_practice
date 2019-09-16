#include<iostream>
using namespace std;
int main(){
    int a=10;
    int b=10;
    int c=20;
    cout<<"Enter a ";
    cin>>a;
    cout<<endl;
    cout<<"Enter b ";
    cin>>b;
    cout<<endl;
    cout<<"Enter c ";
    cin>>c;
    cout<<endl;
    /*
    10,10,10
     */
    if(a>=b && a>c){
        cout<<a;
    }else if(b>a && b>=c){
        cout<<b;
    }else {
        cout<<c;
    }






    return 0;
}