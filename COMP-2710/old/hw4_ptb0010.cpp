// Perry Bunn
// ptb0010
// hw4_ptb0010.cpp
// program that merges the numbers in two files and writes all the numbers into a
// third file. Your program takes input from two different files and writes its output to a
// third file. Each input file contains a list of numbers of type int in sorted order from the
// smallest to the largest. After the program is run, the output file will contain all the
// numbers in the two input files in one longer list in sorted order from smallest to largest.
// Help: http://www.cplusplus.com/doc/tutorial/

#include <fstream>
#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

const int MAX_SIZE = 100;

// returns the size of the file "array" and inputs the contents of teh file into a blank array.
int readFileSize(int inputArray[], ifstream &instream) {
    int index = 0;
    for (string line; getline(instream, line); index++) {
        inputArray[index] = stoi(line);
    }
    return index;
}

// slave sort method
void heapify(int arr[], int n, int root) {
    int largest = root;
    int left = 2 * root + 1;
    int right = 2 * root + 2;

    if (left < n && arr[left] > arr[largest]) {
        largest = left;
    }
    if (right < n && arr[right] > arr[largest]) {
        largest = right;
    }
    if (largest != root) {
        swap(arr[root], arr[largest]);
        heapify(arr, n, largest);
    }
}

// main sort function
void heapSort(int arr[], int size) {
    for (int i = size / 2 - 1; i >= 0; i--) {
        heapify(arr, size, i);
    }
    for (int index = size - 1; index >= 0; index--) {
        swap(arr[0], arr[index]);
        heapify(arr, index, 0);
    }
}


// merges two arrays
void merge(int arr[], int arrSize, int arr2[], int arr2Size, int output[]) {
    for (int i = 0; i < arrSize; ++i) {
        output[i] = arr[i];
    }
    for (int j = arrSize; j < arrSize + arr2Size; ++j) {
        output[j] = arr2[j - arrSize];
    }
}

// Host method for the array merge and sort
int sort(int inputArray1[], int inputArray1_size, int inputArray2[],
        int inputArray2_size, int outputArray[]) {
    merge(inputArray1, inputArray1_size, inputArray2, inputArray2_size, outputArray);
    int merIndex = inputArray1_size + inputArray2_size;
    heapSort(outputArray, merIndex);
    return inputArray1_size + inputArray2_size;
}

// prints an array vertically
void print(int arr[], int arrSize) {
    for (int i = 0; i < arrSize; ++i) {
        if (i == arrSize - 1) {
            cout << arr[i] << "\n\n";
        } else {
            cout << arr[i] << "\n";
        }
    }
}


// prints am array horizontally
void print(int arr[], int arrSize, bool inLine) {
    if (inLine) {
        for (int i = 0; i < arrSize; ++i) {
            if (i == arrSize - 1) {
                cout << arr[i] << "\n";
            } else {
                cout << arr[i] << " ";
            }
        }
    }
}

// writes and array to a file (no option to change filename)
void writefile(int outputArray[], int outArraySize) {
    ofstream outputFile("output.txt");
    for (int i = 0; i < outArraySize; ++i) {
        outputFile << outputArray[i] << "\n";
    }
    outputFile.close();
}

int main() {
    // Gen variable declarations
    string fileName1;
    ifstream inStream1;
    ifstream inStream2;
    int array1[MAX_SIZE];
    int index1;
    string fileName2;
    int array2[MAX_SIZE];
    int index2;

    // Begin
    cout << "*** Welcome to Perry Bunn's sorting program ***\n";
    cout << "Enter the first input file name:\t";
    cin >> fileName1;

    // read in array 1
    inStream1.open(fileName1);
    index1 = readFileSize(array1, inStream1);
    inStream1.close();

    cout << "The list of " << index1 << " numbers in file " << fileName1 << " is: " << "\n";
    print(array1, index1);

    cout << "Enter the second input file name:\t";
    cin >> fileName2;

    // read in array 2
    inStream2.open(fileName2);
    index2 = readFileSize(array2, inStream2);
    inStream2.close();

    cout << "The list of " << index2 << " numbers in file " << fileName2 << " is: " << "\n";
    print(array2, index2);

    // merge and sort of array 1 and 2
    int sortedArray[index1 + index2];
    int indexS = sort(array1, index1, array2, index2, sortedArray);

    cout << "The sorted list of " << indexS << " numbers is: ";
    print(sortedArray, indexS, true);

    // Console has finished print, output file creation/write begin
    writefile(sortedArray, indexS);
    return 0;
}
