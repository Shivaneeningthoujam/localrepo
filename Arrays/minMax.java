package localrepo.Arrays;

//here we are to find the max and min element of an array
class miniMax {
    public static int min(int[] a, int n) {
        int min = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static int max(int[] a, int n) {
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
//Reverse an array

 public static int[] rev(int[] a,int n){
     int[] r=new int[n];
     for(int i=n-1;i==0;i--){
       for(int j=0;j<n;j++){
        r[j]=a[i];
       }
     }
     return r;
 } 
    public static void main(String[] args) {
        int a[] = { 1, 2, 4, 5 };
        int c = min(a, 4);
        int b = max(a, 4);
        System.out.println(c + " " + b);
        
    }
}