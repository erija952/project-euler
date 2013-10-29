#include <iostream>
using namespace std;

int main() {
	unsigned long num = 20;
	int div = 2;
	int max_div = 20;
	while (div <= max_div) {
		if (num % div == 0) {
			div++;
		} else {

			num++;
			div=1;
		}
	}
	cout << num << endl;
}


