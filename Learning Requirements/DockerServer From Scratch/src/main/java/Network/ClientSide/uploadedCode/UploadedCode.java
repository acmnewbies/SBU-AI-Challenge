
import java.util.Scanner;
import java.util.Random;

public class UploadedCode { 

	public static void main( String[] args ) { 
	
		Random r = new Random();
		String response = "";
		Scanner in = new Scanner( System.in );
	
		while ( true ) { 
		
			response = in.next();
			if ( response.equals( "END" ) )
				System.exit( 0 );
			else if ( response.equals( "ENTER_A_NUMBER" ) )
				System.out.println( r.nextInt( 6 ) + 1 );
			else
				System.exit( 1 );
		
		}
	
	}

}
