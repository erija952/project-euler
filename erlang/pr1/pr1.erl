  -module(pr1).
  -compile(export_all).
  -include_lib("eunit/include/eunit.hrl").


%If we list all the natural numbers below 10 that are multiples of 3 or 5,
%we get 3, 5, 6 and 9. The sum of these multiples is 23.
%Find the sum of all the multiples of 3 or 5 below 1000.

   pr1_test_() ->
       [?_assert(findNaturals(8) =:= 14),
	?_assert(findNaturals(10) =:= 23)
       ].

findNaturals(N) -> findNaturals(N,N-1,0).

findNaturals(N,LoopX, Acc) when LoopX > 0, LoopX rem 3 == 0 -> findNaturals(N,LoopX-1, Acc+LoopX);
findNaturals(N,LoopX, Acc) when LoopX > 0, LoopX rem 5 == 0 -> findNaturals(N,LoopX-1, Acc+LoopX);
findNaturals(N,LoopX, Acc) when LoopX > 0 -> findNaturals(N,LoopX-1, Acc);
findNaturals(_,0, Acc) -> Acc.

