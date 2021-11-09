<!---
   @author   Dean Hendrix (dh@auburn.edu)
   @version  2016-09-28
-->

# Hands-on: Linked Nodes

This activity focuses on the fundamental mechanics of using singly- and doubly-linked nodes as containers for physical storage. After completing the lab you should

* Understand creation and linking of singly-linked nodes.
* Understand creation and linking of doubly-linked nodes.


## Set-up

1. Open the `COMP2210/hands-on` directory that you created in an earlier lab.

1. Create the `linked-nodes` directory.

1. Download the following files and save them in the `COMP2210/hands-on/linked-nodes` directory.
   - [SinglyLinked.java](src/SinglyLinked.java)
   - [DoublyLinked.java](src/DoublyLinked.java)

1. Open jGRASP to the `COMP2210/hands-on/linked-nodes` directory.


## Singly-linked nodes

1. Open `SinglyLinked.java` in jGRASP and compile it.
1. Set a breakpoint on line 18: `client.basicExamples();`
1. Start the debugger and wait until execution is paused at the breakpoint.
1. Step in to the call to `basicExamples()`.
1. Single-step to line 54: `n = new Node(1);`
1. Step over this statement and then open a viewer on `n`.
1. Step over each remaining statement in `basicExamples`, making sure you understand the effect of each statement. (You may want to step in to the calls to `length` and `contains`.)

**Close the viewer and end program execution.**

1. Clear any previous breakpoints you set in `SinglyLinked.java`.
1. Set a breakpoint on line 19: `client.add()`.
1. Start the debugger and wait until execution is paused at the breakpoint.
1. Step in to the call to `add()`.
1. Single-step to line 154: `System.out.println(toString(n));`
1. Open a viewer on `n`.
1. Click on the *Interactions* tab in the jGRASP Desktop.
1. Use *Interactions* to practice inserting the node referenced by `temp` at various locations in the pointer chain. (You'll have to repeat these steps each time you want to practice an insertion.)


**Close the viewer and end program execution.**

1. Clear any previous breakpoints you set in `SinglyLinked.java`.
1. Set a breakpoint on line 20: `client.delete()`.
1. Start the debugger and wait until execution is paused at the breakpoint.
1. Step in to the call to `delete()`.
1. Single-step to line 169: `System.out.println(toString(n));`
1. Open a viewer on `n`.
1. Click on the *Interactions* tab in the jGRASP Desktop.
1. Use *Interactions* to practice deleting various nodes in the pointer chain. (You may have to repeat these steps when you want to practice multiple deletions.)

**Close the viewer and end program execution.**



## Doubly-linked nodes

1. Open `DoublyLinked.java` in jGRASP and compile it.
1. Set a breakpoint on line 18: `client.basicExamples();`
1. Start the debugger and wait until execution is paused at the breakpoint.
1. Step in to the call to `basicExamples()`.
1. Single-step to line 52: `m = new Node(2);`
1. Open a viewer on `n`.
1. Step over each remaining statement in `basicExamples`, making sure you understand the effect of each statement. (You may want to step in to the calls to `length` and `contains`.)

**Close the viewer and end program execution.**

1. Clear any previous breakpoints you set in `DoublyLinked.java`.
1. Set a breakpoint on line 19: `client.add()`.
1. Start the debugger and wait until execution is paused at the breakpoint.
1. Step in to the call to `add()`.
1. Single-step to line 139: `System.out.println(toString(n));`
1. Open a viewer on `n`.
1. Click on the *Interactions* tab in the jGRASP Desktop.
1. Use *Interactions* to practice inserting the node referenced by `temp` at various locations in the pointer chain. (You'll have to repeat these steps each time you want to practice an insertion.)


**Close the viewer and end program execution.**

1. Clear any previous breakpoints you set in `DoublyLinked.java`.
1. Set a breakpoint on line 20: `client.delete()`.
1. Start the debugger and wait until execution is paused at the breakpoint.
1. Step in to the call to `delete()`.
1. Single-step to line 157: `System.out.println(toString(n));`
1. Open a viewer on `n`.
1. Click on the *Interactions* tab in the jGRASP Desktop.
1. Use *Interactions* to practice deleting various nodes in the pointer chain. (You may have to repeat these steps when you want to practice multiple deletions.)

**Close the viewer and end program execution.**


