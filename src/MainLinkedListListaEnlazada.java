import linkedListdoblementeenlazada.LinkedListDoubleEnlasada;
import model.Libro;


public class MainLinkedListListaEnlazada {
    public static void main(String[] args) throws Exception {
        LinkedListDoubleEnlasada listaDobleEnlasada = new LinkedListDoubleEnlasada();
        Libro libro1 = new Libro("El poder de aprender", "Victor .v", 234);
        Libro libro2 = new Libro("El mundo de los dioses", "J.R.R. Tolkien", 123);

        listaDobleEnlasada.add(libro1);
        listaDobleEnlasada.add(libro2);
        listaDobleEnlasada.printList();
        listaDobleEnlasada.remove(1);
        listaDobleEnlasada.printList();
//        listaDobleEnlasada.remove(0);
//        listaDobleEnlasada.printList();
        System.out.println(listaDobleEnlasada.contains(libro1));
        listaDobleEnlasada.clear();
        listaDobleEnlasada.printList();


    }
}
