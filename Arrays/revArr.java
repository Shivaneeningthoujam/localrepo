package localrepo.Arrays;

public class revArr {
    //There are many ways of reversing an array
    //1.By creating an additional array
    public static void rev1(int[] a){
        int[] rev=new int[a.length];
        for(int i=0;i<a.length;i++){
            rev[i]=a[a.length-i-1];
        }
        //Printing the array
        System.out.print("Reversed array is :");
        //Note this use of for each loop.It is much easier
        for(int i : rev){
            System.out.println(i+" ");
        }
    }
    //2.Array reverse using a Loop .Used 2 pointers
    public static void rev2(int[] a,int start,int end){
        int temp;
        while(start<end){
            temp=a[start];
            a[start]=a[end];
            a[end]=temp++;
            start++;
            end--;
        }
    }
    //Utility function that prints an array
    static void print(int[] a,int n){
        for(int i=0;i<n;i++)
         System.out.print(a[i]+" ");
         System.out.println();
    }
    
    //3.Reversing using Recursion
    static void rev3(int a[],int start ,int end){
        int temp;
        if(start>=end)
        return;
        temp=a[start];
        a[start]=a[end];
        a[end]=temp;
        rev3(a, start+1, end-1);
    }
}
