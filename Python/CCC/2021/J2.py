n = int(input())
maximum = -1
bidder = ""

for i in range(n):
    name = input()
    amount = int(input())
    if maximum<amount:
        maximum = amount
        bidder = name
        
print(bidder)