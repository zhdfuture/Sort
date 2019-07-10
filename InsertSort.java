import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] array){
        int temp=0;
        int j=0;
        for(int i=0;i<array.length;i++){
             temp=array[i];   //引入一个临时变量，存放数据
            for(j=i-1;j>=0;j--){
                if(array[j]>temp){
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1]=temp;
        }

    }

    public static void main(String[] args) {
        int[] arry={9,8,7,10,5,4,6,7,11};
        insertSort(arry);
        System.out.println(Arrays.toString(arry)); //转换
    }
}
