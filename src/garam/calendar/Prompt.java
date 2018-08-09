package garam.calendar;

import java.util.Scanner;

public class Prompt {

	public void runPrompt() {

		Calendar cal = new Calendar();

		// 슛자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램

		String PROMPT = " Cal > ";
		Scanner scanner = new Scanner(System.in);

		int cnt = 0;

		while (true) {

			System.out.print("YEAR > ");
			System.out.print("년도를 입력하세요 : ");
			int inValYear = scanner.nextInt();

			System.out.print("MONTH > ");
			System.out.print("월을 입력하세요 : ");
			int inValMonth = scanner.nextInt();

			System.out.print("DAY > SU MO TU WE TH FR SA \n");
			System.out.print("1일의 요일을 입력하세요 : ");
			String inValDay = scanner.next();
			System.out.print("\n");

			cal.setInitVal(inValYear, inValMonth, inValDay);

			if ((inValMonth > 0) && (inValMonth < 13)) {
				System.out.print(PROMPT);
				System.out.printf("입력하신 %d년  %d 월의 달력 입니다.\n", inValYear, inValMonth);

				cal.calPrint(inValYear, inValMonth, inValDay);

				cnt++;
			} else {
				System.out.print(PROMPT);
				System.out.println("잘못된 월을 입력하셨습니다. ");
				break;
			}
		}
		System.out.print(PROMPT);
		System.out.println(cnt + "회 만큼 반복하였습니다. Bye~");
		scanner.close();
	}

	public static void main(String[] args) {

		Prompt p = new Prompt();
		p.runPrompt();

	}

}
