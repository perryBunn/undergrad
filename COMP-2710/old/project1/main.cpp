// Perry Bunn
// Project 1
// C++ Program to find factorial of a number and then the standard deviation of user input
// Help: Canvas
#include <iostream>
#include <cmath>

using namespace std;

float calculateSD(float data[], int number);

int main() {
    int i, n, factorial = 1;

    cout << "Enter a positive integer: ";
    cin >> n;

    for (i = 1; i <= n; ++i) {
        factorial *= i;   // factorial = factorial * i;
    }

    cout<< "Factorial of "<<n<<" = "<<factorial;
    cout<<endl;

    int j;
    float data[n];

    cout << "Enter "<<n<<" elements: ";
    for(j = 0; j < n; ++j)
        cin >> data[j];

    cout << endl << "Standard Deviation = " << calculateSD(data, n);

}

float calculateSD(float data[], int number) {
    float sum = 0.0, mean = 0.0, standardDeviation = 0.0;

    int i;

    for(i = 0; i < number; ++i)
    {
        sum += data[i];
    }

    mean = sum/number;

    for(i = 0; i < number; ++i)
        standardDeviation += pow(data[i] - mean, 2);

    return sqrt(standardDeviation / 10);
}

