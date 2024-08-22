package localrepo.Arrays;
//we are given an array of blocks,a[]={3,1,2,4,0,1,3,2}

//we have to find number of water blocks that can be trapped in between the blocks
//ARRAY PREPROCESSING APPROACH

public class trappingWater {
    public static int trapped(int arr[], int n) {
        // 1.We find the highest block of buildings from left
        // 2.similarly ,from right
        // then use a formula to calculate the water block trapped
        int[] left = new int[n];
        int[] right = new int[n];
        int water = 0;
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }
        return water;
    }

    public static void main(String[] args) {
        int a[] = { 3, 1, 2, 4, 0, 1, 3, 2 };
        int n = 8;
        int water = trapped(a, n);
        System.out.println(water);
    }
}
