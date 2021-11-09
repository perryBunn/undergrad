meters = int(input("Meters to convert: "))
print(str(meters / 1609) + " miles")
print(str(meters * 3.281) + " feet")
print(str(meters * 39.37) + " inches")

print("   /\\")
print("  /  \\")
print(" /    \\")
print("/      \\")
print("- - - - -")
print("  \"  \"")
print("  \"  \"")
print("  \"  \"")

price = int(input("Price of book: "))
number = int(input("Number of books: "))
print("Total: " + str((price*number) + (2 * number) + ((price*number)*.075)))

number = int(input("Enter the number of movie rentals: "))
referred = int(input("Enter the number of members referred to the video club: "))
percent = number + referred
if (percent > 75):
    print("The discount is equal to: 75 percent")
else:
    print("The discount is equal to: " + str(percent) + " percent")

