-module(pr10).
-compile(export_all).
-include_lib("eunit/include/eunit.hrl").

%The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

%Find the sum of all the primes below two million.

pr10_test_() ->
    [?_assert(sumPrimes(10) == 17),
     ?_assert(sumPrimes(15) == 41)
     ].


sumPrimes(UpperLimit) ->
    Primes = primes(UpperLimit),
    SumPrimes = lists:sum(Primes),
    io:fwrite("The sum of all primes below ~w is ~w \n", [UpperLimit, SumPrimes]),
    SumPrimes.

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
