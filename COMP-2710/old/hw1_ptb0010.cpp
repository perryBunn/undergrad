// Perry Bunn
// ptb0010
// hw1_ptb0010.cpp
// The program calculates the fatal amount of diet coke
// I am a genius, I used stack exchange

#include <iostream>

using namespace std;

// fractionOfSweetnerInCoke = 0.001
// fatalAmountHuman = (fatalAmountMouse * humanWeight) / (mouseWeight * fractionOfSweetnerInCoke)

int main() {
    const double fractionOfSweetnerInCoke = 0.001;
    double fatalAmountHuman = 0, mouseWeight = 0, fatalAmountMouse = 0, humanWeight = 0;
    cout << "Please input the weight of the mouse in Kg.";
    cin >> mouseWeight;
    cout << "Please input the fatal amount of sweetener for the mouse in Kg.";
    cin >> fatalAmountMouse;
    cout << "Please input the weight of your dear friend in Kg.";
    cin >> humanWeight;

    fatalAmountHuman = (fatalAmountMouse * humanWeight) / (mouseWeight * fractionOfSweetnerInCoke);
    cout << "The fatal amount of Coke for you friend is " << fatalAmountHuman << "Kg";
    return 0;
}