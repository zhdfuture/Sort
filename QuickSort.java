import java.util.Arrays;

public class QuickSort {
    //分成两个子序列
    public static int partion(int[] array, int low, int high) {
        //空出第一个元素的位置
        int temp = array[low];
        while (low < high) {
            while (low < high && array[high] >= temp) {
                high--;
            }
            if (low >= high) {
                break;
            } else {
                array[low] = array[high];   //相遇
            }
            while (low < high && array[low] <= temp) {
                low++;
            }
            if (low >= high) {
                break;
            } else {
                array[low] = array[high];   //相遇
            }
        }
        array[low] = temp;
        return low;
    }

    public static void Insert(int[] array, int start, int end) {
        int temp = 0;
        int j = 0;
        for (int i = start + 1; i <= end; i++) {
            temp = array[i];
            for (j = i - 1; j >= start; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }

            }
            array[j + 1] = temp;

        }
    }

    public static void quick(int[] array,int start,int end){
        //为了实现高效快速，规定前多少个用直接插入排序
        if(end-start+1<=24){
            Insert(array,start,end);     //前24个用直接插入排序
            return;

        }
        int part=partion(array,start,end);
        if(part>start+1){
            //确保左边有两个数据以上，然后递归左边的
            quick(array,start,part-1);
        }
        if(part<end-1){
            //确保右边有两个数据，然后递归右边的
            quick(array,part+1,end);
        }
    }
    public static void quickSort(int[] array){
        long start=System.currentTimeMillis();
        quick(array,0,array.length-1);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void main(String[] args) {
        int[] array={5,76,89,77,43,2,5,6,8,5,4};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}