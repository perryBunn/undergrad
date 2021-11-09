// Perry Bunn
// ptb0010
// hw3_ptb0010.cpp
// This projects was so we could learn about do while loops and so I could show
//      the superiority of camelcase variable names.
// I had no help.

#include <iostream>
#include <stdlib.h>
#include <assert.h>
#include <ctime>

using namespace std;

bool atLeastTwoAlive(bool aAlive, bool bAlive, bool cAlive) {
    int i = 0;
    if (aAlive) {
        i++;
    }
    if (bAlive) {
        i++;
    }
    if (cAlive) {
        i++;
    }
    if (i > 1) {
        return true;
    }
    return false;
}

void aaronShoots1(bool &bAlive, bool &cAlive) {
    int shotResult = rand() % 100;
    if (shotResult <= 33) {
        if (cAlive) {
            cAlive = false;
        } else if (bAlive) {
            bAlive = false;
        }
    }
}

void bobShoots(bool &aAlive, bool &cAlive) {
    int shotResult = rand() % 100;
    if (shotResult <= 50) {
        if (cAlive) {
            cAlive = false;
        } else if (aAlive) {
            aAlive = false;
        }
    }
}

void charlieShoots(bool &aAlive, bool &bAlive) {
    int shotResult = rand() % 100;
    if (shotResult <= 101) {
        if (bAlive) {
            bAlive = false;
        } else if (aAlive) {
            aAlive = false;
        }
    }
}

void aaronShoots2(bool &bAlive, bool &cAlive) {
    int shotResult = rand() % 100;
    if (bAlive and cAlive) {
    } else {
        if (shotResult <= 33) {
            if (cAlive) {
                cAlive = false;
            } else if (bAlive) {
                bAlive = false;
            }
        }
    }
}

void testAtLeastTwoAlive() {
    cout << "Unit Testing 1: Function at_least_two_alive()\n";
    cout << "Case 1: Aaron alive, Bob alive, Charlie alive\n";
    assert(atLeastTwoAlive(true, true, true));
    cout << " Case passed...\n";
    cout << "Case 2: Aaron dead, Bob alive, Charlie alive\n";
    assert(atLeastTwoAlive(false, true, true));
    cout << " Case passed...\n";
    cout << "Case 3: Aaron alive, Bob dead, Charlie alive\n";
    assert(atLeastTwoAlive(true, false, true));
    cout << " Case passed...\n";
    cout << "Case 4: Aaron alive, Bob alive, Charlie dead\n";
    assert(atLeastTwoAlive(true, true, false));
    cout << " Case passed...\n";
    cout << "Case 5: Aaron dead, Bob dead, Charlie alive\n";
    assert(!atLeastTwoAlive(false, false, true));
    cout << " Case passed...\n";
    cout << "Case 6: Aaron alive, Bob dead, Charlie dead\n";
    assert(!atLeastTwoAlive(true, false, false));
    cout << " Case passed...\n";
    cout << "Case 7: Aaron dead, Bob alive, Charlie dead\n";
    assert(!atLeastTwoAlive(false, true, false));
    cout << " Case passed...\n";
    cout << "Case 8: Aaron dead, Bob dead, Charlie dead\n";
    assert(!atLeastTwoAlive(false, false, false));
    cout << " Case passed...\n";
    cout << "Press Enter to continue...";
    cin.get(); //Pause Command for Linux Terminal
}

void strat1() {
    cout << "Ready to test strategy 1 (run 10000 times):\n";
    cout << "Press Enter to continue...";
    cin.get(); //Pause Command for Linux Terminal
    int aWins = 0;
    int bWins = 0;
    int cWins = 0;
    for (int i = 0; i < 10000; ++i) {
        bool aaron = true;
        bool bob = true;
        bool charlie = true;
        do {
            if (aaron) {
                aaronShoots1(bob, charlie);
            }
            if (bob) {
                bobShoots(aaron, charlie);
            }
            if (charlie) {
                charlieShoots(aaron, bob);
            }
            if (!atLeastTwoAlive(aaron, bob, charlie)) {
                if (aaron) {
                    aWins++;
                } else if (bob) {
                    bWins++;
                } else {
                    cWins++;
                }
            }
        } while (atLeastTwoAlive(aaron, bob, charlie));
    }
    cout << "Aaron won " << aWins << "/10000 duels or " << aWins / 100.0 <<"%\n";
    cout << "Bob won " << bWins << "/10000 duels or " << bWins / 100.0 <<"%\n";
    cout << "Charlie won " << cWins << "/10000 duels or " << cWins / 100.0 <<"%\n";
}

void strat2() {
    cout << "Ready to test strategy 2 (run 10000 times):\n";
    cout << "Press Enter to continue...";
    cin.get(); //Pause Command for Linux Terminal
    int aWins = 0;
    int bWins = 0;
    int cWins = 0;
    for (int i = 0; i < 10000; ++i) {
        bool aaron = true;
        bool bob = true;
        bool charlie = true;
        do {
            if (aaron) {
                aaronShoots2(bob, charlie);
            }
            if (bob) {
                bobShoots(aaron, charlie);
            }
            if (charlie) {
                charlieShoots(aaron, bob);
            }
            if (!atLeastTwoAlive(aaron, bob, charlie)) {
                if (aaron) {
                    aWins++;
                } else if (bob) {
                    bWins++;
                } else {
                    cWins++;
                }
            }
        } while (atLeastTwoAlive(aaron, bob, charlie));
    }
    cout << "Aaron won " << aWins << "/10000 duels or " << aWins / 100.0 <<"%\n";
    cout << "Bob won " << bWins << "/10000 duels or " << bWins / 100.0 <<"%\n";
    cout << "Charlie won " << cWins << "/10000 duels or " << cWins / 100.0 <<"%\n";
}

int main() {
    srand(time(0));
    cout << "*** Welcome to the Duel Simulator ***\n";
    testAtLeastTwoAlive();
    strat1();
    cout << "\n";
    strat2();
    cout << "\nStrategy 2 is better than strategy 1.";
    return 0;
}