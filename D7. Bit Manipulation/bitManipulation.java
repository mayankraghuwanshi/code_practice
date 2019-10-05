class main{

    //set nth bit
    // 10011110101
    //   ^
    // 00100000000
    //   |
    // 10111110101

    static int setNthBit(int a,int k){
        return (a|(1<<k));
    }

    //off nth bit
    // 100111110101
    //     ^
    // 000010000000
    //~111101111111
    // &
    // 100011110101

    static int offNthBit(int a,int k){
        return (a&(~1<<k));
    }
    //no. of set bits
    static int countSetBits(int num){
        int count=0;
        while(num!=0 && count<32){
            num>>=1;
            count+=(num&1);
        }
        return count;
    }
    //not working for -1 !   :(
    static int countSetBit(int num){
        int count=0;
        for(int i=0;i<32;i++){
            if((num&(1<<i))>0){
                count++;
            }
        }
        return count;
    }
    
    static int addNum(int a,int b){
        if(b==0) return a;
        int carry = (a&b);
        carry<<=1;
        int res=(a^b);
        return addNum(res,carry);
        
    }
    

    public static void main(String args[]){
        int a=-21;
        int b=34;
        //System.out.println(Integer.toBinaryString(a));
        
        System.out.println(addNum(a, b));
    }
}