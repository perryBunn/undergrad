import math
import random
import time
import matplotlib.pyplot as plt
from typing import List


names = ["algorithm-1", "algorithm-2", "algorithm-3", "algorithm-4"]


def algorithm_1(array: List[int]):
    max_so_far = 0
    for L in range(len(array)):
        for U in range(L, len(array)):
            number_sum = 0
            for i in range(L, U):
                number_sum = number_sum + array[i]
            max_so_far = max(max_so_far, number_sum)
    return max_so_far


def algorithm_2(array: List[int]):
    max_so_far = 0
    for L in range(len(array)):
        number_sum = 0
        for U in range(L, len(array)):
            number_sum = number_sum + array[U]
            max_so_far = max(max_so_far, number_sum)
    return max_so_far


def max_sum(array: List[int], k, u: int):
    if k > u:
        return 0
    if k == u:
        return max(0, array[k])
    m = math.floor((k + u) / 2)
    number_sum = 0
    max_to_left = 0
    for i in range(m, k, -1):
        number_sum = number_sum + array[i]
        max_to_left = max(max_to_left, number_sum)

    number_sum = 0
    max_to_right = 0
    for i in range(m+1, u):
        number_sum = number_sum + array[i]
        max_to_right = max(max_to_right, number_sum)

    max_crossing = max_to_left + max_to_right
    max_in_a = max_sum(array, k, m)
    max_in_b = max_sum(array, m + 1, u)
    return max(max_crossing, max_in_a, max_in_b)


def algorithm_4(array: List[int]):
    max_so_far = 0
    max_ending_here = 0
    for i in range(len(array)):
        max_ending_here = max(0, max_ending_here + array[i])
        max_so_far = max(max_so_far, max_ending_here)
    return max_so_far


def read_input_file():
    """ Reads in the input file and then calls console_out to then print the results from
    running the file input in the above algorithms
    """
    numbers = []
    with open('phw_input.txt', 'r') as reader:
        strings = reader.read().split(",")
        for i in range(len(strings)):
            numbers.append(int(strings[i]))
    console_out(numbers)


def console_out(numbers: List[int]):
    """ Takes in a list of ints and then will print the results of the list when run through the above algos"""
    results = []
    results.append(algorithm_1(numbers))
    results.append(algorithm_2(numbers))
    results.append(max_sum(numbers, 0, len(numbers)-1))
    results.append(algorithm_4(numbers))

    for i in range(len(names)):
        print(names[i] + ": " + str(results[i]) + ";", end=" ")


def driver():
    """ Driver program
    Section 1: Completes the first requirement of the project by taking in a
    input file and then printing those results to the console.

    Section 2: Creation of helper list and variables

    Section 3: Iterates through the list size 10-100, some predetermined about of times,
    and stores those results in the variable results

    Section 4: Prints the indices from results to the console and to a file.

    Section 5: Creates the graphs
    """
    # Section 1
    read_input_file()

    # Section 2
    container = []
    for i in range(19):
        temp = []
        for j in range(10 + (i*5)):
            temp.append(random.randint(-100, 100))
        container.append(temp)

    results = [[], [], [], [], [], [], [], []]
    print("")
    runs = 300
    divisor_run = 1000000000
    divisor_theory = 1000000
    # Section 3
    time_start_total = time.time_ns()
    for i in range(len(container)):
        time_start = time.time_ns()
        for j in range(runs):
            algorithm_1(container[i])
        time_end = time.time_ns()
        results[0].append((time_end - time_start) / divisor_run)
        n = len(container[i])
        results[4].append((3*(n**3) + 5*(n**2) + 6*n + 4) / divisor_theory)
    print("Made it past the first")
    for i in range(len(container)):
        time_start = time.time_ns()
        for j in range(runs):
            algorithm_2(container[i])
        time_end = time.time_ns()
        results[1].append((time_end - time_start) / divisor_run)
        n = len(container[i])
        results[5].append(1.5*(15*(n**2) + 8*n + 16) / divisor_theory)
    print("Past the second")
    for i in range(len(container)):
        time_start = time.time_ns()
        for j in range(runs):
            max_sum(container[i], 0, (len(container[i])-1))
        time_end = time.time_ns()
        results[2].append((time_end - time_start) / divisor_run)
        n = len(container[i])
        results[6].append((2*(n/2)+14*n+42) / 10000)
    print("Made it past the third")
    for i in range(len(container)):
        time_start = time.time_ns()
        for j in range(runs):
            algorithm_4(container[i])
        time_end = time.time_ns()
        results[3].append((time_end - time_start) / divisor_run)
        n = len(container[i])
        results[7].append((17*n + 12) / 100000)
    time_end_total = time.time_ns()

    # Section 4
    for i in range(len(results[0])):
        print(results[0][i], results[1][i], results[2][i], results[3][i],
              results[4][i], results[5][i], results[6][i], results[7][i])

    with open('perrybunn_phw_output.txt', 'w') as file:
        for i in range(len(results[0])):
            file.write(f'{results[0][i]}, {results[1][i]}, {results[2][i]}, {results[3][i]}, ' +
                       f'{results[4][i]}, {results[5][i]}, {results[6][i]}, {results[7][i]}\n')
        file.close()

    # Section 5
    run_size = []
    for i in range(19):
        run_size.append(5*(2+i))

    for i in range(len(results)-4):
        plt.plot(run_size, results[i], label='Experimental')
        plt.plot(run_size, results[i+4], label='Theoretical')
        plt.title(names[i])
        plt.ylabel('seconds')
        plt.xlabel('n')
        plt.legend(loc='upper left')
        plt.savefig(f'{names[i]}-graph.png')
        plt.show()

    number_sum = 0
    for i in range(len(results)-4):
        for j in range(len(results[i])):
            number_sum += results[i][j]
    print((time_end_total - time_start_total) / 1000000000, number_sum)


if __name__ == '__main__':
    driver()
