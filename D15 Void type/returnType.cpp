#include<iostream>
#include<string>

using namespace std;
void removeHi(string s , string res){
    if(s.length()==0){
        cout<<res<<endl;
        return ;
    }
    if(s.length()>1 && s[0]=='h' && s[1]=='i') {removeHi(s.substr(2),res);}
    else removeHi(s.substr(1),res+s[0]);
}


void removeDublicate(string s , string res){
    if(s.length()==0){
        cout<<res;
        return ;
    }
    char ch1 = s[0];
    char ch2 = res[res.length()-1];
    cout<<(ch1==ch2)<<endl;
    if(ch1!=ch2){
        removeDublicate(s.substr(1), res+ch1);
    }else{
        removeDublicate(s.substr(1),res);
    }
}

// void stringCompression
//subsequence
//maze path



int main(){
    
    
}