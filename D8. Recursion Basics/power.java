class main{
    static int pow(int a,int b){
        if(b==0) return 1;
        return a*pow(a,--b);
    }
    static int fastPow(int a,int b){
        if(b==0) return 1;
        int temp = fastPow(a, b/2);
        return ((b&1)==0)?temp*temp:a*temp*temp;
    }
    
    public static void main(String args[]){
       System.out.println(fastPow(-10, 1));
    }
}