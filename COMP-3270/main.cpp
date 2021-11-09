#include <iostream>
#include <string>
#include <fstream>
#include <chrono>
#include <cmath>

using namespace std;

int Algorithm1(int X[]){
    int maxSoFar = 0;
    for(int i = 0; i < sizeof(X); i++){
        for(int j = i; j < sizeof(X);j++){
            int sum = 0;
            for(int k = i; k < j; k++){
                sum = sum + X[k];
            }
            maxSoFar = max(maxSoFar,sum);
        }
    }
    return maxSoFar;
}

int Algorithm2(int X[]){
    int maxSoFar = 0;
    for(int i = 0; i < sizeof(X); i++){
        int sum = 0;
        for(int j = i; j < sizeof(X); j++){
            sum = sum + X[j];
            maxSoFar = max(maxSoFar,sum);
        }
    }
    return maxSoFar;
}

int Algorithm3(int X[],int L, int U){
    if(L > U){
        return 0;
    }
    if(L==U){
        return max(0,X[L]);
    }
    int M = (L+U)/2;
    int sum = 0;
    int maxToLeft = 0;
    for(int I = M; I > L; I--){
        sum = sum+ X[I];
        maxToLeft = max(maxToLeft,sum);
    }
    sum = 0;
    int maxToRight = 0;
    for (int I = M+1; I < U; I++){
        sum = sum+X[I];
        maxToRight = max(maxToRight,sum);
    }
    int maxCrossing = maxToLeft + maxToRight;
    int maxInA = Algorithm3(X,L,M);
    int maxInB = Algorithm3(X,M+1,U);
    int maxOfAB = max(maxInA,maxInB);
    return max(maxCrossing, maxOfAB);
}

