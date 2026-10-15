package ListasLigadas;

public class linkedList {
    // Definicion de apuntadores
    // Cabeza(head): donde inicia la lista, el primer nodo
    // Cola(tail): el ultimo nodo
    private Node head;
    private Node tail;
    private int length;
    class Node{
        // Definicion de atributos
        // value: valor del nodo
        // next: apuntador hacia el siguiente nodo
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    // Constructor en donde no recibe ningunn valor
    public linkedList(){
        length = 0;
        head = null;
        tail = null;
    }

    // Sobrecarga del mismo constructor, recibiendo un valor e inicializando todos los valores
    public linkedList(int value){
        Node newNode = new Node(value);
        length = 1;
        head = newNode;
        tail = newNode;
        tail.next = null;
    }

    // Sobrecarga del constructor, puede recibir varios datos
    public linkedList(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            append(arr[i]);
        }
    }

    // Devuelve la cabeza (el primer nodo)
    public void getHead(){
        System.out.println("Head: " + head.value);
    }

    // Devuelve la cola (el ultimo nodo)
    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }

    // Devuelve la longitud
    public void getLength(){
        System.out.println("Length: " + length);
    }

    // Busca un nodo por su indice segun su orden dentro de la lista
    // Empieza desde la cabeza, con un contador i igual a 0
    // i irá aumentando hasta que i llegue a ser igual que idx (el indice buscado)
    // Si lo encuentra: devuelve el nodo
    // De lo contrario: devuelve el nodo siendo igual a null
    public Node getNode(int idx){
        Node it = head;
        int i = 0;
        while(it != null && ++i < idx)
                it = it.next;
        return it;
    }

    // Cambia el valor de un nodo de indice idx
    // El iterador empieza desde la cabeza, con un contador i igual a 0
    // i irá aumentando hasta encontrarse con el indice idx
    // Si el nodo fue encontrado: cambia el valor
    // De lo contrario: No lo cambia
    // Devuelve un booleano (it != null): si it es nulo, devuelve falso, de lo contrario devuelve verdadero
    public boolean setNode(int idx, int value){
        Node it = head;
        int i = 0;
        while(it != null && ++i < idx){
            it = it.next;
        }
        if(it != null)
                it.value = value;
        return it != null;
    }

    // Imprime los nodos en orden de aparición
    // Se recorre desde la cabeza hasta la cola
    public void printList(){
        Node it = head;
        while(it != null){
            System.out.print(it.value+" ");
            it = it.next;
        }
        System.out.println();
    }

    // Ingresa un nodo hasta el final (la cola)
    // si la longitud es igual a 0: tanto la cola como la cabeza van a hacer referencia al mismo nodo, es decir, solo hay un nodo
    // de lo contrario: La cola apunta hacia el nuevo nodo creado y cambia para ahora apuntar hacia ese nuevo nodo
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0) {
            tail = head = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
            tail.next = null;
        }
        length ++;
    }

    // Agrega un valor desde el incio de la lista (la cabeza)
    // Si la cabeza es nula (no hay ningun nodo): El nuevo nodo se vuelve la cabeza y la cola al mismo tiempo
    // De lo contrario: La cabeza forma parte del siguiente nodo de nuesrto nuevo nodo (newNode.next = head)
    // Y la cabeza ahora apunta hacia este nuevo nodo
    public void preAppend(int value){
        Node newNode = new Node(value);
        if(length == 0) {
            newNode.next = null;
            tail = newNode;
        }
        else {
            newNode.next = head;
        }
        length ++;
        head = newNode;
    }

    // Quita el primer elemento (la cabeza) y regresar sicho nodo quitado
    // Si la cabeza es nula: no hace nada y regresa nudo
    // De lo contrario: Guardamos el nodo eliminado para despues devolverlo
    // Y solo hacemos que la cabeza avance al siguiente nodo
    public Node removeFirst(){
        if(head == null)
            return null;
        Node eliminted = head;
        head = head.next;
        return eliminted;
    }

    // Quita el nodo del final (cola) y devuleve dicho nodo quitado
    // Se crean dos apuntadores
    // a: Nodo anterior
    // b: Nodo actual
    // El ciclo se hace hasta que el siguiente nodo de b no sea igual a null
    // significando que lelgamos al ultimo nodo
    public Node removeLast(){
        if(head == null){
            return null;
        }
        Node a = head;
        Node b = head;

        while(b.next != null){
            a = b;
            b = b.next;
        }

        tail = a;
        tail.next = null;
        length --;
        if(length == 0){
            head = null;
        }

        return b;
    }


    // Insert(int index, in value): boolean
    public boolean insert(int idx, int value){
        Node newnode = new Node(value);
        Node a = null;
        Node b = head;

        if(idx == 1) {
            preAppend(value);
            return true;
        }
        else if(idx == length) {
            append(value);
            return true;
        }
        int i = 0;
        boolean ans = false;
        while(++i < idx && b != null){
            a = b;
            b = b.next;
        }

        if(i == idx){
            a.next = newnode;
            newnode.next = b;
            ans = true;
        }
        length ++;
        return ans;
    }

    // Elimina un nodo dado un indice idx y devuelve dicho nodo eliminado
    // Se tiene dos apuntadores que inician en la cabeza
    // it: Apunta al nodo actual
    // it2: Apunta un nodo por detras del actual
    // el contador i, aumentará hasta que este llegue al indice buscado
    // Si el apuntador it == null, no se realiza nada y se devuelve null
    // De lo contrario: it2 (el iterador que apunta a un nodo por detras del que buscamos idx) apuntará al siquiente siguiente nodo
    // Disminuye la longitud y se devuelve el nodo quitado
    public Node remove(int idx){
        Node it = head;
        Node it2 = head;

        int i = 0;
        while(++i < idx && it != null){
            it2 = it;
            it = it.next;
        }

        if(it == null)
            return null;
        it2.next = it.next;
        length--;
        return it;
    }

    // invierte el orden de la lista
    // Se tiene tres apuntadores
    // a = nodo anterior
    // b = nodo actual
    // c = nodo siguiente
    // Se van intercambiando hacian donde apuntan los nodos
    // Al final, se define la cabeza (head) como la cola y la cola (tail) como la cabeza
    public void reverse(){
        Node a = null;
        Node b = head;
        Node c = head.next;

        while(c != null){
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        b.next = a;
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

    // Regresa un booleano si existe un ciclo en kla lista o no.
    // Dados dos iteradores:
    // a: Iterador normal
    // b: Iterador de salto doble
    // b avanzará hasta que este sea nulo (no hay ciclo)
    // o hasta que alcanza a 'a', significando que hay ciclo
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
