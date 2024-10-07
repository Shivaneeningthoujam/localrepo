package localrepo.OA;

//we are given an array and a target x. we are to search for the floor of x in the array
public class floor {
  public static int flo(int arr[], long x) {
    int start = 0, end = arr.length - 1, result = -1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == x)
        return mid;
      else if (arr[mid] < x) {
        result = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return result;
  }
}
