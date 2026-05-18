import java.util.Arrays;

public class LeetArray {
    public static void main(String[] args) {
        int[] revArray = {1, 2, 5, 5, 6};
        int[] reversedArray = reverseArray(revArray);
        printArray(reversedArray);
        int[] nullArray = {0, 1, 0, 3, 12};
        int[] nullEndArray = nullEndArray(nullArray);
        printArray(nullEndArray);
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);
        System.out.println("Профит = " + profit);
        int[] arrayPlusOne = {3,9,9};
        int[] plussedArray = arrayPlus(arrayPlusOne);
        printArray(plussedArray);

    }

    public static void printArray(int[] array) {
        int i = 0;
        System.out.print("[");
        for (i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[i] + "]");
    }

    //Реализовать reverse массива. Было [1,2,5,5,6] Стало [6,5,5,2,1]
    public static int[] reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return array;
    }

    //Given an integer array nums, move all 0's to the end of it while maintaining
    //the relative order of the non-zero elements.
    //тоже без доп памяти +
    //1 0 0 3 12 через do while
    public static int[] nullEndArray(int[] array) {
       int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[start] = array[i];
                start++;
            }
        }

        while (start < array.length) {
            array[start] = 0;
            start++;
        }
        return array;
    }

    //You are given an array prices where prices[i] is the price of a given stock on the ith day.
    //You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    //Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    public static int maxProfit(int[] prices) {
        int minElement = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= minElement) {
                minElement = prices[i];
            }
            if (prices[i] - minElement > profit) {
                profit = prices[i] - minElement;
            }
        }
        return profit;
    }

    //You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
    // The digits are ordered from most significant to least significant in left-to-right order.
    // The large integer does not contain any leading 0's.
    public static int[] arrayPlus(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < 9) {
                array[i]++;
                return array;
            }
            array[i] = 0;
        }
        int[] newArray = new int[array.length + 1]; //после цикла в начало ставлю 1. Потому что сюда дойдет, только если все девятки будут в массиве
        newArray[0] = 1;
        return newArray;
    }
}

