# Perry Bunn

def ground_coffee():
    print("Add coffee beans to grinder")
    print("Grind for 60 seconds.")

def brew_coffee():
    print("Add water to coffee.")
    print("Add filter to coffee.")
    ground_coffee()
    print("Add coffee grounds to filter.")
    print("Turn coffee maker on.")

def boil_water():
    question = input("Do you have a microwave? (y/n): ")
    if question == "y":
        print("Fill cup with water.")
        print("Put cup into microwave.")
        print("Heat for 3 minutes.")
        return
    print("Fill kettle with water.")
    print("Bring to a boil.")

def instant_coffee():
    boil_water()
    print("Mix water and instant coffee.")

def make_coffee():
    question = input("Do you have instant coffee? (y/n): ")
    if question == "y":
        instant_coffee()
        return
    brew_coffee()

def get_coffee():
    question = input("Can you ask someone to make coffee? (y/n): ")
    if question == "y":
        print("Ask for coffee.")
        return
    make_coffee()

get_coffee()

def secure(string = "", dev = False):
    if string == "":
        condition = True
        while (condition):
            string = input("Please enter your password: ")
            stringCheck = input("Please enter your password again: ")
            if string == stringCheck:
                condition = False 
    if len(string) >= 8:
        if any(c.islower() for c in string):
            if any(c.isupper() for c in string):
                if any(c.isdigit() for c in string):
                    return "'" + string + "' is a valid password"
    if not dev:
        print("'" + string + "' is not a valid password")
        secure()
    else: return "Not Valid"
    
print(secure("no", True))        # False 
print(secure("12345678", True))  # False
print(secure("no123456", True))  # False
print(secure("noNOnoNO", True))  # False
print(secure("yeS12345", True))  # True
print(secure())                  # User input

# Because I can
def factorial(n):
    if n <= 1:
        return 1
    return n * factorial(n-1)

print(factorial(0))
print(factorial(1))
print(factorial(2))
print(factorial(3))
print(factorial(4))
print(factorial(5))
print(factorial(6))



