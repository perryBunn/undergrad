print("Perry Bunn")

one = input("Enter a string: ")
two = input("Enter a string: ")
three = input("Enter a string: ")
sort = [one,two,three]
a = sorted(sort)
print(a)

string = input("Enter a string: ")

onlyLetters = False
onlyUpper = False
onlyLower = False
onlyDig = False
mixedAlpha = False
startUpper = False
endPeriod = False

seen = [False,False,False,False] #letter, upper, lower, digit

if(string[0].isupper()):
    startUpper = True
if(string[-1] == "."):
    endPeriod = True

for i in range(len(string)):
    if (string[i].isdigit()):
        onlyLetters = False
        seen[3] = True
    if(string[i].isupper()):
        seen[0] = True
        seen[1] = True
    if(string[i].islower()):
        seen[0] = True
        seen[2] = True

if(seen[3] == False):
    onlyLetters = True
if(seen[0] == True and seen[3] == True):
    mixedAlpha = True
if(seen[1] == True and seen[2] == False):
    onlyUpper = True
if(seen[0] == False and seen[3] == True):
    onlyDig = True

print("Contains only letters: " + str(onlyLetters))
print("Contains only uppercase letters: " + str(onlyUpper))
print("Contains only lowercase letters: " + str(onlyLower))
print("Contains only digits: " + str(onlyDig))
print("Contains only letters and digits: " + str(mixedAlpha))
print("Starts with an uppercase letter: " + str(startUpper))
print("Ends with a period: " + str(endPeriod))

maritalStatusR = input("Are you married? (y/n): ")
maritalStatus = False
if(maritalStatusR == 'y'):
    maritalStatus = True
income = int(input("How much was your taxable income (Enter numbers only): "))

tax = 0

if (maritalStatus == True):
    if (income <= 16000):
        tax = income * .1
    elif (income <= 64000):
        tax = (income * .15) + 1600
    else:
        tax = (income * .25) + 8800
else:
    if (income <= 8000):
        tax = income * .1
    elif (income <= 32000):
        tax = (income * .15) + 800
    else:
        tax = (income * .25) + 4400
        
print("The final tax is: $" + str(round(tax,2)))

def printErr():
    print("Incompatable types")

    
compatable = False
while(not compatable):
    convert = input("Convert from (fl. oz, gal, oz, lb, in, ft, mi): ")
    convertFinal = input("Convert to (ml, l, g, kg, mm, cm, m, km): ")
    if (convert == "fl. oz" or convert == "gal"): #Fluid
        if (convertFinal == "ml" or convertFinal == "l"):
            compatable = True
        else: printErr()
    elif (convert == "oz" or convert == "lb"): #Weight
        if (convertFinal == "g" or convertFinal == "kg"):
            compatable = True
        else: printErr()
    else: # Length
        if (convertFinal == "mm" or convertFinal == "cm" or convertFinal == "m" or convertFinal == "km"):
            compatable = True
        else: printErr()

            
value = int(input("value: "))  
standardMetric = 0
converted = 0


if (convert == "fl. oz" or convert == "gal"): # Fluids
    if (convert == "fl. oz"): # Converts fl. oz to liters
        standardMetric = value / 33.814
    else: standardMetric = value * 3.785 # Converts gal to liters
        
    if (convertFinal == "ml"): # Converts liters to milliliters
        converted = standardMetric * 1000
    else: converted = standardMetric

elif (convert == "oz" or convert == "lb"): # Weights
    if (convert == "oz"): # Converts oz to grams
        standardMetric = value * 28.34952
    else: standardMetric = value * 453.59237 # Converts lb to grams
        
    if (convertFinal == "kg"): # Converts grams to kilograms
        converted = standardMetric / 1000
    else: converted = standardMetric

else: # Length
    if (convert == "in"): # Converts inches to meters
        standardMetric = value / 39.37
    elif (convert == "ft"): # Converts feet to meters
        standardMetric = value / 3.281
    else: # Converts miles to meters
        standardMetric = value * 1609.34
    
    if (convertFinal == "mm"): # Converts meters to millimeters
        converted = standardMetric * 1000
    elif (convertFinal == "cm"): # Converts meters to centimeters
        converted = standardMetric * 100
    elif (convertFinal == "km"): # Converts meters to kilometers
        converted = standardMetric / 1000
    else:
        converted = standardMetric
            
            
converted = round(converted, 3)
print(f"{value} {convert} = {converted} {convertFinal}")



