n = int(input())
m = int(input())
count = 0
for i in range(m):
  a = int(input())
  if a>=n:
    count+=1
print(count)