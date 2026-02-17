public class SelectionSort {
    // in selection sort we are taking range and putting minimum element at start of the array
    public static void sort(int[] arr){
    int n = arr.length;

    for(int i = 0; i < n - 1; i++){
        int minIndex = i;

        for(int j = i + 1; j < n; j++){
            if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
        }

        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}

    public static void main(String[] args) {
        int[] arr = {7, 3,2,3,5, 6};
        sort(arr);
        for(int num: arr){
            System.out.println(num);
        }
        
    }
}
