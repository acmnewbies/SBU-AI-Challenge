
#include <iostream>
#include <fstream>
#include <cstdlib>

using namespace std;

int main () { 

	system( "javac Doubler.java" );

	int n;
	cin >> n;
	
	ofstream fout( "javaInput" );
	fout << n << endl;
	fout.close();
	
	system( "java Doubler < javaInput > javaOutput" );
	
	ifstream fin( "javaOutput" );
	int answer;
	fin >> answer;
	
	cout << answer << endl;
	
	fin.close();
	system( "rm javaInput javaOutput Doubler.class" );
	
	return 0;
	
}



java how to run a proccess
how to access proccess streams


