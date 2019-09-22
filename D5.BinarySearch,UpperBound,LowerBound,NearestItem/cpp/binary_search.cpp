#include<iostream>
#include<vector>
using namespace std;

int binary_search(vector<int> arr ,int item){
    int start=0;
    int end=arr.size()-1;
    int mid;

    //we are trying to match item with arr[mid] if we match item with arr[mid], index=mid.
    //if item is greater then arr[mid] then it can be found in next half array, (start=mid+1,end)
    //if item is less then mid then item can be found in previous half of array, (start,end=mid-1).

    int index=-1;
    while(start<=end){
        mid=(start+end)/2;
        if(arr[mid]==item){
            return mid;
        }else if(item>arr[mid]){
            start=mid+1;
        }else{
            end=mid-1;
        }
    }
    return index;
}

int search_lower_bound(vector<int> arr,int item){
    int start=0;
    int end=arr.size()-1;
    int mid;
    int lower_index=-1;
    while(start<=end){
        mid=(start+end)/2;
        if(arr[mid]==item){
            lower_index=mid;
            if(mid-1>=0 && arr[mid-1]==item) end=mid-1;    
            else break;
            
        }else if(arr[mid]>item){
            end=mid-1;
        }else{
            start=mid+1;
        }
    }
    return lower_index;
}

int search_upper_bound(vector<int> arr,int item){
    int start=0;
    int end=arr.size()-1;
    int mid;
    int upper_index=-1;
    while(start<=end){
        mid=(start+end)/2;
        if(arr[mid]==item){
            upper_index=mid;
            /*
            start=mid+1;
            this also generate same result there will be no array_index_out_of_bound because when start becomes
            array.size() means one element ahead of arrays limit then loop will break. but this results in more time
            complexity even if there is no repeated elements present in array we still continue search.
            */
            if(mid+1<=arr.size()-1 && arr[mid+1]==item) start=mid+1;    
            else break;
        }else if(arr[mid]>item){
            end=mid-1;
        }else{
            start=mid+1;
        }
    }
    return upper_index;
}


int nearest_num(vector<int> arr,int item){
    int start = 0;
    int end = arr.size()-1;
    int mid = 0;

    //boundary case 1.
    //if all elements in array are greater then item then return fisrt element.
    if(item<=arr[start]) return arr[start];
    //boundrary csse 2.
    //if all elements in array are less then item then return the last element.
    else if(item>=arr[end]) return arr[end];

    while(start<=end){
        mid=(start+end)/2;
        if(arr[mid]==item){
            return arr[item];
        }else if(arr[mid]>item){
            end=mid-1;
        }else{
            start=mid+1;
        }
    }
    //if didn't handle boundary cases earlier then can handle here-
    if(end==-1){
        return arr[0];
    }
    if(start==arr.size()){
        return arr[arr.size()-1];
    }

    //now we have boundary start and end and item will lie in this boundary.
    //check from wich boundary it is close and return.
    return (item-arr[end]<=arr[start]-item)?arr[end]:arr[start];
}








int main(){
    vector<int> arr = {2,2,4,5,8,8,8,8,12,17,18,18};
    cout<<endl;
    cout<<search_lower_bound(arr,20);
}