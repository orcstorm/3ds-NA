import java.io.File

import scala.io.Source

case class Game(title: String, dev: String, pub: String, rd: String)
object Main extends App {

  var games = Vector.empty[Game]

  Source.fromFile(new File("3ds.tsv")).getLines().drop(2).foreach{ line =>
    val fields = line.split("\t")
    if(fields.size < 4) {
    } else {
      val game = new Game(fields(0), fields(1), fields(2), fields(3).substring(75))
      games = games ++ Vector(game)
    }
  }

  for(game <- games) { println(game.title) }

}