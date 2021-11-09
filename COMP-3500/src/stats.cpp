#include "stats.h"
#include <iostream>

using namespace std;

stats::stats() = default;

void stats::calculate(queue<process> finished_task_list, int total_time) {
    //cout << "##### finished task list check #####" << endl;
    /*
    cout << "task list size: " << finished_task_list.size() << endl;
    int list_size = finished_task_list.size();
    queue<process> task_list_copy = finished_task_list;
    for (int i = 0; i < list_size; i++) {
        cout << task_list_copy.front().pid << " " << task_list_copy.front().arrival_time << " " << task_list_copy.front().burst_time << " ";
        cout << task_list_copy.front().start_time << " " << task_list_copy.front().finish_time << endl;
        task_list_copy.pop();
    }
    cout << &finished_task_list << endl;
    */
    //cout << "##### end finsihed task list check #####" << endl;

    int finished_list_size = finished_task_list.size();

    queue<process> turnaround_temp = finished_task_list;
    float total_turnaround_time = 0.0;
    for (int i = 0; i < finished_list_size; i++) {
        total_turnaround_time += (float)turnaround_temp.front().finish_time - (float)turnaround_temp.front().arrival_time;
        turnaround_temp.pop();
    }
    float avg_turnaround_time = total_turnaround_time / (float) finished_list_size;

    queue<process> response_temp = finished_task_list;
    float total_response_time = 0.0;
    for (int i = 0; i < finished_list_size; i++) {
        total_response_time += (float) response_temp.front().start_time - (float) response_temp.front().arrival_time;
        response_temp.pop();
    }
    float avg_response_time = total_response_time / (float) finished_list_size;

    queue<process> waiting_temp = finished_task_list;
    float total_waiting_time = 0.0;
    for (int i = 0; i < finished_list_size; i++) { // calculating process waiting time.
        float turnaround_time = 0.0;
        turnaround_time += (float)waiting_temp.front().finish_time - (float)waiting_temp.front().arrival_time;
        total_waiting_time += (float) turnaround_time - (float) waiting_temp.front().burst_time;
        waiting_temp.pop();
    }
    float avg_waiting_time = total_waiting_time / (float) finished_list_size;

    queue<process> burst_temp = finished_task_list;
    int total_burst_time = 0;
    for (int i = 0; i < finished_list_size; i++) {
        total_burst_time += burst_temp.front().burst_time;
        burst_temp.pop();
    }
    float cpu_usage =  ((float)total_burst_time/(float)total_time)*100;

    cout << "Average waiting time: " << avg_waiting_time << endl; // turnaround - burst
    cout << "Average response time: " << avg_response_time << endl; // start - arrival
    cout << "Average turnaround time: " << avg_turnaround_time << endl; // finish - arrival
    cout << "Overall CPU usage: " << cpu_usage << "%" << endl;
}