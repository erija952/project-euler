-module(pr4).
-compile(export_all).
-include_lib("eunit/include/eunit.hrl").

%A palindromic number reads the same both ways. The largest palindrome 
%made from the product of two 2-digit numbers is 9009 = 91 × 99.

%Find the largest palindrome made from the product of two 3-digit 
%numbers.

pr4_test_() ->
    [?_assert(findMaxPalindrome(100) == 9009),
     ?_assert(isPalindrome(9009) == true),
     ?_assert(isPalindrome(934) == false)
     ].

findMaxPalindrome(N) -> maxPalindrome(N,N,[],N).

maxPalindrome(Val1, Val2, List, MaxN) when Val2 > 0, Val1 > 0 ->
Product = Val1*Val2,
case isPalindrome(Product) of
     true -> %io:fwrite("Found palindrome ~w by using ~w * ~w \n ", [Product,Val1,Val2]),
	     maxPalindrome(Val1, Val2-1, [Product| List], MaxN);
     false -> maxPalindrome(Val1, Val2-1, List, MaxN)			     
end;
maxPalindrome(Val1, 0, List, MaxN) -> maxPalindrome(Val1-1, MaxN, List, MaxN);
maxPalindrome(0, MaxN, List, MaxN) -> lists:max(List).


isPalindrome(N) ->
    List = integer_to_list(N),
    List == lists:reverse(List).

