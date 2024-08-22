package localrepo.StacksQueues;

class stack2arr {
    int arr[];
    int size;
    int top1, top2;

    // Constructor
    stack2arr(int n) {
        size = n;
        arr = new int[n];
        top1 = n / 2 + 1;
        top2 = n / 2;

    }

    // push method for stack 1
    void push1(int x) {
        // there's atleast one space for new element
        if (top1 > 0) {
            top1--;
            arr[top1] = x;
        } else {
            System.out.println("Stack overflow!");
        }
    }

    // push stack2
    void push2(int x) {
        // there's atleast one space for new element
        if (top2 < size - 1) {
            top2++;
            arr[top2] = x;
        } else {
            System.out.println("Stack Overflow");
            return;
        }
    }

    // pop stack 1
    int pop1() {
        if (top1 <= size - 2) {
            int x = arr[top1];
            top1++;
            return x;
        } else {
            System.out.println("Stack overflow");
        }
        return 0;
    }

    // pop stack2
    int pop2() {
        if (top2 >= size / 2 + 1) {
            int x = arr[top2];
            top2--;
            return x--;
        } else {
            System.out.println("Stack underflow");
        }
        return 1;
    }

    public static void main(String[] args) {
        int n = 8;
        int arr[] = new int[n];
        stack2arr ob = new stack2arr(n);
        ob.push1(1);
        ob.push1(2);
        ob.push1(3);
        ob.push2(4);
        ob.push2(5);
        ob.push2(6);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

    }
}