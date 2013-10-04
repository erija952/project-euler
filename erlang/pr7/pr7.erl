-module(pr7).
-compile(export_all).
-include_lib("eunit/include/eunit.hrl").

%By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we
%can see that the 6th prime is 13.

%What is the 10001st prime number?

%Rosses theorem: var upperLimit = (int) (n * Math.Log(n) + n *
%Math.Log(Math.Log(n))); Inspired by:
%http://kekoav.com/blog/36-computers/63-sieve-of-eratosthenes-in-erlang.html


pr7_test_() ->
    [?_assert(nthPrime(6) == 13),
     ?_assert(nthPrime(11) == 31),
     ?_assert(nthPrime(13) == 41),
     ?_assert(removeMultiplesFromList(2,[1,2,3,4,5,6,7,8]) == [1,3,5,7])
     ].

upperLimit(N) when N > 6 ->
    round((N*math:log(N) + N*math:log(math:log(N))));
upperLimit(_N) -> 14. 

nthPrime(N) ->
    UpperLimit =upperLimit(N),
    io:fwrite("UpperLimit is ~w \n Calculating primes.\n", [UpperLimit]),
    Primes = primes(UpperLimit),
    NrPrimes = length(Primes),
    io:fwrite("Found ~w primes\n", [NrPrimes]),
    NthPrime = lists:nth(N,Primes),
    io:fwrite("Where the Nth one is: ~w \n", [NthPrime]),
    NthPrime.

primes(N) -> 
    primes(N,lists:seq(2,N), math:sqrt(N)).
primes(N,[H|T], Stop) when H < Stop  ->
	[H |primes(N,removeMultiplesFromList(H,T),Stop)];
primes(_N,[H|T], _Stop)  -> [H|T].

removeMultiplesFromList(N,[H|T]) when H rem N == 0 -> 
    removeMultiplesFromList(N,T);
removeMultiplesFromList(N,[H|T]) -> 
    [H | removeMultiplesFromList(N, T)];
removeMultiplesFromList(_,[]) -> [].
