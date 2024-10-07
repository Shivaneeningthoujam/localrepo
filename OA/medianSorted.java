package localrepo.OA;

public class medianSorted {
    // given two sorted array,join the two and give the median
    public static double medSort(int nums1[], int nums2[]) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return medSort(nums2, nums1);
        }
        // this is to ensure that we perform binary search on the smaller array so we
        // perform least comparison and ensure indices don't go out of bouund
        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;// is the no. of elements that should be on the left side of the partition
        // when we combine both the elements
        int low = 0, high = n1;// searches in the smaller array
        // BINARY SEARCH
        while (low <= high) {
            int mid1 = (low + high) >> 1;// bit manipulation for finding mid efficiently
            int mid2 = left - mid1;
            // VALS FOR COMPARISON
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];
            // correct partition found
            if (l1 <= r2 && l2 <= r1) {
                // all left elements are less than or equal to the right elements
                if (n % 2 == 1)// odd no of elements
                    return Math.max(l1, l2);
                else
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2;
            } else if (l1 > r2) {
                // move towards left of nums1
                high = mid1 - 1;

            } else {
                // move towards right of nums1
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
