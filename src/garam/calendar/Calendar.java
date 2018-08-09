package garam.calendar;
import java.util.Scanner ;
public class Calendar {
	
	public static final int[] maxDayOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } ;
	public int[][] calMon = new int[12][31];  

	public int getMaxDaysOfMonth(int mon) {
		return maxDayOfMonth[mon-1] ;
	}
	

	public void setInit() {
        for ( int MM = 0 ; MM < 12; MM++) {
        	for ( int DD = 0; DD  < 31; DD++) {
        		calMon[MM][DD] = DD + 1;
        	}
        }
	}
	
	public void calPrint(int mon) {
		System.out.println("   일   월   화   수   목   금   토");
		System.out.println("-----------------------");

        
		int rep = 0;
        		
		for ( int currntDay = 0; currntDay < getMaxDaysOfMonth(mon) ; currntDay++ ) {
			
			if ( rep < 6 ) {
				System.out.printf("%3d" , calMon[mon-1][currntDay] );
				rep++ ;
			} else {
				System.out.printf("%3d" , calMon[mon-1][currntDay] );
				System.out.print("\n");
				rep = 0 ;
			}
		}
		
		System.out.print("\n");
		System.out.print("\n");
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
			
	    	System.out.print(PROMPT);
		    System.out.print("월을 입력하세요 : "); 
		    //System.out.println("\n");
				    	
	    	int inValMonth = scanner.nextInt() ;
			
			if ( (inValMonth > 0 ) && (inValMonth < 13) ) {
			    System.out.print(PROMPT);
				System.out.printf("입력하신  %d 월의 달력 입니다.\n" , inValMonth) ;
				
				//, cal.getMaxDaysOfMonth(inValMonth));
				
				cal.calPrint(inValMonth);
				
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
