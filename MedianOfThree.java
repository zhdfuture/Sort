import java.util.Arrays;

public class MedianOfThree {
    public static void medianofThree(int[] array,int low,int high){
        int mid=(low+high)>>>1;
        if(array[low]>array[mid]){
            swap(array,low,mid);
        }
        if(array[mid]>array[high]){
            swap(array,mid,high);
        }
        if(array[low]>array[high]){
            swap(array,low,high);
        }
        swap(array,high-1,mid);   //枢纽值被放在序列末尾
    }
    public static void swap(int[] array,int low,int high){
        int temp=array[low];
        array[low]=array[high];
        array[high]=temp;
    }
    public static void quickSort(int[] array,int low,int high) {
        if (low < high) {
            //获取枢纽值，并将其放在当前待处理序列末尾
            medianofThree(array, low, high);
            int mdt = high - 1;   //放在当前待处理序列末尾
            int i = low;
            int j = high - 1;  //左右指针
            while (true) {
                while (array[++i] < array[mdt]) {
                }
                while (j > low && array[--j] > array[mdt]) {
                }
                if (i < j) {
                    swap(array, i, j);
                } else {
                    break;
                }
            }
            if(i<high) {
                swap(array, i, high - 1);
            }
            //分段递归
                quickSort(array, low, i - 1);
                quickSort(array, i + 1, high);
            }
        }

    public static void main(String[] args) {
        int[] array={5,76,89,77,43,2,5,6,8,5,4};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
