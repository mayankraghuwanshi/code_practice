#include<iostream>
#include<vector>
using namespace std;
void set_input(vector<vector<int>> & arr){
    for(int row=0;row<arr.size();row++){
        for(int col=0;col<arr[0].size();col++){
            cin>>arr[row][col];
        }
    }
}
void print_arr(vector<vector<int>> &arr){
    for(int row=0;row<arr.size();row++){
        for(int col=0;col<arr[0].size();col++){
            cout<<arr[row][col]<<" ";
        }
        cout<<endl;
    }
}

void add_matrix(vector<vector<int>> & arr1,vector<vector<int>> & arr2){
    if(arr1.size()!=arr2.size() || arr1[0].size()!=arr2[0].size()) {
        cout<<"Can't add!"<<endl;
    }
    for(int row=0;row<arr1.size();row++){
        for(int col=0;col<arr1[0].size();col++){
            arr1[row][col]+=arr2[row][col];
        }
    }

}
void multiply_matrix(vector<vector<int>> & arr1, vector<vector<int>> &arr2);

void zigzag1(vector<vector<int>> & arr){
    bool left_to_right=true;
    for(int row=0;row<arr.size();row++){
        //for(int col=0;col<arr[0].size();col++){
        for(int col=(left_to_right)?0:arr.size()-1;(left_to_right)?col<arr[0].size():col>=0;(left_to_right)?col++:col--){
            cout<<arr[row][col]<<"->";
            //cout<<left_to_right?arr[row][col]:arr[row][arr[0].size()-1-col]<<"->";
        }
        left_to_right=!left_to_right;
    }
    cout<<endl;
}

void zigzag2(vector<vector<int>> &arr){
    bool top_to_down=true;
    for(int col=0;col<arr[0].size();col++){
        for(int row=(top_to_down)?0:arr.size()-1;(top_to_down)?row<arr.size():row>=0;(top_to_down)?row++:row--){
            cout<<arr[row][col]<<"->";
        }
        top_to_down=!top_to_down;
    }
    cout<<endl;
}

void exit_path(vector<vector<int?>> &arr){
    int r=0;
    int c=0;
    int dir = 0;
    while(true){
        dir=(dir+arr[r][c])%4;
        if(dir==0){
            c++;
            if(c==arr[0].size()){
                cout<<r<<"\t"<<--c;
                break;
            }
        }
        else if(dir==1){
            r++;
            if(r==arr.size()){
                cout<<--r<<"\t"<<c;
                break;
            }
        }
        else if(dir==2){
            c--;
            if(c==-1){
                cout<<r<<"\t"<<++c;
                break;
            }
        }
        else if(dir==3){
            r--;
            if(r==-1){
                cout<<++r<<"\t"<<c;
                break;
            }
        }
    }
}



void spiral_print(vector<vector<int>> &arr){
    int top=0;
    int bottom=arr.size()-1;
    int left=0;
    int right=arr[0].size()-1;
    char dir='E';
    while(top<=bottom){
        if(dir=='E'){
            for(int col=left;col<=right;col++){
                cout<<arr[top][col]<<"->";
            }
            top++;
            dir='S';
        }
        else if(dir=='S'){
            for(int row=top;row<=bottom;row++){
                cout<<arr[row][right]<<"->";
            }
            right--;
            dir='W';
        }
        else if(dir=='W'){
            for(int col=right;col>=left;col--){
                cout<<arr[bottom][col]<<"->";
            }
            bottom--;
            dir='N';
        }
        else if(dir=='N'){
            for(int row=bottom;row>=top;row--){
                cout<<arr[row][left]<<"->";
            }
            left++;
            dir='E';
        }
    }
}


int main(int args , char ** argv){
    vector<vector<int>> arr1 = {{1,2,3,4,5}};
    vector<vector<int>> arr2 = {{1,2,3},{4,5,6},{7,8,9}};
    spiral_print(arr1);
    return 0;
}