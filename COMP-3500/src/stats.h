#ifndef CPU_SCHEDULER_STATS_H
#define CPU_SCHEDULER_STATS_H

#include <queue>
#include "process.h"

class stats {
    public:
        stats();

        void calculate(queue<process> finished_task_list, int total_time);
};


#endif //CPU_SCHEDULER_STATS_H
