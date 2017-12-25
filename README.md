# ConcurrencyDec2017

https://drive.google.com/open?id=1srf4bPf4Pm4UYVkZP33dnfdX5SQGZ_iq


Create concurrent tasks with a thread executor service using Runnable and Callable. An ExecutorService creates and manages a single thread or a pool of threads. Instances of Runnable and Callable can both be submitted to a thread executor and will be completed using the available threads in the service. Callable differs from Runnable in that Callable returns a generic data type and can throw a checked exception. A ScheduledExecutorService can be used to schedule tasks at a  xed rate or a  xed interval between executions.

Be able to synchronize blocks and methods. A monitor can be used to ensure that only one thread processes a particular section of code at a time. In Java, monitors are commonly implemented as synchronized blocks or using synchronized methods. In order to achieve synchronization, two threads must synchronize on the same shared object.
Be able to apply the atomic classes. An atomic operation is one that occurs without interference by another thread. The Concurrency API includes a set of atomic classes that are similar to the primitive classes, except that they ensure that operations on them are performed atomically.

Be able to use the concurrent collection classes. The Concurrency API includes numerous collections classes that include built-in support for multi-threaded processing, such as ConcurrentHashMap and ConcurrentDeque. It also includes a class CopyOnWriteArrayList that creates a copy of its underlying list structure every time it is modi ed and is useful in highly concurrent environments.

Understand the impact of using parallel streams. The Streams API allows for easy creation of parallel streams. Using a parallel stream can cause unexpected results, since the order of operations may no longer be predictable. Some operations, such as reduce() and collect(), require special consideration to achieve optimal performance when applied to a parallel stream.

Manage process with the CyclicBarrier class and the fork/join framework. The CyclicBarrier class can be used to force a set of threads to wait until they are at a certain stage of execution before continuing. The fork/join framework can be used to create a task that spawns additional tasks to solve problems recursively.

Identify potential threading problems. Deadlock, starvation, and livelock are three threading problems that can occur and result in threads never completing their task. Deadlock occurs when two or more threads are blocked forever. Starvation occurs when a single thread is perpetually denied access to a shared resource. Livelock is a form of starvation where two or more threads are active but conceptually blocked forever. Finally, race conditions occur when two threads execute at the same time, resulting in an unexpected outcome.
