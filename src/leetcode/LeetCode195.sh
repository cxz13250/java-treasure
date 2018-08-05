cat file.txt | awk 'NR==10'

cat file.txt | seed -n '10{p;q}'