public class Leet2Array {
    public static void main(String[] args) {
        int[] nums561 = {1, 4, 3, 2};
        int maxSum = arrayPairSum(nums561);
        System.out.println(maxSum);
        int[] nums2535 = {1,15,6,3};
        int absoluteSum = diffOfSumAndDigits(nums2535);
        System.out.println(absoluteSum);
        int[] nums3637 = {1,3,5,4,2,6};
        System.out.println(isTrionic(nums3637));
    }
    //561 arrayPartition не понимаю зачем разбивать и искать, если сумма будет максимальной для соседних элементов ?
    public static int arrayPairSum(int[] nums561) {
        java.util.Arrays.sort(nums561);
        int maxSum = 0;
        for (int i = 0; i < nums561.length; i += 2) {
            maxSum += nums561[i];
        }
        return maxSum;
    }
    //2535 sum of elements minus digit sum. Тут 3 варианта:
    //функция суммы + функция суммы чисел или функция разницы с функцией суммы чисел внутри или все внутри 1 функции
    public static int diffOfSumAndDigits(int[] nums2535) {
        int sumElements = 0;
        int digitSum = 0;
        for (int i = 0; i < nums2535.length; i++) {
            sumElements += nums2535[i];
            digitSum += sumOfDigits(nums2535[i]);
        }
        return Math.abs(digitSum - sumElements);
    }
    private static int sumOfDigits(int number) {
        int digitSum = 0;
        while (number > 0) {
            digitSum += number % 10;
            number /= 10;
        }
        return digitSum;
    }
    //3637 isTrionic
    public static boolean isTrionic(int[] nums3637) {
        int n = nums3637.length;
        if (n < 4) { //надо минимум 5 чисел
            return false;
        }
        int i = 1;

        while (i < n && nums3637[i] > nums3637[i - 1]) {
            i++;
        }
        int p = i - 1; //индекс первого элемента P, после которого идем вниз
        if (p == 0 || p == n - 1) { //не должен быть 1ым или последним, т.к. должен быть элемент после
            return false;
        }
        if (nums3637[p + 1] >= nums3637[p]) { //индекс первого элемента Q после P, после которого идем вверх
            return false; //если идем на возрастание, а не убывание
        }
        while (i < n && nums3637[i] < nums3637[i - 1]) { // Идем нвиз
            i++;
        }
        int q = i - 1;
        if (q == n - 1) { //не должен быть 1ым или последним, т.к. должен быть элемент после
            return false;
        }
        while (i < n) { // Идем наверх снова
            if (nums3637[i] <= nums3637[i - 1]) {
                return false;
            }
            i++;
        }
        return true; //все прошли, значит true
    }
}
