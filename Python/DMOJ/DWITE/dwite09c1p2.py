def letters(a,word, length):
    global alphabet
    for j in range(26):
        if a[j] == 1:
            a[j] -= 1
            letters(a,word+alphabet[j],length)
            a[j] += 1
    if len(word) == length:
        print(word)


alphabet = "abcdefghijklmnopqrstuvwxyz"
for i in range(5):
    a = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    b = input()
    for i in b:
        a[alphabet.index(i)] += 1
    letters(a,"",len(b))