public class reverseArrayRecursion {
    
    public static void reverse(int l, int r, int[] arr){

        if(l > r) return;

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        l++;
        r--;
        reverse(l, r, arr);
    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        reverse(0, 4, arr);

        for(int num: arr){
            System.out.println(num);
        }
    }

}
