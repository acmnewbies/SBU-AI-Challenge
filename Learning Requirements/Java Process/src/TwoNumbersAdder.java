import java.util.Scanner;

public class TwoNumbersAdder {

	public static void main(String[] args) {

		Scanner in = new Scanner( System.in );
		long num1 = in.nextLong();
		long num2 = in.nextLong();

		long answer = num1 + num2;

		System.out.println( answer );

	}

}
