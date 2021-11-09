# Perry Bunn

import math, random


class List(list):
    def swap_ends(self):
        temp = self[0]
        self[0] = self[len(self) - 1]
        self[len(self) - 1] = temp
        return self

    def shift(self):
        temp = self.pop(len(self) - 1)
        self.insert(0, temp)
        return self

    def replace_even(self):
        for x in range(len(self) - 1):
            if self[x] % 2 == 0:
                self[x] = 0
        return self

    def replace_largest_neighbor(self):
        for x in range(len(self) - 1):
            if x == 0 or x == len(self) - 1:
                continue
            else:
                largest = max(self[x - 1], self[x + 1])
                self[x] = largest
        return self

    # If the length of the list is 2 or less then the resulting list will be empty
    def remove_middle(self):
        if len(self) % 2 == 0:
            self.pop(math.ceil(len(self) / 2))
            self.pop(math.floor(len(self) / 2))
        else:
            self.pop(math.floor(len(self) / 2))
        return self

    def even_front(self):
        index = 0
        for x in range(len(self)):
            if self[x] % 2 == 0:
                temp = self.pop(x)
                self.insert(index, temp)
                index += 1
        return self

    # if the list is length 1 then it will return None
    def second_largest(self):
        try:
            self.sort(reverse=True)
            return self[1]
        except LookupError:
            return None

    def is_sorted(self):
        ref = self
        ref.sort()
        return ref == self

    def dup_adjacent(self):
        for x in range(len(self) - 1):
            if self[x] == self[x + 1]:
                return True
        return False

    def dup_items(self):
        temp = set(self)
        return len(temp) < len(self)


numbers = []
change = []
for x in range(10):
    temp = List([])
    temp2 = List([])
    for x in range(0, 10):
        val = random.randint(0,100)
        temp.append(val)
        temp2.append(val)
    numbers.append(temp)
    change.append(temp2)


def diff(orig, chan, desc):
    print(f"{desc}:\n{orig} -> {chan}\n")
    
diff(numbers[0], change[0].swap_ends(), "Swap ends")
diff(numbers[1], change[1].shift(), "Shift")
diff(numbers[2], change[2].replace_even(), "Replace evens")
diff(numbers[3], change[3].replace_largest_neighbor(), "Replace current with largest neighbor")
diff(numbers[4], change[4].remove_middle(), "Remove middle")
diff(numbers[5], change[5].even_front(), "Evens to the front")
diff(numbers[6], change[6].second_largest(), "Second largest")
diff(numbers[7], change[7].is_sorted(), "Is the list sorted")
diff(numbers[8], change[8].dup_adjacent(), "Are there duplicates adjecent to eachother")
diff(numbers[9], change[9].dup_items(), "Are there duplicates")

gradeBook = {}

def menu(first: bool = False) -> bool:
    if first:
        print("Menu: \n\thelp: ?\n\tadd student: a\n\tremove student: r\n\tmodify grades: m\n\tprint all: p\n\tstop: s")
    res = input("> ")
    if res == "?":
        print("Menu: \n\thelp: ?\n\tadd student: a\n\tremove student: r\n\tmodify grades: m\n\tprint all: p\n\tstop: s")
        return True
    elif res == "a":
        name = input("Please enter the student name: ")
        grade = input(f"Please enter {name}s grade: ")
        gradeBook[name] = grade
        return True
    elif res == "r":
        name = input("What student would you like to remove: ")
        if gradeBook.get(name):
            gradeBook.pop(name)
        return True
    elif res == "m":
        name = input("What student would you like to edit: ")
        grade = input("Please enter the change: ")
        if gradeBook.get(name):
            gradeBook[name] = grade
        else:
            print(f"{name} was not found, would you like to add it? (y/n): ")
            res = input()
            if res == "y":
                gradeBook[name] = grade
        return True
    elif res == "p":
        for student, grade in gradeBook.items():
            print(f"{student}: {grade}\n")
        return True
    elif res == "s":
        return False
    else:
        print(f"{res} is not a recognized command. ? to see the menu")
        return True

cont = True
menu(True)
while cont:
    cont = menu()
    gradeBook = dict(sorted(gradeBook.items(), key = lambda kv:kv[0]))

