// Perry Bunn
// ptb0010
// hw5_ptb0010.cpp
// Description
// Help

#include <iostream>
#include <cassert>

using namespace std;

class String : public string {
public:
    String toLower();
    bool isEqual(const string& str);
};

String String::toLower() {
    String compiled;
    locale loc;
    for (auto s : *this) {
        compiled += tolower(s, loc);
    }
    return compiled;
}

bool String::isEqual(const string& str) {
    return (string) *this == str;
}

template<class T>
class Node {
public:
    T data1;
    T data2;
    int weight;

    struct Node<T> *next;
    struct Node<T> *prev;


    Node<T>(T data1In, T data2In, int weightIn) {
        data1 = data1In;
        data2 = data2In;
        weight = weightIn;
        next = nullptr;
        prev = nullptr;
    }

    Node<T>(T data1In, T data2In, int weightIn, Node *prevIn) {
        data1 = data1In;
        data2 = data2In;
        weight = weightIn;
        next = nullptr;
        prev = prevIn;
    }

    Node<T>(T data1In, T data2In, int weightIn, Node *nextIn, Node *prevIn) {
        data1 = data1In;
        data2 = data2In;
        weight = weightIn;
        next = nextIn;
        prev = prevIn;
    }

    T getData1();
    T getData2();
    int getWeight();
};

template<class T>
T Node<T>::getData1() {
    return this->data1;
}

template<class T>
T Node<T>::getData2() {
    return this->data2;
}

template<class T>
int Node<T>::getWeight() {
    return this->weight;
}

template<class T>
class LinkedList {
public:
    Node<T> *head, *tail;

    LinkedList<T>() = default;;

    LinkedList<T>(Node<T> *headIn) {
        head = headIn;
        tail = headIn;
    }

    LinkedList<T>(Node<T> headIn, Node<T> tailIn) {
        head = &headIn;
        tail = &tailIn;
    }

    bool isEmpty();
    void push(Node<T> node);
    void insert(int index, Node<T> node);
    void append(Node<T> *node);
    void remove(T data);
    int size();
    bool testQuestions(int numberOfQuestions);
    bool testQuestions(int indexOfQuestion, string testResponse);
};

template<class T>
bool LinkedList<T>::isEmpty() {
    return this.*head == NULL && this.*tail == NULL;
}

template<class T>
void LinkedList<T>::push(Node<T> node){
    head->prev = node;
    node.next = head;
    this->head = node;
}

template<class T>
void LinkedList<T>::insert(int index, Node<T> node){
    if (index == 0) {
        append(node);
        return;
    }
    Node<T> *current = head;
    for (int i = 0; i < index; i++) {
        if (i == index-1) {
            node.prev = current;
            node.next = current->next;
            current->next->prev = node;
            current->next = node;
            return;
        }
        current = current->next;
    }
}

template<class T>
void LinkedList<T>::append(Node<T> *node) {
    if (this->size() == 0) {
        this->head = node;
        return;
    }
    if (this->size() == 1) {
        this->tail = node;
        this->head->next = node;
        return;
    }
    this->tail->next = node;
    node->prev = this->tail;
    this->tail = node;
}

template<class T>
void LinkedList<T>::remove(T data) {
    Node<T> *current = head;
    while (current->data != data) {
        if (current == tail) {
            return;
        }
        current = current->next;
    }
    current->prev->next = current->next;
    current->next->prev = current->prev;
    delete current;
}

template<class T>
int LinkedList<T>::size() {
    int count = 0;
    Node<T> *current = head;
    while (current != NULL) {
        count++;
        current = current->next;
    }
    return count;
}

template<class T>
bool LinkedList<T>::testQuestions(int numberOfQuestions) {
    if (numberOfQuestions <= 0) {
        cout << "Warning - The number of trivia wo be asked bust be equal to or larger than 1";
        return false;
    }
    for (int i = 0; i < this->size(); i++) {

    }
    return true;
}

template<class T>
bool LinkedList<T>::testQuestions(int indexOfQuestion, string testResponse) {
    return false;
}

// Initialized the linked list for the program.
void init(LinkedList<string> *list) {

    Node<string> *question1 = new Node<string>("How long was the shortest war on record?", "38", 100);
    Node<string> *question2 = new Node<string>("What was the Bank of America's original name? (Hint: Bank of Italy or Bank of Germany)", "Bank of Italy", 50);
    Node<string> *question3 = new Node<string>("What is the best-selling video game of all time? (Hint: Minecraft or Tetris)", "Tetris", 20);

    list->append(question1);
    list->append(question2);
    list->append(question3);
}

