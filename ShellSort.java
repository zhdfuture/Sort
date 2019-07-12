import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] array,int gap) {
        int temp = 0;
        int j = 0;
        for (int i=gap;i<array.length;i++){
            temp=array[i];
            for(j=i-gap;j>=0;j-=gap){
                if(array[j]>temp){
                    array[j+gap]=array[j];
                }else{
                    break;
                }
            }
            array[j+gap]=temp;
        }
    }
    public static void shellSort1(int[] array){
        long start=System.currentTimeMillis();
        int[] d={5,3,1};   //分的组数
        for(int i=0;i<d.length;i++){
            shellSort(array,d[i]);
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void main(String[] args) {
        int[] array={1,78,56,77,99,3,7,65,4};
        shellSort1(array);
        System.out.println(Arrays.toString(array));
    }
}
