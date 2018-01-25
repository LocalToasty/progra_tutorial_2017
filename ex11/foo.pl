increment(leaf(X), leaf(s(X))).
increment(node(X, L, R), node(s(X), IncL, IncR)) :- increment(L, IncL),
                                                    increment(R, IncR).

append([], XS, XS).
append([X|XS], YS, [X|ZS]) :- append(XS, YS, ZS).

trav(leaf(X), [X]).
trav(node(X, L, R), ZS) :- trav(L, LS), trav(R, RS),
                           append(LS, [X|RS], ZS).

