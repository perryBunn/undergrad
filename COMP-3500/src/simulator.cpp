#include "simulator.h"
#include "process.h"
#include <queue>
#include <iostream>
#include <chrono>

using namespace std;

simulator::simulator() = default;

void simulator::fcfs(queue<process> &task_list, queue<process> &finish_task_list) {
    time = 0;
    process active_task;
    while (!task_list.empty() or !this->ready_queue.empty()) {
        while (task_list.front().arrival_time == time) {
            this->ready_queue.push(task_list.front());
            task_list.pop();
        }
        if (this->ready_queue.empty() and time >= 0) {
            cout << "<time " << time << "> " <<  "no process is running" << endl;
            time++;
            continue;
        }
        if (active_task.pid == "-1") {
            active_task = this->ready_queue.front();
        }
        if (active_task.remaining_time == 0) {
            active_task.finish_time = time;
            cout << "<time " << time << "> " << active_task.pid << " is finished..." << endl;
            this->ready_queue.pop();
            finish_task_list.push(active_task);
            if (task_list.empty() and this->ready_queue.empty()) {
                break;
            }
            active_task = this->ready_queue.front();
        }
        if (active_task.remaining_time == active_task.burst_time) {
            active_task.start_time = time; /* run active_task */
        }
        cout << "<time " << time << "> " << active_task.pid << " is running" << endl;
        active_task.remaining_time--;
        time++;
    } /* end while */
    cout << "<time " << time << "> " << "All processes finished ......" << endl;
}

void simulator::srft(queue <process> &task_list, queue <process> &finish_task_list) {
    time = 0;
    process active_task;
    while (!task_list.empty() or !this->ready_queue.empty()) {
        while (task_list.front().arrival_time == time) {
            this->ready_queue.push(task_list.front());
            task_list.pop();
            this->srft_sort();
        }
        if (this->ready_queue.empty() and time >= 0) {
            cout << "<time " << time << "> " <<  "no process is running" << endl;
            time++;
            continue;
        }
        if (active_task.pid == "-1") {
            active_task = this->ready_queue.front();
        }
        if (active_task.remaining_time == 0) {
            active_task.finish_time = time;
            cout << "<time " << time << "> " << active_task.pid << " is finished..." << endl;
            this->pop_active_process(active_task);
            finish_task_list.push(active_task);
            if (task_list.empty() and this->ready_queue.empty()) {
                break;
            }
            active_task = this->ready_queue.front();
        }
        if (active_task.remaining_time == active_task.burst_time) {
            active_task.start_time = time; /* run active_task */
        }
        cout << "<time " << time << "> " << active_task.pid << " is running" << endl;
        active_task.remaining_time--; /* check if active_task finishes or not */
        time++;
        //break;
    }
    cout << "<time " << time << "> " << "All processes finished ......" << endl;
}

void simulator::pop_active_process(process &active){
    queue<process> temp = this->ready_queue;
    int list_size = this->ready_queue.size();

    // clear ready_queue
    for (int i = 0; i < list_size; i++) {
        //cout << ready_queue.front().pid << endl;
        this->ready_queue.pop();
    }
    //cout << "----" << endl;
    // readd ready queue without active
    for (int i = 0; i < list_size; i++) {
        if (!(temp.front().equals(active))) {
            //cout << "### info ###" << endl;
            //cout << temp.front().pid << active.pid << endl;
            this->ready_queue.push(temp.front());
            //cout << temp.front().pid << endl;
        }
        temp.pop();
    }
    // check
//    cout << "### check" << endl;
//    queue<process> temp2 = this->ready_queue;
//    for (int i = 0; i < list_size; i++) {
//        cout << temp2.front().pid << endl;
//        temp2.pop();
//    }
}

void simulator::srft_sort() {
    int list_size = this->ready_queue.size();
    process temp[list_size];
    // convert to array
    for (int i = 0; i < list_size; ++i) {
        temp[i] = this->ready_queue.front();
        //cout << ready_queue.front().pid << endl;
        this->ready_queue.pop();
    }
    // sort
    for (int i = 0; i < list_size-1; ++i) {
        for (int j = 0; j < list_size-i-1; ++j) {
            process cur = temp[j];
            if (cur.burst_time > temp[j+1].burst_time) {
                temp[j] = temp[j+1];
                temp[j+1] = cur;
            }
        }
    }
    // place in ready_queue
    //cout << "print ready_queue" << endl;
    for (int i = 0; i < list_size; ++i) {
        //cout << "pid: " << temp[i].pid << " burst: " << temp[i].burst_time << endl;
        this->ready_queue.push(temp[i]);
    }
}

void simulator::rr(queue <process> &task_list, queue <process> &finish_task_list, int quantum_time) {
    time = 0;
    process active_task; // this sets it to a garbage object, doesnt matter because it will be overwritten.
    while (!task_list.empty() or !this->ready_queue.empty()) {
        //cout << "#### RR round ####" << endl;
        //cout << "current time: " << time << endl;
        //cout << "task_list head arrival time: " << task_list.front().arrival_time << endl;
        if (!task_list.empty()) {
            while (task_list.front().arrival_time <= time) { // While there is a task that has arrived add it to the ready_queue
                //cout << "task_list size: " << task_list.size() << " ";
                this->ready_queue.push(task_list.front());
                task_list.pop();
                if (task_list.empty()) { // if there is nothing left then end.
                    break;
                } else {
                    //cout << "task_list head arrival time: " << task_list.front().arrival_time << endl;
                }
            }
        }
        if (this->ready_queue.empty() and time >= 0) {
            cout << "<time " << time << "> " <<  "no process is running" << endl;
            time++;
            continue;
        }
        if (active_task.pid == "-1") {
            active_task = this->ready_queue.front();
        }
        int active_process_size = this->ready_queue.size();
        //cout << "process size: " << active_process_size << endl;
        for (int i = 0; i < active_process_size; i++) { // round robin
            for (int j = 0; j < quantum_time; j++) { // process iteration #'s per RR round
                if (active_task.remaining_time == 0) { // if process is completed
                    active_task.finish_time = time;
                    cout << "<time " << time << "> " << active_task.pid << " is finished..." << endl;
                    this->ready_queue.pop();
                    finish_task_list.push(active_task);
                    if (task_list.empty() and this->ready_queue.empty()) { // if there is nothing left then end.
                        break;
                    }
                    active_task = this->ready_queue.front();
                    break;
                }
                if (active_task.remaining_time == active_task.burst_time) { // set start time
                    active_task.start_time = time;
                }
                cout << "<time " << time << "> " << active_task.pid << " is running" << endl;
                active_task.remaining_time--;
                time++;
            }
            if (!this->ready_queue.empty()) {
                this->ready_queue.pop();
                this->ready_queue.push(active_task);
                active_task = this->ready_queue.front();
            }
        }
        //cout << "#### end RR round ####" << endl;
    }
    cout << "<time " << time << "> " << "All processes finished ......" << endl;
}
