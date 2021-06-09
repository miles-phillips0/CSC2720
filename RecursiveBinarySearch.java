
public class RecursiveBinarySearch {
    public static int recursiveBinarySearch(int min, int max, int target, int[] arr){
        if(min > max){
            return -1;
        }
        int mid = (min+max)/2;
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] < target){
            return recursiveBinarySearch(mid+1, max, target, arr);
        }else return recursiveBinarySearch(min, mid-1, target, arr);
    }
    public static void main(String [] args){
        int[] arr = {1,2,3,4,5,6};
        System.out.println(recursiveBinarySearch(0, arr.length-1, 7, arr));
    }
}
