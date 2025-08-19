package impl

import domain._

// Implementación de Clase para crear Bibliotecas
class Biblioteca(val nombre: String) extends IBiblioteca:
  // Tiene una lista de Libros, que comienza vacía
  var lista: List[ILibro] = List.empty
  // Se deben poder Incluír libros al listado
  def enlistar(libro: ILibro): Unit =
    if this.buscar(libro) then 
      println(libro.toString+" ya está en en catálogo de la "+this.toString)
    else
      lista = lista.appended(libro)
      libro.enlistar(this)
  // Se deben poder eliminar libros del listado
  def eliminar(libro: ILibro): Unit =
    if !this.buscar(libro) then
      println(libro.toString+" ya no está en el catálogo de la "+this.toString)
    else
      lista = lista diff List(libro)
      libro.eliminar()
  // Se debe poder buscar un libro en el listado
  def buscar(libro: ILibro): Boolean = lista.contains(libro)
  // Se puede pedir prestado un libro
  def pedir(libro: ILibro): Unit =
    if this.buscar(libro) then
      libro.prestar()
    else
      println(libro.toString+" no está en el catálogo de la "+this.toString)
  // Se puede devolver un libro a la biblioteca    
  def devolver(libro: ILibro): Unit =
    if this.buscar(libro) then
      libro.devolver()
    else
      println(libro.toString+" no pertenece al catálogo de la "+this.toString)
  // Su representación como String es especial
  override def toString: String = s"Biblioteca $nombre"