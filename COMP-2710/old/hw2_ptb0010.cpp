// Perry Bunn
// ptb0010
// hw2_ptb0010.cpp
// Program that will tell you how many months it will take you to pay off this loan in particular and any loan in general.
// I did not receive any help

#include <iostream>
#include <iomanip>
#include <math.h>

using namespace std;

int main() {
    float loanIn;
    float interestIn;
    float paymentsIn;
    cout << "Loan Amount: ";
    cin >> loanIn;
    cout << "Interest Rate (% per year): ";
    cin >> interestIn;
    cout << "Monthly Payments: ";
    cin >> paymentsIn;

    cout << "******************************************************" << endl;
    cout << "\t\tAmortization Table" << endl;
    cout << "******************************************************" << endl;
    cout << "Month\tBalance\tPayment\tRate\tInterest\tPrincipal" << endl;
    int i = 0;
    float paid = 0, principal, rate = (interestIn / 100) / 12, interest, payment, balance = loanIn;

    while (balance != 0) {
        if (i != 0) {
            interest = balance * rate;
            payment = balance < paymentsIn ? balance + interest : paymentsIn;
            principal = payment - interest;
            if (principal < 0) {
                cout << "The monthly payment is too low for the interest rate entered.";
                exit(-1);
            }
            balance = balance - principal;
            paid += interest;
        } else {
            interest = 0;
            payment = 0;
            principal = 0;
            paid = 0;
        }
        cout << fixed << setprecision(2) << i << "\t$" << balance << "\t$" << payment << "\t" << rate * 100 << "\t$" << interest << "\t$" << principal << endl;
        if (balance != 0)
            i++;
    }

    cout << "******************************************************" << endl;
    cout << "It takes " << i << " months to pay off the loan." << endl;
    cout << "Total interest paid is: " << paid;

    return 0;
}