// Interface Playable
interface Playable {
    fun play()
}

// Class Cricket implementing Playable
class Cricket(val playersPerTeam: Int = 11) : Playable {
    override fun play() {
        println("Playing Cricket with $playersPerTeam players per team. Batting and bowling!")
    }
}

// Class Football implementing Playable
class Football(val matchDurationMinutes: Int = 90) : Playable {
    override fun play() {
        println("Playing Football for $matchDurationMinutes minutes. Kicking the ball to score goals!")
    }
}

fun main() {
    val cricketGame: Playable = Cricket()
    val footballGame: Playable = Football()

    println("--- Sports in Action ---")
    cricketGame.play()
    footballGame.play()
}
