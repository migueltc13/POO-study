// exercício 1
public class Stack {

    private String[] stack;
    private int cap; /* capacity */
    private int sp; /* stack pointer */

    private final int DEFAULT_CAP = 10;

    public Stack() {
        this.stack = new String[DEFAULT_CAP];
        this.cap = DEFAULT_CAP;
        this.sp = 0;
    }

    public Stack(String[] stack, int cap, int sp) {
        this.stack = stack;
        this.cap = cap;
        this.sp = sp;
    }

    public Stack(Stack s) {
        this.stack = s.getStack();
        this.cap = s.getCap();
        this.sp = s.getSp();
    }

    public String[] getStack() {
        return this.stack;
    }

    public int getCap() {
        return this.cap;
    }

    public int getSp() {
        return this.sp;
    }

    public void setStack(String[] stack) {
        this.stack = stack; // TODO copy string
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    // exercício (a)
    public String top() {
        return this.stack[sp];
    }

    // exercício (b)
    public void push(String s) {
        if (this.sp < this.cap)
            this.stack[this.sp++] = s; // TODO copy string
    }

    // exercício (c)
    public void pop() {
        // if (!this.empty())
        //     return this.stack[this.sp--];
        if (!this.empty())
            this.sp--;
    }

    // exercício (d)
    public boolean empty() {
        return this.sp == 0;
    }

    // exercício (e)
    public int length() {
        return this.sp + 1;
    }
}
