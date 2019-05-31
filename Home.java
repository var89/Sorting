import java.util.Arrays;
import java.util.Scanner;
public class Home {


    public static void main(String[] args) {
        int[] myLst = {4, 9, 7, 4, 3, 6, 5};
        myLst = mergeSort(myLst);
        System.out.println(Arrays.toString(myLst));

        binarySearch(myLst, 9);
    }


    static void binarySearch(int[] lst, int value){
        int n = binary(lst, value, 0, lst.length - 1);
        if(n > 0)
            System.out.println("found! It is at " + n);
        else   System.out.println("the element is not in the array");
    }

    static int binary(int[] lst, int value, int low, int high) {

        if(low > high)
            return -1;
        if (lst[(low + high) / 2] == value)
            return (low + high) / 2;
        else {
            if (lst[(low + high) / 2] > value)
                return binary(lst, value, low, (low + high) / 2 - 1);
            else return binary(lst, value, (low + high) / 2 + 1, high);
        }
    }

    static void selectionSort(int[] lst) {
        int n = lst.length;

        for (int i = 0; i < n; ++i) {
            int smallest = lst[i];
            int index = i;
            for (int j = i; j < n; ++j) {
                if (lst[j] < smallest) {
                    smallest = lst[j];
                    index = j;
                }
            }
            int temp = lst[i];
            lst[i] = smallest;
            lst[index] = temp;
            System.out.println(Arrays.toString(lst));

        }

    }

    static void linearSearch(int[] lst, int v) {
        int n = lst.length;
        for (int i = 0; i < n; i++) {
            if (lst[i] == v) {
                System.out.println("found! It is at " + (i + 1));
                return;
            }
        }
        System.out.println("the element is not in the array");
        return;
    }


    static void bubbleSort(int[] lst) {
        int n = lst.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (lst[i] > lst[i + 1]) {
                    int temp = lst[i];
                    lst[i] = lst[i + 1];
                    lst[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped == true);

        System.out.println(Arrays.toString(lst));
    }


    static int[] mergeSort(int[] lst) {
        int n = lst.length;
        int[] left;
        int[] right;
        if (n > 1) {
            if (n % 2 == 0) {
                left = new int[n / 2];
                right = new int[n / 2];
            } else {
                left = new int[n / 2];
                right = new int[n / 2 + 1];
            }

            for (int i = 0; i < n; ++i) {
                if (i < n / 2)
                    left[i] = lst[i];
                else
                    right[i-n/2] = lst[i];
            }

             left = mergeSort(left);

             right = mergeSort(right);

           return  merge(left, right);

        } else return lst;
    }


    static int[] merge(int[] left, int[] right){
        int n_l = left.length;
        int n_r = right.length;
        int[] res = new int[n_l + n_r];
        int i = 0, j = 0, res_i = 0;


        while(i < n_l && j < n_r) {
            if(left[i] < right[j])
                res[res_i++] = left[i++];
            else res[res_i++] = right[j++];
        }

        while(i != n_l)
            res[res_i++] = left[i++];
        while(j != n_r)
            res[res_i++] = right[j++];

        return res;
    }

}

