notdivisor(N, X) :- Y is N mod X, Y > 0. % x mod n != 0

% pruefe ob es eine Zahl zwischen 2 und X gibt, die N teilt.
nodivisors(_, 1).
nodivisors(N, X) :- notdivisor(N, X), Y is X - 1, nodivisors(N, Y).

prime(N) :- N > 1, X is N - 1, nodivisors(N, X).
