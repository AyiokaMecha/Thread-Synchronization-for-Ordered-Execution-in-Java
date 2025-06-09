# Thread-Safe Ordered Execution in Java

## Overview
This project demonstrates three different approaches to ensure ordered execution of methods across multiple threads in Java. The implementations guarantee that three methods (`first()`, `second()`, `third()`) are always executed sequentially, regardless of thread scheduling.

## Implementations

### 1. Synchronized with Wait/Notify
- Uses Java's built-in synchronization mechanism
- Implements `wait()` and `notifyAll()` for thread coordination
- Maintains execution state with boolean flags

### 2. CountDownLatch Approach
- Modern solution using `java.util.concurrent.CountDownLatch`
- More readable and maintainable than traditional synchronization
- Uses countdown latches as execution barriers

### 3. Semaphore Approach
- Utilizes `java.util.concurrent.Semaphore`
- Provides fine-grained control over thread execution
- Most flexible solution for complex scenarios

## Getting Started

### Prerequisites
- Java JDK 8 or later
- Git (optional)

### Installation
```bash
git clone https://github.com/yourusername/thread-ordered-execution.git
cd thread-ordered-execution
```

### Running the Examples
```bash
javac Foo.java OrderedExecutionExample.java
java OrderedExecutionExample
```

## Expected Behavior
All implementations will consistently produce the output:
```
firstsecondthird
```
even when threads are started in arbitrary orders.

## Key Concepts Illustrated
- Thread synchronization mechanisms
- Inter-thread communication patterns
- Java concurrency primitives:
  - `synchronized` methods/blocks
  - `wait()` and `notify()`/`notifyAll()`
  - `CountDownLatch` for thread coordination
  - `Semaphore` for resource management

## Practical Applications
This pattern is particularly useful for:
- Coordinating dependent operations across threads
- Implementing ordered task execution in concurrent systems
- Managing asynchronous operations with execution dependencies
- Building thread-safe components with strict execution requirements

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
