#include<iostream>
#include<vector>
using namespace std;

void input(vector<int>& arr){
    for(int i=0;i<arr.size();i++) cin>>arr[i];
}
void display(vector<int>& arr){
    for(int i:arr) cout<<i<<" ";
}
int get_max(vector<int> arr){
    int max = arr[0];
    for(int i:arr){
        if(i>max){
            max=i;
        }
    }
    return max;
}
int get_min(vector<int> arr){
    int min=arr[0];
    for(int i:arr){
        if(i<min){
            min=i;
        }
    }
    return min;
}



int main(){
    vector<int> arr(5,-1);
    input(arr);
    cout<<get_min(arr);
    

}