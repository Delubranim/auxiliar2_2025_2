import library.Library
import book.Book

// Juegue con las diferentes cosas que puede hacer con este codigo para familiarizarse con las sintaxis del lenguaje
object Main {   // para ejecutar este archivo haga click izquierdo en el icono del boton verde
  def main(args: Array[String]): Unit = {

    // creamos una biblioteca. Note que el atributo 'books' no se lo damos, pues se inicializa solo como un arreglo vacio
    // En cambio el atributo 'name' se tiene que entregar porque lo incluimos como parametro del constructor
    val library: Library = new Library("Biblioteca nacional")

    val book1: Book = new Book("Cien años de soledad", "Gabriel Garcia Marquez")
    val book2: Book = new Book("La divina comedia", "Dante Alighieri")

    // Se pueden acceder a los atributos de una instancia de esta manera
    println("Datos book1")
    println("Titulo:"+book1.title)  // Titulo: Cien años de soledad
    println("Autor:"+book1.author)  // Autor: Gabriel Garcia Marquez
    println("Disponible?:"+book1.available) // Disponible?: True
    println("Biblioteca del libro: " + book1.library) // Biblioteca del libro: null

    println("Datos book2")
    println("Titulo:" + book2.title)  // Titulo: La divina comedia
    println("Autor:" + book2.author)  // Autor: Dante Alighieri
    println("Disponible?:"+book2.available) // Disponible?: True
    println("Biblioteca del libro: " + book2.library) // Biblioteca del libro: null

    println("Datos biblioteca")
    println("Nombre: "+library.name)  // Nombre: Biblioteca nacional
    println("Libros: "+library.books)  // Libros:  ArrayBuffer()

    println("Llegan nuevos libros a la biblioteca!!!!")
    book1.addToLibrary(library)
    book2.addToLibrary(library)

    println("Biblioteca del libro1: " + book1.library.name)  // Biblioteca nacional
    println("Biblioteca del libro2: " + book2.library.name)  // Biblioteca nacional

    println("Libros: "+library.books) // Printeara las direcciones de memoria de los libros. book.Book@1e67b872
    // Si printean directamente una instancia de una clase printeara su dirrecion de memoria, a menos que definan un metodo print
    println("Libro1?:" + book1)

    println("La divina comedia se rompio y se retira del catalogo")
    book2.removeFromLibrary()
    println("Biblioteca del libro2: " + book2.library) // null
    println("Libros: "+library.books)

    println("Esta cien años de soledad?:" + library.searchBook(book1))  // true
    println("Se presta el libro")
    book1.takeBook()
    println("Disponible?:"+book1.available) // Disponible?: false
    println("Se devuelve el libro")
    book1.retunBook()
    println("Disponible?:"+book1.available) // Disponible?: true




  }
}