int Algorithm4(int X[]){
    int maxSoFar = 0;
    int maxEndingHere = 0;
    for(int i = 0; i < sizeof(X); i++){
        maxEndingHere = max(0,maxEndingHere+X[i]);
        maxSoFar = max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
}

int main() {
//    First, the main program should read from a file named “phw_input.txt” containing 10 comma-delimited integers in the first line,create an array containing these 10 integers, and run each of the algorithms on that input array, and print out the answer produced by each on the console as follows:"algorithm-1: <answer>; algorithm-2:<answer>;algorithm-3:<answer>; algorithm-4:<answer> where <answer> is the MSCS as determined by each of the algorithms.

    int tenIntegers[10];
    fstream file;
    file.open("phw_input.txt", ifstream::in);
    string temp;
    for(int i = 0; i < 10; i++ ){
        getline(file, temp,',');
        tenIntegers[i] = (int)stoi(temp);
    }
    file.close();

//    call algos here

    cout << "algorithm-1: " << Algorithm1(tenIntegers) << ", ";
    cout << "algorithm-2: " << Algorithm2(tenIntegers) << ", ";
    cout << "algorithm-3: " << Algorithm3(tenIntegers,0,9) << ", ";
    cout << "algorithm-4: " << Algorithm4(tenIntegers) << "\n";

//    Next,create 19 integer sequences of length10,15,20,25,......90,95,100, containing randomly generated negative, zero and positive integers, and store these in 19arrays of size 10,15,...,95,100

    int array10[10];
    for (int i = 0; i < 10; ++i) {
        array10[i] = rand() % 100 + (-50);
    }
    int array15[15];
    for (int i = 0; i < 15; ++i) {
        array15[i] = rand() % 100 + (-50);
    }
    int array20[20];
    for (int i = 0; i < 20; ++i) {
        array20[i] = rand() % 100 + (-50);
    }
    int array25[25];
    for (int i = 0; i < 25; ++i) {
        array25[i] = rand() % 100 + (-50);
    }
    int array30[30];
    for (int i = 0; i < 30; ++i) {
        array30[i] = rand() % 100 + (-50);
    }
    int array35[35];
    for (int i = 0; i < 35; ++i) {
        array35[i] = rand() % 100 + (-50);
    }
    int array40[40];
    for (int i = 0; i < 40; ++i) {
        array40[i] = rand() % 100 + (-50);
    }
    int array45[45];
    for (int i = 0; i < 45; ++i) {
        array45[i] = rand() % 100 + (-50);
    }
    int array50[50];
    for (int i = 0; i < 50; ++i) {
        array50[i] = rand() % 100 + (-50);
    }
    int array55[55];
    for (int i = 0; i < 55; ++i) {
        array55[i] = rand() % 100 + (-50);
    }
    int array60[60];
    for (int i = 0; i < 60; ++i) {
        array60[i] = rand() % 100 + (-50);
    }
    int array65[65];
    for (int i = 0; i < 65; ++i) {
        array65[i] = rand() % 100 + (-50);
    }
    int array70[70];
    for (int i = 0; i < 70; ++i) {
        array70[i] = rand() % 100 + (-50);
    }
    int array75[75];
    for (int i = 0; i < 75; ++i) {
        array75[i] = rand() % 100 + (-50);
    }
    int array80[80];
    for (int i = 0; i < 80; ++i) {
        array80[i] = rand() % 100 + (-50);
    }
    int array85[85];
    for (int i = 0; i < 85; ++i) {
        array85[i] = rand() % 100 + (-50);
    }
    int array90[90];
    for (int i = 0; i < 90; ++i) {
        array90[i] = rand() % 100 + (-50);
    }
    int array95[95];
    for (int i = 0; i < 95; ++i) {
        array95[i] = rand() % 100 + (-50);
    }
    int array100[100];
    for (int i = 0; i < 100; ++i) {
        array100[i] = rand() % 100 + (-50);
    }

     int* container[19] = {array10,
                       array15,
                       array20,
                       array25,
                       array30,
                       array35,
                       array40,
                       array45,
                       array50,
                       array55,
                       array60,
                       array65,
                       array70,
                       array75,
                       array80,
                       array85,
                       array90,
                       array95,
                       array100};

//    Then use the system clock to measure time t1, run one of the four algorithms on array Ai(starting with i=1)N times (where N is at least100, but if your system clock does not have a good resolution you may need N to be larger, like 500 or 1000in order to get meaningful running times), then measure time t2, and compute average time needed by that algorithm to solve the problem with input size = size of Ai. Do this for each of the algorithms executing on each of the 19input arrays to fill the first four columns of a19X8matrix of integers with average execution times.Each row of this matrix corresponds to one input size, from 10-100.

    // 1-19:0-3 real time of above arrays

    double times[19][8];

    for (int j = 0; j < 19; ++j) {
        double timeAVG = 0;
        for (int i = 0; i < 10000; ++i) {
            auto start = chrono::high_resolution_clock::now();
            Algorithm1(container[j]);
            auto finish = chrono::high_resolution_clock::now();
            timeAVG += chrono::duration_cast<chrono::nanoseconds>(finish-start).count();
        }
        times[j][0] = timeAVG/10000;
        times[j][4] = (double)ceil(pow(sizeof(container[j]),3)*10000);
    }

    for (int j = 0; j < 19; ++j) {
        double timeAVG = 0;
        for (int i = 0; i < 10000; ++i) {
            auto start = chrono::high_resolution_clock::now();
            Algorithm2(container[j]);
            auto finish = chrono::high_resolution_clock::now();
            timeAVG += chrono::duration_cast<chrono::nanoseconds>(finish-start).count();
        }
        times[j][1] = timeAVG/10000;
        times[j][5] = (double)ceil(pow(sizeof(container[j]),2)*10000);
    }

    for (int j = 0; j < 19; ++j) {
        double timeAVG = 0;
        for (int i = 0; i < 10000; ++i) {
            auto start = chrono::high_resolution_clock::now();
            Algorithm3(container[j],0,sizeof(container[j])-1);
            auto finish = chrono::high_resolution_clock::now();
            timeAVG += chrono::duration_cast<chrono::nanoseconds>(finish-start).count();
        }
//        ceil(length * log(length) / log(2))) * 1000;
        times[j][2] = timeAVG/10000;
        times[j][6] = (double)ceil(sizeof(container[j]) * log(sizeof(container[j])) / log(2)) * 10000;
    }

    for (int j = 0; j < 19; ++j) {
        double timeAVG = 0;
        for (int i = 0; i < 10000; ++i) {
            auto start = chrono::high_resolution_clock::now();
            Algorithm4(container[j]);
            auto finish = chrono::high_resolution_clock::now();
            timeAVG += chrono::duration_cast<chrono::nanoseconds>(finish-start).count();
        }
        times[j][3] = timeAVG/10000;
        times[j][7] = (double)ceil(sizeof(container[j])*10000);
    }

//    Fill the last four columns of this matrix with values ceiling(T1(n)), ceiling(T2(n)), ceiling(T3(n)),and ceiling(T4(n)) where n=each input size and T(n) are the polynomials representing the theoretically calculated complexity of the three algorithms that you determined in step 2part (b). So,column 1 will have measured running times of your first algorithm and column 5will have the calculated complexity for the same algorithm; similarly for columns 2 & 6, 3 & 7, and 4&8.You may need to scale the complexity values (or use an appropriate time unit such as nano/micro/milli seconds for the measured running times) in order to bring all data into similar ranges.

    // 1-19:4-7 theoretical times

//    Your main program should write one text line of algorithm and complexity order titles separated by commas (e.g., "algorithm-1,algorithm-2,algorithm-3,algorithm-4,T1(n),T2(n),T3(n),T4(n)"), followed by the above matrix also in comma-delimited format (19lines of 8integers separated by commas) to a file called "yourname_phw_output.txt".

    fstream fileOut;
    fileOut.open("perrybunn_phw_output.txt", ifstream::out);

    fileOut << "algorithm-1, algorithm-2, algorithm-3, algorithm-4, T1(n), T2(n), T3(n), T4(n)\n";
    cout << "algorithm-1, algorithm-2, algorithm-3, algorithm-4, T1(n), T2(n), T3(n), T4(n)\n";

    for (int i = 0; i < 19; ++i) {
        for (int j = 0; j < 8; ++j) {
            if (j!=7){
                fileOut << times[i][j] << ", ";
                cout << times[i][j] << ", ";
            } else {
                fileOut << times[i][j] << "\n";
                cout << times[i][j] << "\n";
            }
        }
    }

    fileOut.close();

    return 0;
}
