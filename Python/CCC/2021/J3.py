previous = ""
while True:
    temp = input()
    output = ""
    if temp == "99999":
        break
    if int(temp[0]) + int(temp[1]) == 0:
        output += previous
    elif (int(temp[0]) + int(temp[1]))%2 == 0:
        output += "right"
        previous = "right"
    else:
        output += "left"
        previous = "left"
    output += " "
    output += temp[2:5]
    print(output)