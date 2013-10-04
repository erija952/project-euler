-module(pr6).
-compile(export_all).
-include_lib("eunit/include/eunit.hrl").
%Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

%sum of squares =  1^2 + 2^2+...   
%square of sums = (1+2+.... )^2
pr6_test_() ->
    [?_assert(findDiff(10) == 2640),
    ?_assert(sumOfSquares(10) == 385),
    ?_assert(sumOfSquares(3) == 14),
    ?_assert(squareOfSums(10) == 3025),
    ?_assert(squareOfSums(3) == 36)
     ].

findDiff(N) -> squareOfSums(N) - sumOfSquares(N).

sumOfSquares(N) -> sumOfSquares(N,0).
sumOfSquares(N,Sum) when N > 0 ->
sumOfSquares(N-1,Sum + powerOfTwo(N));
sumOfSquares(0,Sum) -> 
  Sum.						   



%% %sumOfSquares(N) -> sumOfSquares(N,0,0).
%% %sumOfSquares(N,CurentIndex,Sum) when CurentIndex < N ->
%% % NewSum = Sum + powerOfTwo(CurentIndex),
%% % io:fwrite("Sum ~w ~w\n ", [CurentIndex, NewSum]),
%% % sumOfSquares(N,CurentIndex + 1,NewSum );
%% %sumOfSquares(N,N,Sum) -> 
%% % io:fwrite("FinalSum ~w\n ", [Sum]),
%% % Sum.						   

squareOfSums(N) -> squareOfSums(N,0).
squareOfSums(N,Sum) when N > 0 -> squareOfSums(N -1, Sum + N);
squareOfSums(0,Sum) -> powerOfTwo(Sum).    


powerOfTwo(X) -> math:pow(X,2).



foo(A,B) when A > 10 , B > 10 ->
    30;
foo(_A,_B) ->
    12.
