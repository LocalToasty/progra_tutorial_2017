mult :: Int -> Int -> Int
mult _ 0 = 0
mult x y = x + (mult x (y - 1))

getLastTwo :: [Int] -> [Int]
getLastTwo [x, y] = [x, y]
getLastTwo (_:xs) = getLastTwo xs

bLog :: Int -> Int
bLog 1 = 0
bLog x = bLogH 2 1
  where bLogH y r | y > x = bLogH (y*2) (r+1)
                  | otherwise r

singleton :: Int -> [Int]
singleton n = reverse [1..n]

singleton2 :: Int -> [Int]
singleton2 0 = []
singleton2 n = n : singleton2 (n-1)

packing :: [[Int]] -> [Int] -> [[Int]]
packing []      _     = []
packing xs      []    = xs
packing ([]:xs) (y:ys) = [y] : packing xs ys
packing (x:xs)  ys     = x : packing xs ys

listAdd :: Int -> [Int] -> [Int]
listAdd _ [] = []
listAdd n (x:xs) = (x + n) : listAdd x xs
