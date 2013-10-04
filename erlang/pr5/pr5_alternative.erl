-module(pr5_alternative).
-compile(export_all).
-include_lib("eunit/include/eunit.hrl").

%From: http://www.smoil.com/2009/05/erlang-and-project-euler-problem-5/

%"My solution is to generate multiples of 20 checking if they are divisible by t%he numbers 11-19.  I can exclude 20 since I'm generating multiples of 20 and th%e numbers 12-20 are comprised of multiples of 1-10 so I can exclude 1-10.  I su%spect there is a faster algorithm using primes numbers < 20 as factors to gener%ate possibilities."

problem_five() -> problem_five(20).
problem_five(N) ->
    case(divisible_by(N, lists:seq(11, 19))) of
        true -> N;
        false -> problem_five(N+20)
    end.

divisible_by(N, [H|T]) ->
    case(N rem H == 0) of
        true -> divisible_by(N, T);
        false -> false
    end;
divisible_by(_N, []) -> true.
