#include "process.h"
#include <iostream>
#include <string>


using namespace std;

process::process() {
    this->pid = "-1";
    this->burst_time = -1;
    this->arrival_time = -1;
    this->remaining_time = this->burst_time;
};

process::process(int PIDIn, int arrivalIn, int burstIn) {
    this->pid = to_string(PIDIn);
    this->arrival_time = arrivalIn;
    this->burst_time = burstIn;
    this->remaining_time = this->burst_time;
}

process::process(string PIDIn, int arrivalIn, int burstIn) {
    this->pid = PIDIn;
    this->arrival_time = arrivalIn;
    this->burst_time = burstIn;
    this->remaining_time = this->burst_time;
}

process::process(string PIDIn, string arrivalIn, string burstIn) {
    this->pid = PIDIn;
    this->arrival_time = stoi(arrivalIn);
    this->burst_time = stoi(burstIn);
    this->remaining_time = this->burst_time;
}

string process::getPID() {
    return this->pid;
}

void process::setPID(string pidIn) {
    this->pid = pidIn;
}

int process::getArrivalTime() {
    return this->arrival_time;
}

void process::setArrivalTime(int arrivalIn) {
    this->arrival_time = arrivalIn;
}

int process::getBurstTime() {
    return this->burst_time;
}

void process::setBurstTime(int burstIn) {
    this->burst_time = burstIn;
}

bool process::equals(process &process) {
    if (this->pid == process.pid) {
        return true;
    }
    return false;
}
