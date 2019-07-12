import java.util.Arrays;
//非递归，引入栈，（先进行一趟快排）
public class QuickSort1 {
    private static int partition(int[] a, int start, int end) {
        int midth = a[start];
        while (start < end) {
            while (start < end && a[end] >= midth)
                end--;
            a[start] = a[end];
            while (start < end && a[start] <= midth)
                start++;
            a[end] = a[start];
        }
        a[start] = midth;
        return start;
    }

    public static void quickSort1(int[] array){
            int[] stack=new int[array.length*2];
            int top=0;
            int low=0;
            int high=array.length-1;
            int part= partition(array,low,high);
        //1.判断当前par的左右两边是否有两个数据以上
        if(part>low+1){
            stack[top++]=low;
            stack[top++]=part-1;
        }
        if(part<high-1){
            stack[top++]=part+1;
            stack[top++]=high;
        }
        //判断栈是否为空，不为空，取出两个数对,将其赋给high,low
        while(top>0){
            high=stack[--top];
            low=stack[--top];
            //再次找基准
            part=partition(array,low,high);
            // 判断当前par的左右两边是否有两个数据以上
            if(part>low+1){
                stack[top++]=low;
                stack[top++]=part-1;
            }
            if(part<high-1){
                stack[top++]=part+1;
                stack[top++]=high;
            }
        }
        }
    public static void quickSort(int[] arr){
        long start = System.currentTimeMillis();
        quickSort1(arr);

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static void main(String[] args) {
        int[] array={55,7,89,77,31,2,5,6,8,5,4};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
    }
