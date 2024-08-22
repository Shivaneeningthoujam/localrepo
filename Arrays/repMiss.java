package localrepo.Arrays;
//we are finding mssing element and repeating element in an array using MATHEMATICAL APPROACH
public class repMiss {
    static long[] find(int arr[]){
       int n=arr.length;
       long Sn=(long)n*(n+1)/2;
       long S2n=(long)n*(n+1)*(n+2)/6;
       long S=0,S2=0;
       for(int i=0;i<n;i++){
        S+=arr[i];
        S2+=(long)arr[i]*arr[i];
       }
       long val1=S-Sn;
       long val2=S2-S2n;
       long x=(val1+val2)/2;
       long y=x-val1;
       return new long[]{x,y};
    }
}
