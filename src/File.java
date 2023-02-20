public class File {
    public int[] elements;
    public int start;
    public int end;
    public int size;
    public int maximum;
    
    public File(){
        this.maximum = 100;
        this.elements = new int[maximum];
        this.start = 0;
        this.end = -1;
        this.size = 0;
        return;
    }

    public void push(int element){
        if(isFull()){
            throw new IllegalStateException("File is full!");
        }
        end = (end +1 ) % maximum;
        elements[end] = element;
        size++;
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException("File is empty!");
        }

        int value = elements[start];
        start = (start + 1) % maximum;
        size--;
        return value;
    }

    public int length(){
        return size;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("File is empty");
            return;
        }
    
        System.out.print("File (start to end): ");
        System.out.print("(");
        for (int i = start; i <= end; i = (i + 1) % maximum) {
            if(i == end){
                System.out.print(elements[i]);
            }else{
                System.out.print(elements[i] + ", ");
            }
        }
        System.out.print(")");
        System.out.println();
    }
    

    public boolean search(int value){
        for (int i = start; i <= end; i = (i + 1) % maximum) {
            if(value == elements[i]){
                return true;
            }
        }
        return false;
    }

    public void remove(int value){
        for (int i = start; i <= end; i = (i + 1) % maximum) {
            if (elements[i] == value) {
                if (i == start) {
                    // If the value is at the start - move start index
                    start = (start + 1) % maximum;
                } else if (i == end) {
                    // If the value is at the end - move end index
                    end = (end - 1 + maximum) % maximum;
                } else {
                    // If the value is in the middle - shift elements to remove it
                    for (int j = i; j < end; j = (j + 1) % maximum) {
                        elements[j] = elements[(j + 1) % maximum];
                    }
                    end = (end - 1 + maximum) % maximum;
                }
                size--;
                return;
            }
        }
        // If the value is not found in the File
        return;
    }

    public boolean isFull(){
        return size == maximum;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}