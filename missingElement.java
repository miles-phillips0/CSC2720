public class missingElement {
    public static int missingElementLinear(int[] arr){
        int last = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(i != 0 && arr[i] != (last+1)){
                return last+1;
            }
            last = arr[i];
        }
        return -1;
    }
    public static int missingElementBinary(int[] arr){
         int low = 0;
         int high = arr.length-1;
         int mid;
         while(true){
             mid = (high+low)/2;
             if(low == high-1 && arr[high] - arr[low] != 1 ){
                 return arr[low]+1;
             }
             if(mid-low != (arr[mid]-arr[low])){
                 high = mid;
             } else if(high-mid != (arr[high]-arr[mid])){
                 low = mid+1;
             }
             else{
                 return -1;
             }
         }
    }


    public static void main(String [] args){
        int[] arr = {3,4,5,7,8}; //{0,1,2,3,4}
        System.out.print(missingElementBinary(arr));
    }



}
