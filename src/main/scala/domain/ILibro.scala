package domain

// Abstracción de un Libro
trait ILibro:
  // Tiene un Título y un Autor, que definen en conjunto su identidad, se puede leer
  val titulo: String
  val autor: String
  def leer(): Unit
  // Pertenece a una biblioteca, donde está o disponible o prestado
  var biblioteca: Option[IBiblioteca]
  var disponibilidad: Boolean
  // Puede ser enlistado o eliminado de una biblioteca, y puede ser prestado o devuelto
  def enlistar(biblio: IBiblioteca): Unit
  def eliminar(): Unit
  def prestar(): Unit
  def devolver(): Unit
  


