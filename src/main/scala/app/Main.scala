package app

import impl._
import domain._

object Main {
  def main(args: Array[String]): Unit =
    val biblioteca1: IBiblioteca = new Biblioteca("Literary Cafe")
    val biblioteca2: IBiblioteca = new Biblioteca("Nacional")

    val libro1: ILibro = new Libro("1984","George Orwell")
    val libro2: ILibro = new Libro("El Señor de los Anillos", "J.R.R.")
    val libro3: ILibro = new Libro("Harry Potter y la Cámara de los Secretos", "J.K. Rowling")

    libro1.leer()
    biblioteca1.enlistar(libro1)
    biblioteca1.enlistar(libro2)
    biblioteca2.enlistar(libro2)
    biblioteca2.enlistar(libro3)

    biblioteca2.pedir(libro2)
    libro2.leer()



}
