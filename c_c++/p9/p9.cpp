#include <iostream>
using namespace std;

int main() {

	for (int a =1 ; a < 1000; a++) {
		for (int b =1 ; b < 1000; b++) {
			for (int c =1 ; c < 1000; c++) {
				if (a+b+c == 1000) {
					if(a*a + b*b == c*c) {
						cout << "a " << a << " b " << b << " c " << c << " prod " << a*b*c << endl;
					}
				}
			}
		}
	}
}


