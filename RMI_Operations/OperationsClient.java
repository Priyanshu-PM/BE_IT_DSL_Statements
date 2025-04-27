import java.rmi.*;

public class OperationsClient {
    public static void main(String[] args) {
        try {
            String serverAddress = "rmi://localhost:3031/AdditionService";
            Operations stub = (Operations) Naming.lookup("rmi://localhost:3031/OperationService");

            int result = stub.add(15, 25);
            System.out.println("Result: 15 + 25 = " + result);

            result = stub.add(50, 75);
            System.out.println("Result: 50 + 75 = " + result);

            result = stub.subtract(100, 50);
            System.out.println("Result: 100 - 50 = " + result);

            result = stub.multiply(10, 20);
            System.out.println("Result: 10 * 20 = " + result);
            result = stub.division(100, 5);

            System.out.println("Result: 100 / 5 = " + result);
            result = stub.square(5);
            System.out.println("Result: 5^2 = " + result);

            result = stub.squareRoot(25);
            System.out.println("Result: sqrt(25) = " + result);
            result = stub.power(2, 3);
            System.out.println("Result: 2^3 = " + result);

            stub.palindrome("madam");
            stub.palindrome("hello");
            stub.isEqualString("hello", "hello");
            stub.isEqualString("hello", "world");

            double celsius = 37.0;
            double fahrenheit = stub.celsiusToFahrenheit(celsius);
            System.out.println(celsius + " Celsius = " + fahrenheit + " Fahrenheit");
            double miles = 100.0;
            double kilometers = stub.milesToKilometers(miles);
            System.out.println(miles + " miles = " + kilometers + " kilometers");
            String name = "John";
            String greeting = stub.nameAppendToHello(name);
            System.out.println("Greeting: " + greeting);
            String str1 = "apple";
            String str2 = "banana";
            String largest = stub.lexicallyLargestString(str1, str2);
            System.out.println("Lexically largest string between " + str1 + " and " + str2 + " is: " + largest);
            int count = stub.countVowels("hello world");
            System.out.println("Number of vowels in 'hello world': " + count);
            int factorial = stub.findFactorial(5);
            System.out.println("Factorial of 5: " + factorial);


        } catch (NotBoundException e) {
            System.out.println("NotBoundException: " + e);
        } catch (Exception e) {
            System.out.println("Client Exception: " + e);
        }
    }
}
