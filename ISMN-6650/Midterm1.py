# Program 1
def paycheck(name="empty", hours=0, dev=False):
    """ Returns the compensation for an employee
    
    Arguments:
    name -- the name of the employee (default "empty")
    hours -- the number of hours worked (default 0)
    dev -- if the run occurence is a dev test (default False)
    """
    salary = 9.25
    if not dev:
        name = input("Please enter the employee name: ")
        hours = float(input(f"Please enter how many hours {name} worked: "))
    pay = 0
    if hours < 0:
        print("Employees can not work negative hours.")
        return
    if hours <= 40:
        pay += salary * hours
    else:
        overtime = hours - 40
        pay += salary * hours
        pay += (salary * 1.50) * overtime
    print(f"Employee: {name}")
    print(f"The pay will be ${pay:.2f} for {hours:.2f} hours of work.")
    
# Used for testing edge cases.
# paycheck("devTest", -15, True)
# paycheck("devTest", 0, True)
# paycheck("devTest", 39, True)
# paycheck("devTest", 40, True)
# paycheck("devTest", 41, True)
# paycheck("devTest", 41.25, True)
paycheck()

# Program 2
capacity = 100
full = False
occupants = 0
while not full:
    group = int(input("How large is the group? "))
    if capacity < (occupants + group):
        print("The group is too large to enter.")
        continue
    occupants += group
    if occupants < 0:
        occupants = 0
    
    print(f"occupants: {occupants}")
    if occupants == capacity:
        print("The bar is full.")
        full = True

# Program 2 - Editied
# You need to control the number of people who can be in an oyster bar at the same time. 
# Groups of people can always leave the bar, but a group cannot enter the bar if they would 
# make the number of people in the bar exceed the maximum of 100 occupants. Write a program 
# that reads the sizes of the groups that arrive or depart. Use negative numbers for 
# departures. After each input, display the current number of occupants. if the group exceeds 
# the capacity then add the group to a queue to be added later. When "close" is entered stop 
# the program and print the number of occupants and number of groups and then total number in 
# queue.

capacity = 100
full = False
occupants = 0
bar_queue = []
group = ""

def total(list):
    """Returns the total number of people from the queue"""
    total = 0
    for i in range(len(list)):
        total += list[i]
    return total


def fillSpace(vacancy, index=0):
    """Returns the number of spaces available after going through the list
    Arguments:
    vacancy -- number of spaces to be filled
    index -- index to start at in the queue (default 0)
    """
    global bar_queue
    index = 0
    space = 0
    while index < len(bar_queue):
        if space + bar_queue[index] > vacancy:
            index += 1
            continue
        space += bar_queue.pop(index)
    return space


while not group == "close":
    if not full:
        if len(bar_queue) > 0:
            add = fillSpace((capacity - occupants))
            if add > 0:
                occupants += add
                print(f"Group(s) from queue entered. Occupancy is {occupants} of {capacity}")
    group = input("How large is the group? ")
    if group == "close":
        print("The bar is closing.")
        print(f"occupants: {occupants}")
        print(f"queue: number of groups: {len(bar_queue)} \t number of people in queue: {total(bar_queue)}")
        continue
    group = int(group)

    if capacity < (occupants + group):
        print("The group is too large to enter. Adding to queue...")
        bar_queue.append(group)
    else:
        occupants += group

    if occupants < 0:
        occupants = 0
    print(f"occupants: {occupants} of {capacity}")
    if occupants == capacity:
        full = True
    if full and occupants < capacity:
        full = False
        if len(bar_queue) > 0:
            occupants += fillSpace((capacity - occupants))
            print(f"Group(s) from queue entered. Occupancy is {occupants} of {capacity}")



