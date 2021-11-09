# Perry Bunn

proceed = True
numList = []
while (proceed):
    i = float(input("Please enter a float: "))
    numList.append(i)
    boolin = input("Do you wish to continue? (y/n) ")
    if boolin is "n":
        proceed = False

numList.sort()
avg = sum(numList) / len(numList)
smol = numList[0]
larg = numList[len(numList)-1]
ronge = larg - smol

print("Average: " + str(avg))
print("Smallest: " + str(smol))
print("Largest: " + str(larg))
print("Range: " + str(ronge))

for i in range(10):
    for j in range(10):
        print(str((i+1)*(j+1)), end=" ")
    print("")

length = int(input("Enter the side length: "))
n, m = 0, 0
for i in range(length*2):
    if (i+1) <= (length):
        print(" "*(length-n) + "*"*(2*i-1))
        n+=1
    else:
        print(" "*(m) + "*"*((2*i-1)-(m*4)))
        m+=1

numBuyers = 0
tickets = 100

while tickets is not 0:
    num = int(input("How many tickets would you like to buy? "))
    if num > 4:
        print("Max number of tickets per purchase is 4.")
        continue
    numBuyers = numBuyers + 1
    tickets -= num
    string = "Tickets remaining: {0}"
    print(string.format(tickets))

finString = "Total buyers: {0}"
print(finString.format(numBuyers))

