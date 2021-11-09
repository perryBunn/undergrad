#include "parser.h"
#include "process.h"
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

parser::parser() {

}

queue<process> parser::readInputFile(string file) {
    queue<process> res;
    ifstream reader;
    reader.open(file);
    if (reader.is_open()) {
        int pid;
        int arrival;
        int burst;
        while (reader >> pid >> arrival >> burst) {
            process temp = process(pid, arrival, burst);
            res.push(temp);
        }
        reader.close();
    }
    return sort(res);
}

queue<process> parser::sort(queue<process> task_list) {
    int list_size = task_list.size();
    process temp[list_size];
    // convert to array
    for (int i = 0; i < list_size; ++i) {
        temp[i] = task_list.front();
        task_list.pop();
    }
    // sort
    for (int i = 0; i < list_size-1; ++i) {
        for (int j = 0; j < list_size-i-1; ++j) {
            process cur = temp[j];
            if (cur.arrival_time > temp[j+1].arrival_time) {
                temp[j] = temp[j+1];
                temp[j+1] = cur;
            }
        }
    }
    for (int i = 0; i < list_size; ++i) {
        task_list.push(temp[i]);
    }
    return task_list;
}
