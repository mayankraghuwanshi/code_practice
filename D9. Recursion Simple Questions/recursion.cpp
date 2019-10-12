#include<iostream>
#include<vector>
using namespace std;

int findIndex(vector<int>&arr,int item,int i){
    if(i==arr.size()){
        return -1;
    }
    if(arr[i]==item) return i;
    return findIndex(arr,item,++i);
}

int lastIndex(vector<int>&arr,int i,int  item){
    if(i==arr.size()) return -1;
    if(arr[arr.size()-1-i]==item) return (arr.size()-i-1);
    return lastIndex(arr,++i,item);
}
int maximum(vector<int>&arr,int i){
    if(i==arr.size()){
        return arr[i-1];
    }
    int temp = maximum(arr,++i);
    
    return (temp>arr[i])?temp:arr[i];
}

int minimum(vector<int>&arr,int i){
    if(i==arr.size()){
        return arr[i-1];
    }
    int temp =minimum(arr,++i); 
    return (temp<arr[i])?temp:arr[i];
    }

void display(vector<int>&arr,int i){
    if(i==arr.size()){
        return ;
    }
    cout<<arr[i]<<" ";
    display(arr,++i);
}

vector<int> getAllIndex(vector<int>&arr,int i,int item,int size){
    if(i==arr.size()){
        return vector(size,-1);
    }
    if(arr[i]==item){
        size++;
    }
    
}


int main(){
    vector<int> arr = {3,2,1,2,4,2,-6};
    cout<<minimum(arr,0);
}