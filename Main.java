public class Main {
    public static void main(String[] args) { //переменные для функций
        int number = 8;
        checkEvenOrOdd(number);
        int endNumber = 100;
        checkSum(endNumber);
        int countFrom = 3;
        int countTo = 1;
        countDown(countFrom, countTo);
        int n = 1;
        int multiply = 13;
        multiTable(n, multiply);
        int fizzNumber = 1;
        int buzzNumber = 15;
        fizzBuzzTrain(fizzNumber, buzzNumber);
        int[] largestNumber = {5, 4, 3};
        largestNumberFind(largestNumber);
        int loopNumber = 3;
        factorial(loopNumber);
        primeList();
        int commonInt = 1234;
        sumElements(commonInt);
        sumElementsLoop();
        int pyramidHeight = 5;
        pyramid(pyramidHeight);
    }

    //№1. Write a program that takes an integer variable and prints "even" if it is even, or "odd" if it is odd.
    public static void checkEvenOrOdd(int number) { //function = 1
        if (number % 2 == 0) {
            System.out.println("even"); //если четное
        } else {
            System.out.println("odd"); //если нечетное
        }
    }

    //№2. Sum of NumbersUsing a for loop, calculate and print the sum of all integers from 1 to 100.
    public static void checkSum(int endNumber) {
        int sum = 0;
        for (int i = 1; i <= endNumber; i++) {
            sum = sum + i; //можно через +=. Как замерить скорость ?
        }
        System.out.println("Сумма чисел от 1 до endNumber: " + sum);
    }

    //№3. Write a for loop that prints numbers from 10 down to 1, each on a new line, and then prints "Go!".
    public static void countDown(int countFrom, int countTo) {
        for (int i = countFrom; i >= countTo; i--) {
            System.out.println(i + " - число в цикле"); //печатаем каждое число в цикле
        }
        System.out.println("Go!"); //печатаем окончание
    }

    //№4. Write a program that prints the multiplication table for a given number n (from n * 1 to n * 10)
    // one line per result. For example, for n = 5: 5 x 1 = 5, 5 x 2 = 10, etc.
    public static void multiTable(int n, int multiply) {
        for (int i = 1; i <= multiply; i++) {
            System.out.println(n + " x " + i + " = " + n * i);
        }
    }

    //№5. through numbers from 1 to 30. For each number:
    //print "Fizz" if it is divisible by 3,
    //print "Buzz" if it is divisible by 5,
    //print "FizzBuzz" if it is divisible by both 3 and 5,
    //otherwise print the number itself.
    public static void fizzBuzzTrain(int fizzNumber, int buzzNumber) {
        for (int i = fizzNumber; i <= buzzNumber; i++) {
            if (i % 3 == 0 && i % 5 == 0) { //почему двойное условие нужно наверх ? тут важен порядок ?
                System.out.println(i + " = FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println(i + " = Fizz");
            } else if (i % 5 == 0) {
                System.out.println(i + " = Buzz");
            } else {
                System.out.println(i + " not Fizz and not Buzz");
            }
        }
    }

    //№6. Write a function maxOfThree(a: Int, b: Int, c: Int): Int that returns the largest of three integers.
    // Call it with several different sets of arguments and print the results.
    public static void largestNumberFind(int[] largestNumber) {
        int max = largestNumber[0];
        for (int i = 0; i < largestNumber.length; i++) {
            if (largestNumber[i] >= max) {
                max = largestNumber[i];
            }
        }
        System.out.println(max + " - максимальное число");
    }

    //#7. Write a function factorial(n: Int): Long that calculates the factorial of n using a for loop.
    public static void factorial(int loopNumber) {
        int factorial = 1;
        for (int i = 1; i <= loopNumber; i++) {
            factorial = factorial * i;
        }
        System.out.println("factorial = " + factorial);
    }

    //#8. Write a function isPrime(n: Int): Boolean that returns true if a number is prime and false otherwise.
    // Then use a for loop to print all prime numbers from 2 to 50.
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false; //Если меньше 1, то уже не простое
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false; //Есть какой-то делитель, то уже не простое
            }
        }
        return true; // Нет делителей, число простое
    }

    public static void primeList() {
        for (int i = 2; i <= 50; i++) {
            if (isPrime(i)) {
                System.out.print(i + " "); //Печать в 1 строку
            }
        }
        System.out.println(); //Добавляю разделитель, иначе ответы по 8 и 9 в 1 строку
    }

    //№9. Write a function digitSum(n: Int): Int that returns the sum of the digits of a positive integer.
    // For example, digitSum(1234) should return 10.
    // Then loop through numbers from 1 to 100 and print only those whose digit sum is exactly 7.
    public static int sumElements(int commonInt) {
        int sumEl = 0;
        while (commonInt > 0) {
            sumEl = sumEl + commonInt % 10; //Отстаток от деления на 10 в сумму
            commonInt = commonInt / 10; //Оставляем число без крайнего элемента
        }
        return sumEl;
    }

    public static void sumElementsLoop() {
        // Loop through numbers from 1 to 100
        for (int i = 1; i <= 100; i++) {
            if (sumElements(i) == 7) { //Проверяю, что сумма элементов 7
                System.out.print(i + " "); // Print nu
            }
        }
        System.out.println(); //Добавляю разделитель, иначе ответ 10 по 1 ряду не в той строке
    }

    //№10. Write a function printPyramid(height: Int) that prints a number pyramid.
    public static void printPyramid(int height) {
        for (int row = 1; row <= height; row++) {
            // Выводим пробелы слева
            for (int space = height - row; space > 0; space--) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void pyramid(int pyramidHeight) {
        printPyramid(pyramidHeight); // Вызов функции с высотой пирамиды равной 5
    }

}
