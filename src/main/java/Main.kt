import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val jedi1 = Jedi("unknown", 20)
        //val jedi2 = Jedi("Luke Skywalker", 52)

        // val sith1 = Sith("Darth Bane", 65)
        // val sith2 = Sith("Darth Vader", 48)

        // addJedi(jedi1)
        // upDateJedi(Jedi("Luke Skywalker", 21), jedi2)
        //locateJedi(jedi1)
        // killJedi(jedi1)

        // addSith(sith1)
        // updateSith(Sith("Dartth Vader", 48), sith2)
        // locateSith(sith2)
        // killSith(sith1)

        // listJediName()
        // listSithName()
        jediList()
        sithList()


    }
}