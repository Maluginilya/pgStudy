import java.util.Scanner;

public class MainArray {
    public static void main(String[] args) {
        //int[] array1 = new int[5];
        //fillArray(array1);
        //printArray(array1);
        //int[] array2 = {1, 2, 3, 4, 5};
        //printArray(array2);
        //printArray(new int[]{5, 7, 9});
        int[] myArray = createAndFillArray();
        printArray(myArray);
        int sum = sumOfElements(myArray); //это если через вызов здесь
        System.out.println("Сумма элементов массива: " + sum); //сделал внутри функции
        int product = productEvenOnOdd(myArray);
        System.out.println("Произведение четных и нечетных эелментов: " + product);
        System.out.println("Максимальный элемент: " + largestElementFind(myArray));
        System.out.println("Минимальный элемент: " + lowestElementFind(myArray));
        int[] reversedArray = negativeToPositive(myArray);
        System.out.print("Массив без отрицательных элементов: "); //+ reversedArray) - пустота
        printArray(reversedArray);
    }

    public static void printArray(int[] array) {
        int i = 0;
        System.out.print("[");
        for (i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[i] + "]");
    }

    public static void fillArray(int[] array, Scanner s) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите элемент " + (i + 1) + ": ");
            array[i] = s.nextInt();
        }

    }

    //1. Создание массива (на вход из сканнера длина массива и заполнение массива
    // (можно через вызов фнукции fillArray)

    public static int[] createAndFillArray() {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите длину массива: "); //без ЛН, иначе длинну на новой строке вводить
        int length = s.nextInt(); //ввожу длину с клавиатуры
        int[] array = new int[length]; //теперь есть массив длиной, которую ввел
        fillArray(array, s); //заполняю его через функцию
        return array; //возвращаю, что напечатать через другую функцию. Написали с Артемом ранее
    }

    //2. Найти сумму эл-ов массива
    public static int sumOfElements(int[] array) {
        int sumElements = 0;
        for (int i = 0; i < array.length; i++) {
            sumElements += array[i];
        }
        return sumElements;
    }

    //3. Найти произведение сумму четных на сумму нечетных эл-ов массива
    public static int productEvenOnOdd(int[] array) {
        int sumEven = 0;
        int sumOdd = 0;
        int product = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sumEven += array[i]; //если четное
            } else {
                sumOdd += array[i];
                ; //если нечетное
            }
        }
        product = sumEven * sumOdd;
        return product;
    }

    //4. Найти наибольший эл_т массива
    public static int largestElementFind(int[] array) {
        if (array.length == 0) {}
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= maxElement) {
                maxElement = array[i];
            }
        }
        return maxElement;
    }
    //5. Найти наименьший эл-т массива
    public static int lowestElementFind(int[] array) {
        if (array.length == 0) {}
        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= minElement) {
                minElement = array[i];
            }
        }
        return minElement;
    }
    //6. Избавиться от отрицательных чисел в массиве (все должны стать >=0)
    public static int[] negativeToPositive(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] *= -1;
            }
        }
        return array;
    }
}