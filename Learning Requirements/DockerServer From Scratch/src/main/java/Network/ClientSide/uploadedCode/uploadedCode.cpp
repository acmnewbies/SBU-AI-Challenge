
#include <iostream>
#include <time.h>
#include <cstdlib>
#include <string>

int main () { 

	srand( time( NULL ) );
	std::string response;

	while ( true ) {

		std::cin >> response; 
		if ( response == "END" ) 
			exit( 0 );
		else if ( response == "ENTER_A_NUMBER" ) 
			std::cout << ( ( rand() % 6 ) + 1 ) << std::endl;
		else
			exit( 1 );

	}

	return 0;

}

