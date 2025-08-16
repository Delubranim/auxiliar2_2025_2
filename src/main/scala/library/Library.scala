package library

import book.Book

import scala.collection.mutable.ArrayBuffer
/* Importacion de la libreria estandar de Scala (esto siempre vendra con Scala). Nos permite usar arreglos mutables*/

/* Semejante a la clase Book, tendremos atributos que es necesario entregarlos al constructor y se pueden inicializar
* de la misma manera para todas las instancias de la clase y que se ira modificando con el tiempo.
*  IMPORTANTE: Notar que existe una diferencia entre modificar (mutable) y reasignar, una lista se puede mutar agregando
* elementos a ella y cambiando el atributo internamente, distinto de por ejemplo cambiar la lista por otra completamente distinta*/

/** Represents a library with books
 * @param name Name of the library
 * 
 * @constructor Creates a new library with the specified name
 * */
class Library (val name:String) {
    
  /** books in the library*/
  val books: ArrayBuffer[Book] = new ArrayBuffer[Book]()
  
  /** Adds a book to the library
   * @param book Book to add to the library*/
  def addBook(book:Book): Unit = {
    books.addOne(book)
  }
  
  /** Remove a book from the library
   * @param book to remove from the library*/
  def removeBook(book: Book): Unit = {
    val index: Int = books.indexOf(book)
    books.remove(index)
  }

  /** Search if a book is available in the library
   * @param book the book to look for
   * @return a boolean, true if the book is in the library or false if not
   */
  def searchBook(book: Book): Boolean = {
    val index: Int = books.indexOf(book)
    return index >= 0                     // indexOf retorna -1 si es que no esta
  }
}
