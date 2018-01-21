odds :: [Int]
odds = filter (\x -> x `mod` 2 == 1) [1..]

odds2 :: [Int]
odds2 = 1 : map (+ 2) odds

-- Unendliche Liste aller Primzahlen
primes :: [Int]
primes = filterPrime [2..]
  where filterPrime (p:xs) =
          p : filterPrime [x | x <- xs, x `mod` p /= 0]

primeFactors :: Int -> [Int]
primeFactors = pHelper primes
  where pHelper (p:ps) x | x == 1         = []
                         | x `mod` p == 0 = p : pHelper (p:ps) (x `div` p)
                         | otherwise      = pHelper ps x
