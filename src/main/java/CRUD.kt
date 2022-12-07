import org.litote.kmongo.coroutine.projection
import org.litote.kmongo.eq
import org.litote.kmongo.setValue

suspend fun addJedi(jedi: Jedi) = jedi_col.insertOne(jedi)

suspend fun upDateJedi(jediOld: Jedi, jediNew: Jedi) {
    val jediName = jediOld.name
    jedi_col.updateOne(Jedi::name eq jediName, setValue(Jedi::age, jediNew.age))
    jedi_col.updateOne(Jedi::name eq jediName, setValue(Jedi::name, jediNew.name))
}

suspend fun killJedi(jedi: Jedi) = jedi_col.deleteOne(Jedi::name eq jedi.name)

suspend fun locateJedi(jedi: Jedi) {
    val jediFound: Jedi? = jedi_col.findOne(Jedi::name eq jedi.name)

    if (jediFound != null) println("${jedi.name}, ${jedi.age}") else println("${jedi.name} escaped the galaxy")
}

suspend fun addSith(sith: Sith) = sith_col.insertOne(sith)

suspend fun updateSith(sithOld: Sith, sithNew: Sith) {
    val sithName = sithOld.name
    sith_col.updateOne(Sith::name eq sithName, setValue(Sith::age, sithNew.age))
    sith_col.updateOne(Sith::name eq sithName, setValue(Sith::name, sithNew.name))
}

suspend fun killSith(sith: Sith) = sith_col.deleteOne(Sith::name eq sith.name)

suspend fun locateSith(sith: Sith) {
    val sithFond: Sith? = sith_col.findOne(Sith::name eq sith.name)

    if (sithFond != null) println("${sith.name}, ${sith.age}") else println("${sith.name} escape the galaxy")
}

suspend fun listJediName() {
    val jediList: List<String> = jedi_col.projection(Jedi::name).toList().sorted()

    println("JEDI LIST:")
    for (jedi in jediList) {
        println("→ $jedi")
    }
}

suspend fun listSithName() {
    val sithList: List<String> = sith_col.projection(Sith::name).toList().sorted()

    println("SITH LIST:")
    // * Same as above but with forEach()
    sithList.forEach { println("→ $it") }
}

suspend fun jediList() {
    val jediName = jedi_col.projection(Jedi::name).toList()
    val jediAge = jedi_col.projection(Jedi::age).toList()
    val jediList = jediName.zip(jediAge) { a, b -> "$a, $b" }

    println("Detailed Jedi List")
    jediList.forEach { println("→ $it") }
}

suspend fun sithList() {
    val sithName = sith_col.projection(Sith::name).toList()
    val sithAge = sith_col.projection(Sith::age).toList()
    val sithList = sithName.zip(sithAge) { a, b -> "$a, $b" }

    println("Detailed Sith List")
    sithList.forEach { println("→ $it") }
}



