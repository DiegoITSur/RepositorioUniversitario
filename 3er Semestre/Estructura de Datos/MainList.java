package ListasLigadas;

public class MainList {
    public static void main(String[] args) {
        linkedList lt = new linkedList(new int[]{100, 23, 34, 1, 3});
        System.out.println("Informacion completa de una lista:");
        System.out.println("Lista Inicial: ");
        lt.printList();
        lt.getHead();
        lt.getTail();
        lt.getLength();

    }
}
