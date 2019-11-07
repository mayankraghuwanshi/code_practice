#include<iostream>
#include<string>
using namespace std;


string toBinary(int n){
    string s;
    while(n>0){
        s=to_string(n%2)+s;
        n=n/2;
    }
    return s;

}

   
string add(string s1 , string s2, int k){
    string res;
    int i=s1.length()-1;
    int j=s2.length()-1;
    int c=0;
    while(i>=0 && j>=0){
        // cout<<res<<endl;
        int s =(i>=0)?((int) s1[i]-'0'):0;
        s+=(j>=0)?((int) s2[j]-'0'):0;
        s+=c;
        res=to_string((s%10)%k)+res;
        c=(s/10);
        i--;
        j--;
               
    }
    if(c==1){
        res="1"+res;
    }
    return res;
}



void permutation(string s,string ans){
    if(s.length()==0){
        cout<<ans<<endl;
        return ;
    }
    for(int i=0;i<s.length();i++){
        char ch = s[i];
        string s2 = s.substr(0,i)+s.substr(i+1,s.length());
        permutation(s2,ans+ch);
    }
}

int main(){
    vector<string> arr = {"2","2","2","3","3","3","4"}; 
    string res="0";
    for(int i=0;i<arr.size();i++){
        res=add(res,toBinary(arr[i]),3);
    }
    cout<<res;
}