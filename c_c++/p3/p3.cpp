//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?

#include <iostream>
using namespace std;

int main() {
	cout << "Project Euler 3:" << endl; // prints !!!Hello World!!!
	auto n = 600851475143;
	auto highest_factor = 0;
	auto delimiter  = 2;
	while (n > 1) {
		while (n % delimiter == 0) {
			n = n/delimiter;
			highest_factor = n;
		}
		delimiter += 1;
		if (delimiter*delimiter > n) {
			break;
		}
	}
	cout << "Higest factor is " << highest_factor << endl;
	return 0;
}


