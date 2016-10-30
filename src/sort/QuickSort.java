package sort;

/**
 * Created by imliu on 2016/10/30.
 * 口诀：
 * 1. 设堤岸
 * 2. 防交叉
 * 3. 右先扫，防交叉
 * 4. 左再扫，防交叉
 * 5. 双递归
 */
public class QuickSort {

    private static int[] array;

    public static void sort(int[] array){
        QuickSort.array = array;
        if(array == null){
            throw new IllegalArgumentException("Array cannot be null!");
        }
        doSort(0, array.length - 1);
    }

    private static void doSort(int left, int right){
        //递归入口判断基本条件是否成立
        if(left < 0 || left > array.length || left >= right){
            return;
        }

        int i = left, j = right;     //i,j用于递归，随时会变化
        int tmp = array[left];       //取第区间第一个数为基准数

        //当i == j时，填入tmp即可结束
        while(i < j){
            //要从基准数反则开始遍历，防止有序数组被填入tmp被打乱
            //右往左扫描
            for(; j >= left && i != j; j--){    //left是可抵达的位置，不会越界
                if(array[j] <= tmp){
                    array[i] = array[j];
                    i++;
                    break;
                }
            }
            //左往右扫描
            for(; i <= right && i != j; i++){    //left是可抵达的位置，不会越界
                if(array[i] >= tmp){
                    array[j] = array[i];
                    j--;
                    break;
                }
            }
        }
        array[i] = tmp;

        //左区间递归
        doSort(left, i - 1);
        //右区间递归
        doSort(j + 1, right);
    }
}
