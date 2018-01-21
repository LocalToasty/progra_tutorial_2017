person(jgi).
person(jhe).
person(mha).
person(dko).
person(lbe).
person(saz).
person(fai).
person(ner).
person(mus).
hatRang(jgi, professor).
hatRang(jhe, assistent).
hatRang(mha, assistent).
hatRang(dko, assistent).
hatRang(lbe, tutor).
hatRang(saz, tutor).
hatRang(fai, student).
hatRang(ner, student).
hatRang(mus, student).

%Teilaufgabe b)
%?- hatRang(X, assistent).
%Ausgabe:
%X = jhe
%X = mha
%X = dko.

%Teilaufgabe c)
bossVon(X, Y) :- hatRang(X, professor), hatRang(Y, assistent).
bossVon(X, Y) :- hatRang(X, assistent), hatRang(Y, tutor).
bossVon(X, Y) :- hatRang(X, tutor), hatRang(Y, student).

%Teilaufgabe d)
%?- bossVon(X, _).
%Ausgabe:
%X = jgi
%X = jgi
%X = jgi
%X = jhe
%X = jhe
%X = mha
%X = mha
%X = dko
%X = dko
%X = lbe
%X = lbe
%X = lbe
%X = saz
%X = saz
%X = saz
%false.

%Teilaufgabe e)
vorgesetzt(B, S) :- bossVon(B, S).
vorgesetzt(B, S) :- bossVon(B, X), vorgesetzt(X, S).
