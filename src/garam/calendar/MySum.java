package garam.calendar;

import java.util.Scanner;

public class MySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 입력 : 키ㅗㅂ드로 두 수의 입력을 받는다
		// 출력 : 화면에 출력한다.

		Scanner scanner = new Scanner(System.in);
		String inputValue = scanner.nextLine();

		String[] splitedValue = inputValue.split(",");

		int[] myVal = new int[splitedValue.length];
		int mySum = 0;
		String inputStr = "";
		for (int i = 0; i < splitedValue.length; i++) {
			myVal[i] = Integer.parseInt(splitedValue[i]);
			mySum = mySum + myVal[i];
			if (i < splitedValue.length - 1) {
				inputStr = inputStr + myVal[i] + " + ";
			} else {
				inputStr = inputStr + myVal[i] + " = ";
			}
		}

		System.out.println(inputStr + mySum);
		scanner.close();
	}

}
