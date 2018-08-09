package garam.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = " Cal > "; 
	
	public void runPrompt() {

        Calendar cal = new Calendar() ;
		
		// 슛자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램

		cal.setInit();
        
        String PROMPT = " Cal > " ;
		Scanner scanner = new Scanner(System.in) ;
		
		
		//System.out.print("반복 횟수 ? : ");
		//int cnt = scanner.nextInt(); 
		
		
	    int cnt = 0 ;
	    
	    while (true) {    
			//int inValMonth = Integer.parseInt(scanner.nextLine()) ;

	    	
	    	System.out.print("YEAR>");
		    System.out.print("년도를 입력하세요 : "); 
		    int inValYear = scanner.nextInt() ;
		    
	    	System.out.print("MONTH>");
		    System.out.print("월을 입력하세요 : "); 
		    //System.out.println("\n");
				    	
	    	int inValMonth = scanner.nextInt() ;
			
			if ( (inValMonth > 0 ) && (inValMonth < 13) ) {
			    System.out.print(PROMPT);
				System.out.printf("입력하신 %d년  %d 월의 달력 입니다.\n" , inValYear, inValMonth) ;
				
				cal.calPrint(inValYear, inValMonth);
				
				cnt++ ;
			} else {
				System.out.print(PROMPT);
				System.out.println("잘못된 월을 입력하셨습니다. " ) ;
				break ;
			}
	    }	
	    System.out.print(PROMPT);
	    System.out.println(cnt + "회 만큼 반복하였습니다. Bye~") ;
		scanner.close();		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		Prompt p = new Prompt();
		p.runPrompt(); 
		
	}


}
