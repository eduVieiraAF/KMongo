import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo


val client = KMongo.createClient().coroutine
val database = client.getDatabase("test")
val jedi_col = database.getCollection<Jedi>()
val sith_col = database.getCollection<Sith>()
