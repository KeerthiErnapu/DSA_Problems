class MyStack {
    int top;
    ArrayList<Integer> arr=new ArrayList<>();

    public MyStack() {
         top=-1;
        
    }
    
    public void push(int x) {
        top++;
        arr.add(x);
        
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        return arr.remove(top--);
        
    }
    
    public int top() {
        return arr.get(top);
    }
    
    public boolean empty() {
        if(top==-1){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
