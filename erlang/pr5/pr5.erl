-module(pr5).
-compile(export_all).
-include_lib("eunit/include/eunit.hrl").

%2520 is the smallest number that can be divided by each of the numbers from 1 t%o 10 without any remainder.
%What is the smallest positive number that is evenly divisible by all of the num%bers from 1 to 20?

pr5_test_() ->
    [?_assert(findDiv(10) =:= 2520),
    ?_assert(findDiv(3) =:= 6)
    ].

findDiv(HighestDivisor) -> findDiv(HighestDivisor,HighestDivisor,1).

findDiv(_,1,NumberToTest) -> NumberToTest;
findDiv(HighestDivisor, CurentDivisor, NumberToTest) when CurentDivisor > 1 -> 
    case verifyNumber(CurentDivisor,NumberToTest) of
	divisorOk -> findDiv(HighestDivisor, CurentDivisor-1, NumberToTest);
	divisorError -> findDiv(HighestDivisor, HighestDivisor, NumberToTest+1)
    end.
    
verifyNumber(Divisor,NumberToTest) when NumberToTest rem Divisor == 0 -> divisorOk;
verifyNumber(_Divisor,_NumberToTest) -> divisorError.
%C example    
%found = false;
%smallestNum = 0;
%while(!found) {
%  for(int divisor = 0; divisor<maxDivisor ; ++i) {
%    validDivisor = verifyDivisor(smallestNum, divisor);
%    if(!validDivisor) {
%      break;
%    }
%    else
%    {
%      found = true;
%    }
%  }
%  if(!found) {
%  smallestNum++;
%  }      
%}


%%While loop example
%tail_duplicate(N,Term) -> tail_duplicate(N,Term,[]).
%tail_duplicate(0,_,List) -> List;
%tail_duplicate(N,Term,List) when N > 0 -> tail_duplicate(N-1, Term, [Term|List]).