// Creates new questions to be added to the linked list
void newQuestions(LinkedList<string> listIn) {
    LinkedList<string> *list = &listIn;
    bool playerConsent = true;
    while (playerConsent) {
        string question;
        string answer;
        int weight;

        cout << "Enter a question: ";
        cin >> question;
        cout << "Enter an answer: ";
        cin >> answer;
        cout << "Enter award points: ";
        cin >> weight;

        Node<string> *nodeQuest = new Node<string>(question, answer, weight);
        list->append(nodeQuest);

        repeat: cout << "Continue? (Yes/No): ";
        String response;
        cin >> response;
        response = response.toLower();
        if (response == "no") {
            playerConsent = false;
            cout << "\n";
        } else if (response != "yes") {
            goto repeat;
        }
    }
}

// Iterates through the linked list checking if the correct responses have been made
void askQuestions(LinkedList<string> listIn, int number) {
    LinkedList<string> *list = &listIn;
    if (number > list->size()){
        cout << "Warning - There are only three trivia in the list.\n\n";
        return;
    }
    bool playerConsent = true;
    Node<string> *current = list->head;
    if (current == nullptr) {
        cout << "Warning - The number of trivia to be asked must equal to or larger than 1.\n\n";
        return;
    }
    int points = 0;
    cin.ignore();
    cin.sync();
    while (playerConsent) {
        String qResponse;
        cout << "Question: " + current->data1 +"\n";
        cout << "Answer: ";
        getline(cin, qResponse);
        if (qResponse.isEqual(current->data2)) {
            cout << "Your answer is correct. You recieve " + to_string(current->weight) + " points.\n";
            points += current->weight;
            cout << "Your Total points: " + to_string(points) +"\n\n";
        } else {
            cout << "Your answer is wrong. The correct answer is: " + current->data2 +"\n";
            cout << "Your Total points: " + to_string(points) +"\n\n";
        }

        if (current->next == nullptr) {
            playerConsent = false;
            return;
        }
        current = current->next;
    }
}

// Test inti() for correct values.
void unitTestingDriver() {
    cout << "*** This is a debug version ***\n";
    // call init
    LinkedList<string> list = LinkedList<string>();
    cout << "Unit Test Case 1: Ask no questions. The program should give a warning message.\n";
    // test
    askQuestions(list, 1);

    init(&list);
    Node<string> *current = list.head;
    cout << "Unit Test Case 2.1: Ask 1 question in the linked list. The tester enters the incorrect answer.\n";
    // test
    cout << "Question: " + current->data1 +"\n";
    cout << "Answer: ";
    String qResponse;
    getline(cin, qResponse);
    assert(!qResponse.isEqual(current->data2));
    cout << "Case 2.1 passed...\n";

    current = current->next->next;
    cout << "\nUnit Test Case 2.2: Ask 1 question in the linked list. The tester enters the correct answer.\n";
    // test
    cout << "Question: " + current->data1 +"\n";
    cout << "Answer: ";
    String qResponse2;
    getline(cin, qResponse2);
    assert(qResponse2.isEqual(current->data2));
    cout << "Case 2.2 passed...\n";

    current = list.tail;
    cout << "\nUnit Test Case 3: Ask the last trivia in the linked list.\n";
    // test
    cout << "Question: " + current->data1 +"\n";
    cout << "Answer: ";
    String qResponse3;
    getline(cin, qResponse3);
    assert(qResponse3.isEqual(current->data2));

    cout << "\nUnit Test Case 4: Ask five questions in the linked list.\n";
    // test
    askQuestions(list, 5);
    /* I did not design my code this way. In the description of the project it never said to specifically call a question
     * or certain number of them. The way the code is written is to iterate until a nullptr for the next variable.
     * Also the response we are to give indicates that the line is hard coded anyway; but using the word "three" instead
     * of calling the size() and concatenating the number; I think doing so is bad coding practice (despite the way that ive written
     * my test cases but I wouldnt really call this testing) but I wrote my code is such a way that it shouldnt fail in
     * the ways that we are testing.
     */

    cout << "*** End of the Debug Version ***";
}

// #define UNIT_TESTING = true;

#ifdef UNIT_TESTING
int main() {
    unitTestingDriver();
    return 0;
}
#else
int main() {
    LinkedList<string> triviaList = LinkedList<string>();
    init(&triviaList);
    cout << "*** Welcome to Perry's trivia quiz game ***\n";
    newQuestions(triviaList);
    askQuestions(triviaList, 1);
    cout << "*** Thank you for playing the trivia quiz game. Goodbye!";
    return 0;
}
#endif