-- Code aus der Aufgabenstellung

data Tree = Nil | Node Int Tree Tree deriving Show

testTree = Node 2 (Node 4 (Node 9 Nil Nil) (Node 3 Nil (Node 7 Nil Nil))) (Node 17 Nil Nil)

decTree :: Tree -> Tree
decTree Nil = Nil
decTree (Node v l r) = Node (v - 1) (decTree l) (decTree r)

sumTree :: Tree -> Int
sumTree Nil = 0
sumTree (Node v l r) = v + (sumTree l) + (sumTree r)

flattenTree :: Tree -> [Int]
flattenTree Nil = []
flattenTree (Node v l r) = v : (flattenTree l) ++ (flattenTree r)

decTree' :: Tree -> Tree
decTree' Nil = Nil
decTree' (Node v l r) = (\v l r -> Node (v-1) l r) v (decTree' l) (decTree' r)

sumTree' :: Tree -> Int
sumTree' Nil = 0
sumTree' (Node v l r) = (\v l r -> v + l + r) v (sumTree' l) (sumTree' r)

flattenTree' :: Tree -> [Int]
flattenTree' Nil = []
flattenTree' (Node v l r) = (\v l r -> v : l ++ r) v (flattenTree' l) (flattenTree' r)

foldTree :: (Int -> a -> a -> a) -> a -> Tree -> a
foldTree _ c Nil = c
foldTree f c (Node v l r) = f v (foldTree f c l) (foldTree f c r)

-- a
prodTree = foldTree (\x y z -> x * y * z) 1

-- b
incTree = foldTree (\x y z -> Node (x+1) y z) Nil
