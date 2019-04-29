
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
	
	return 0;
	
}

