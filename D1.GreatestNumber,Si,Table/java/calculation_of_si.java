import java.util.*;
class main{
    public static void main(String args[]){
        Scanner ob = new Scanner(System.in);
        int p,r,t;
        System.out.println("Enter P,R,T")
        p=ob.nextInt();
        r=ob.nextInt();
        t=ob.nextInt();
        int si=(p*r*t)/100;
        System.out.print(si);
    }
}
