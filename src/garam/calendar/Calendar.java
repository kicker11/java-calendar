package garam.calendar;
import java.util.Scanner ;
public class Calendar {
	
	private static final int[] maxDayOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } ;  

	public int getMaxDaysOfMonth(int mon) {
		return maxDayOfMonth[mon-1] ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("   일   월   화   수   목   금   토");
		System.out.println("-----------------------");
		System.out.println("  1  2  3  4  5  6  7");
		System.out.println("  8  9 10 11 12 13 14");
		System.out.println(" 15 16 17 18 19 20 21");
		System.out.println(" 22 23 24 25 26 27 28");
		System.out.println(" 29 30 31            ");

		
		// 슛자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
        //int[] maxDayOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } ; 
		
        // maxDayOfMonth[0] = 31;
        // maxDayOfMonth[1] = 28;
        // maxDayOfMonth[2] = 31;
        // maxDayOfMonth[3] = 30;
        // maxDayOfMonth[4] = 31;
        // maxDayOfMonth[5] = 30;
        // maxDayOfMonth[6] = 31;
        // maxDayOfMonth[7] = 31;
        // maxDayOfMonth[8] = 30;
        // maxDayOfMonth[9] = 31;
        // maxDayOfMonth[10]= 30;
        // maxDayOfMonth[11] = 31;
        
        String PROMPT = " Cal > " ;
		Calendar cal = new Calendar() ;
		Scanner scanner = new Scanner(System.in) ;
		
		
		//System.out.print("반복 횟수 ? : ");
		//int cnt = scanner.nextInt(); 
		
		
	    int cnt = 0 ;
	    
	    while (true) {    
			//int inValMonth = Integer.parseInt(scanner.nextLine()) ;
			
	    	System.out.print(PROMPT);
		    System.out.print("월을 입력하세요 : "); 
		    //System.out.println("\n");
				    	
	    	int inValMonth = scanner.nextInt() ;
			
			if ( (inValMonth > 0 ) && (inValMonth < 13) ) {
			    System.out.print(PROMPT);
				System.out.printf("입력하신  %d 월의 마지막 날은 %d 입니다.\n" , inValMonth, cal.getMaxDaysOfMonth(inValMonth));
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

}
