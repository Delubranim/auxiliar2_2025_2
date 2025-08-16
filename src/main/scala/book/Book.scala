package book
// package book indica el paquete en el que se encuentra este archivo

import library.Library
/*De manera semejante a python, importamos la clase library que definimos en su package correspondiente para usarla.
* Notese lo importante que es nombrar correctamente los package y archivos, para no confundirlos se nombra
* las clases\interfaces capitalizado (primera letra mayuscula) para distinguirlo del package que esta en minusculas
* Ademas recuerden no usar (-) (_) pues puede traer errores en algunos SO */

/* Recuerden siempre documentar su codigo. Para documentar clases primero escriban una pequeña descripcion
* de lo que representa, responsabilidades, etc.
* Seguido de esto va la documentacion del constructor que tiene: los parametros que recibe y que hace*/

/** Represents a book
 * @param title Title of the book.
 * @param author  Author of the book
 *
 * @constructor creates a new book with the specified title and author
 * */
class Book (val title: String, val author:String){
  /* (val title:String, val author:String) es el constructor de la clase que definimos, los parametros seran
  * los atributos que se le asignaran a la instancia de la clase al momento de crearse.*/
  // Notar que en este caso, un libro no cambiara su titulo o autor, por lo que se definen como ´val´
  // Tambien, el atributo que indica si esta disponible no se define en el constructor, pues es un atributo estandar
  // que se inicializara igual en todos los libros (asumamos que inician disponibles por simplicidad).

  // Para documentar atributos (val o var) basta con una simple descripcion

  /** State of the book * */
  var available: Boolean = true

  /** Library where the book is **/
  var library: Library = null

  // Para documentar metodos es la misma idea que para el constructor

  /** Change the book status to unavailable */
  def takeBook(): Unit = {
    available = false
  }
  
  /** Change the book status to available */
  def retunBook(): Unit = {
    available = true
  }
  
  /** Add the book to a library 
   * @param newLibrary library to add to*/
  def addToLibrary(newLibrary: Library): Unit = {
    library = newLibrary
    library.addBook(this)
  }

  /** remove the book from his library*/
  def removeFromLibrary(): Unit = {
    library.removeBook(this)
    library = null
  }
  
  
}
