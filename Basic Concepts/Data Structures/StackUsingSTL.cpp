// http://www.geeksforgeeks.org/stack-in-cpp-stl/

#include <iostream>
#include <stack>

void printStack(std::stack<int> foo) {
    std::stack<int> bar = foo;

    while(!bar.empty()) {
        std::cout << "\t" << bar.top();
        bar.pop();
    }

}

int main() {

    std::stack<int> foo;

    foo.push(10);
    foo.push(20);
    foo.push(30);

    std::cout << "\n top - " << foo.top();
    std::cout << "\n size - " << foo.size();

    foo.pop();

    std::cout << "\n top - " << foo.top();
    std::cout << "\n size - " << foo.size();

    printStack(foo);

    std::cout << "\n top - " << foo.top();
    std::cout << "\n size - " << foo.size();

    return 0;
}