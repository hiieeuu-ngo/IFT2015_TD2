public class Node {
    private int value;
    private Node next = null;
    public Node head;
    public Node(int value){
        head = this;
        this.value = value;
        this.next = null;
    }

    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public void addValue(int value){
        if(this.next == null){
            Node newNode = new Node(value);
            this.next = newNode;
            return;
        }
        this.next.addValue(value);
    }

    public void addNode(Node next){
        if(this.next == null){
            this.next = next;
            return;
        }
        this.next.addNode(next);
    }

    public void removeLast(){
        if(this.next.next == null){
            this.next = null;
            return;
        }
        this.next.removeLast();
    }

    public void removeValue(int value) {
        if (this.next == null) {
            return;
        }
        if (this.value == value) {
            this.value = this.next.value;
            this.next = this.next.next;
            removeValue(value);
        } else {
            this.next.removeValue(value);
        }
        if (this.next != null && this.next.value == value) {
            this.next = this.next.next;
            removeValue(value);
        }
    }
    
    

    public int length_iteratif(){
        Node temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return (len);
    }

    public int length_recurssion(){
        if(this.next == null){
            return 1;
        }
            return 1 + this.next.length_recurssion();
        
    }

    public int returnNlast(int nLast){
        int length = this.length_iteratif();
        int n = length - nLast;
        Node temp = head;
        for(int k=0; k < n; k++){
            temp = temp.next;
        }
        return(temp.value);
    }

    public void addValue_ordered(int value) {
        if (value <= this.value) {
            Node newNode = new Node(value);
            newNode.next = this;
            return;
        }
        if (this.next == null || value < this.next.value) {
            Node newNode = new Node(value);
            newNode.next = this.next;
            this.next = newNode;
            return;
        }
        this.next.addValue_ordered(value);
    }

    public void insertSort(){
        if (head == null || head.next == null) {
            return;
        }
    
        Node sortedList = null;
        Node tempCurrent = head;
    
        while (tempCurrent != null) {
            Node next = tempCurrent.next;
    
            if (sortedList == null || tempCurrent.value < sortedList.value) {
                tempCurrent.next = sortedList;
                sortedList = tempCurrent;
            } else {
                Node sortedCurrent = sortedList;
    
                while (sortedCurrent.next != null && tempCurrent.value > sortedCurrent.next.value) {
                    sortedCurrent = sortedCurrent.next;
                }
    
                tempCurrent.next = sortedCurrent.next;
                sortedCurrent.next = tempCurrent;
            }
    
            tempCurrent = next;
        }
    
        // Update the head of the linked list
        head = sortedList;
    }
    // to test and print linked list
    public void printList() {
        Node current = this;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}

