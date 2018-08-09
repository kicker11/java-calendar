package garam.calendar;import java.util.Scanner ;
public class Calendar {
	
	public static final int[] maxDayOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } ;
	public static final int[] maxDayOfMonthLeap = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } ;
	public int[][] calMon = new int[12][31];  
	
	public boolean isLeapYear(int year){
		if ( year % 4 == 0 && ( year % 100 != 0 || year % 400 == 0)) {
			return true ;
		} else {		
		    return false;
		}
	}

	public int getMaxDaysOfMonth(int year, int mon) {
		
		if (isLeapYear(year)) {
			return maxDayOfMonthLeap[mon-1] ;
		} else {
			return maxDayOfMonth[mon-1] ;
		}
	}
	

	public void setInit() {
        for ( int MM = 0 ; MM < 12; MM++) {
        	for ( int DD = 0; DD  < 31; DD++) {
        		calMon[MM][DD] = DD + 1;
        	}
        }
	}
	
	public void calPrint(int year, int mon) {
		System.out.println("   일   월   화   수   목   금   토");
		System.out.println("-----------------------");

        
		int rep = 0;
        		
		for ( int currntDay = 0; currntDay < getMaxDaysOfMonth(year, mon) ; currntDay++ ) {
			
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

}
