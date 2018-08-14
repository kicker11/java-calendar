package garam.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	
	public static final String PROMPT = "Cal > " ;
	
	public void printMenu() {
		System.out.println("+==========================================+");
		System.out.println("+ 1. 일정 등록                                                           +");
		System.out.println("+ 2. 일정 조회                                                          +");
		System.out.println("+ 3. 달력 표시                                                           +");
		System.out.println("+ h. 메뉴 출력                                                          +");
		System.out.println("+ q. 종     료                                                           +");
		System.out.println("+==========================================+");
	}

	public void cmdCal(Scanner scanner, Calendar cal) {

		System.out.print("YEAR > ");
		System.out.print("년도를 입력하세요 : ");
		int inValYear = scanner.nextInt();

		System.out.print("MONTH > ");
		System.out.print("월을 입력하세요 : ");
		int inValMonth = scanner.nextInt();


		cal.setInitVal(inValYear, inValMonth);

		if ((inValMonth > 0) && (inValMonth < 13)) {
			System.out.print(PROMPT);
			System.out.printf("입력하신 %d년  %d 월의 달력 입니다.\n", inValYear, inValMonth);

			cal.calPrint(inValYear, inValMonth);

		} else {
			System.out.print(PROMPT);
			System.out.println("잘못된 월을 입력하셨습니다. ");
			return;
		}
		System.out.print(PROMPT);

	}

	public void cmdRegister(Scanner scanner, Calendar cal)  {
		System.out.println("[새 일정 등록]");
		System.out.println("[날자를 입력해 주세요 ( yyyy-mm-dd )]");
		String date = scanner.next();
		System.out.println("[일정을 입력해 주세요 (문장의 끝에 ; 으로 종료하세요]");
		String text = "";
		while (true) {
			String word = scanner.next();
			text += word + " " ;
			if (word.endsWith(";")) {
				break ;
			}
		}
		
  	   try {
		cal.registerPlan(date, text);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	public void cmdSearch(Scanner scanner, Calendar cal) {
		System.out.println("[일정 검색]");
		System.out.println("[날자를 입력해 주세요 ( yyyy-mm-dd )] \n");
		String date = scanner.next();
		try {
			String plan = cal.searchPlan(date) ;
			System.out.println(plan);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습니다. \n");
		}

	}
	
	public void runPrompt()  {
		
		printMenu() ;

		// 슛자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램

		String PROMPT = " Cal > ";

		Scanner scanner = new Scanner(System.in) ;
		
		while (true) {
			Calendar cal = new Calendar();
			while (true) {
				String cmd = scanner.next();
				if ( cmd.equals("1")) cmdRegister(scanner, cal);
				else if (cmd.equals("2")) cmdSearch(scanner, cal) ;
				else if (cmd.startsWith("3")) cmdCal(scanner, cal) ;
				else if (cmd.startsWith("h")) printMenu() ;
				else if (cmd.startsWith("q"))  break; 
			}	
			System.out.print(PROMPT);
			System.out.println("Bye~");
			break;
		}
	}
		

	public static void main(String[] args) {

		Prompt p = new Prompt();
		p.runPrompt();
	}
}
