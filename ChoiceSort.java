import java.util.Arrays;

public class ChoiceSort {
    public static void choiceSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    int t=array[j];
                    array[j]=array[i];
                    array[i]=t;

                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array={3,1,6,3,7,8,34,11,22};
        ChoiceSort.choiceSort(array);
        System.out.println(Arrays.toString(array));

    }
}
