package domain

// Abstracción de una Biblioteca
trait IBiblioteca:
  // Tiene un nombre, que lo identifica
  val nombre: String
  // Tiene una lista de Libros, puede que estén disponibles o prestados.
  var lista: List[ILibro]
  // Tiene maneras de incluír libros a la lista, o eliminarlos de ella.
  def enlistar(libro: ILibro): Unit
  def eliminar(libro: ILibro): Unit
  // Se puede buscar si un libro está enlistado o no
  def buscar(libro: ILibro): Boolean
  // Se puede pedir un libro prestado o devolverlo
  def pedir(libro: ILibro): Unit
  def devolver(libro: ILibro): Unit


