//A palindromic number reads the same both ways.
//The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//Find the largest palindrome made from the product of two 3-digit numbers.

#include <iostream>
using namespace std;

//abccba=a*100000+b*10000+c*1000+c*100+b*10+a*1
bool is_palindrome(int number) {
	int tmp=number, inverted_number=0;

	    while (tmp)
	    {
	        inverted_number = inverted_number*10 + (tmp % 10);
	        tmp /= 10;
	    }
	    return (inverted_number == number ? true : false);
}

int main() {
	auto init = 100;
	auto max = 1000;
	auto j = init;
	auto k = init;
	auto highest = 0;
	while(j< max) {
		while (k < max) {
			auto current = j*k;
			if( is_palindrome(current) && current > highest) {
					highest = current;
			}
			k= k+1;
		}
	j = j+1;
	k = init;
	}

	cout << "Number is " << highest << endl;
}


