#ifndef CPU_SCHEDULER_PROCESS_H
#define CPU_SCHEDULER_PROCESS_H
#include <string>
using namespace std;

class process {
    public:
        string pid;
        int start_time;
        int finish_time;
        int arrival_time;
        int burst_time;
        int remaining_time;
        int waiting_time;
        int turnaround_time;

        process();

        process(string pidIn, int arrivalIn, int burstIn);

        process(string pidIn, string arravalIn, string burstIn);

        process(int pidIn, int arrivalIn, int burstIn);

        string getPID();

        int getArrivalTime();

        int getBurstTime();

        void setPID(string pidIn);

        void setArrivalTime(int arrivalIn);

        void setBurstTime(int burstIn);

        bool equals(process &process);
};

#endif //CPU_SCHEDULER_PROCESS_H
