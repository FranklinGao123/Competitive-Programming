p = int(input())
n = int(input())
r = int(input())

last = n
day = 0
total = n

while total <= p:
    total += last*r
    last *=r
    day +=1
    
print(day)