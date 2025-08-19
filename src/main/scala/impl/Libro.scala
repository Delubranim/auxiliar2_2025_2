package impl

import domain._

// Clase para Crear Libros
// Su constructor toma dos argumentos, el Título y el Autor
class Libro(
           val titulo: String,
           val autor: String
           ) extends ILibro:
  // Comienza NO estando prestado, por tanto, disponible
  var disponibilidad: Boolean = true

  // No comienza con biblioteca asignada
  var biblioteca: Option[IBiblioteca] = None

  // Se puede Leer
  def leer(): Unit =
    biblioteca match
      case Some(b) => println(this.toString+", Se encuentra en la "+b.toString+".")
      case None => println(this.toString+".")

  // Se puede enlistar en el catálogo de una Biblioteca
  def enlistar(biblio: IBiblioteca): Unit =
    biblioteca match
      case Some(b) => // Si tiene biblioteca asignada
        if b == biblio then // y ya está en el catálogo
          println(this.toString+" ha sido enlistado en el catálogo de "+b.toString+".")
        else // o está en otro catálogo
          println("Removiendo "+this.toString+" de la "+b.toString+" y enlistando en la "+biblio.toString+".")
          biblioteca = Some(biblio)
      case None => // Si no tiene biblioteca asignada
        println("Enlistando en la "+biblio.toString+".")
        biblio.enlistar(this)
        biblioteca = Some(biblio)

  // Se puede quitar del catálogo de una Biblioteca
  def eliminar(): Unit =
    biblioteca match
      case Some(b) => // Si está en una biblioteca
        println("Eliminando "+this.toString+" del catálogo de la "+b.toString)
        b.eliminar(this)
        biblioteca = None

      case None => // Si no está en una biblioteca
        println(this.toString+ " no pertenece a ninguna Biblioteca")

  // Se puede pedir prestado
  def prestar(): Unit =
    biblioteca match
      case Some(b) =>
        if disponibilidad then
          disponibilidad = false
          println("Has tomado prestado "+this.toString+", no olvides devolverlo :)")
        else
          println(s"Lamentablemente, "+this.toString+" no está disponible en estos momentos.")
      case None =>
        println("Este libro no tiene Biblioteca de la cual ser prestada.")

  // Y se puede devolver
  def devolver(): Unit =
    biblioteca match
      case Some(b) =>
        if !disponibilidad then
          disponibilidad = true
          println(s"Gracias por devolver "+this.toString+", esperamos verte pronto :)")
        else
          println("... de donde has sacado ese libro? te lo puedes quedar :o")
      case None =>
        println("Este libro no tiene Biblioteca a la cual ser devuelta.")


  // Dos libros son iguales si comparten título y autor
  override def equals(obj: Any): Boolean =
    if !obj.isInstanceOf[ILibro] then
      false
    else
      val libroComparado = obj.asInstanceOf[ILibro]
      libroComparado.titulo == titulo && libroComparado.autor == autor

  // Su representación en String es especial
  override def toString: String = s"'$titulo' de $autor"