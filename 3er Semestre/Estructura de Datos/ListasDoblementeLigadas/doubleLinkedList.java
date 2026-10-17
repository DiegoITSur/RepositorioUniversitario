public class doubleLinkedList {
    /*
    *   Cada uno de los nodos tienen dos apuntadores:
    *   El nodo predesesor y El nodo siguiente
    */

    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;
        Node prev;
        public Node(int value){
            this.value = value;
        }
    }

    public doubleLinkedList(){
        length = 0;
        head = null;
        tail = null;
    }

    public doubleLinkedList(int value){
        Node newNode = new Node(value);
        length = 1;
        head = newNode;
        tail = newNode;
        tail.next = null;
    }

    public doubleLinkedList(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            append(arr[i]);
        }
    }

    public void getHead(){
        System.out.println("Head: " + head.value);
    }

    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

    public Node getNode(int idx){
        Node it = head;
        int i = 0;
        while(++i < idx && it != null){
            it = it.next;
        }

        return it;
    }
    public Node LookUpByValue(int value){
        Node it = head;
        while(it != null && it.value != value){
            it = it.next;
        }

        return it;
    }

    public boolean setNode(int idx, int value){
        int i = 0;
        Node it = head;
        while(++i < idx && it != null){
            it = it.next;
        }

        if(i == idx){
            it.value =  value;
            return true;
        }
        return false;
    }

    public void printList(){
        Node it = head;
        while(it != null){
            System.out.print(it.value+" ");
            it = it.next;
        }
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            tail.next = null;
        }

        length++;
    }

    public void preAppend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }

        length ++;
    }

    public Node removeFirst(){
        if(length == 0){
            return null;
        }

        Node eliminated = head;
        head = head.next;
        head.prev = null;
        length --;

        return eliminated;
    }

    public Node removeLast(){
        if(length == 0){
            return null;
        }

        Node eliminated = tail;
        tail = tail.prev;
        tail.next = null;
        length --;

        return eliminated;
    }

    public boolean insert(int idx, int value){
        Node newNode = new Node(value);
        int i = 0;
        Node it = head;

        if(idx == 1){
            preAppend(value);
            return true;
        }
        if(idx == length){
            append(value);
            return true;
        }

        while(it != null && ++i < idx){
            it = it.next;
        }

        if(it == null || i != idx){
            return false;
        }
        newNode.next = it;
        newNode.prev = it.prev;
        it.prev.next = newNode;

        length ++;
        return true;
    }

    public Node remove(int idx){
        int i = 0;
        Node it = head;

        if(idx == 1){
            return removeFirst();
        }
        else if(idx == length){
            return removeLast();
        }

        while(it != null && ++i < idx){
            it = it.next;
        }

        if(it == null){
            return null;
        }


        it.next.prev = it.prev;
        it.prev.next = it.next;
        length --;
        return it;
    }

    public void reverse(){
        Node it = head;
        while(it != null){
            Node nextIt = it.next;
            it.next = it.prev;
            it.prev = nextIt;
            it = nextIt;
        }

        Node aux = head;
        head = tail;
        tail = aux;
    }

    public Node middle(){
        Node mid = head;
        Node far = head;

        while(far != null){
            far = far.next;
            if(far == null)
                break;
            mid = mid.next;
            far = far.next;
        }

        return mid;
    }

    public boolean loop(){
        Node a = head;
        Node b = head;

        boolean ans = true;
        while(a != b){
            b = b.next;
            if(b == null){
                ans = false;
                break;
            }
            b = b.next;
            a = a.next;
        }

        return ans;
    }

}
