import kotlin.random.Random

enum class RSP(val value: String) {
    ROCK("바위"), PAPER("보자기"), SCISSORS("가위")
}

enum class RSPResult(val value: String) {
    WIN("플래이어 승리"), DREW("무승부"), DEFEAT("플래이어 패배")
}

class RSPmodel {
    var computerRSP: RSP = getrandomRSP()
    var userRSP: RSP = RSP.SCISSORS
    var gameResult: RSPResult = RSPResult.WIN

    private fun getrandomRSP(): RSP {
        var choices = RSP.values()
        return choices[Random.nextInt(choices.size)]
    }

    fun setUserRSP(userRSP: String) {

        this.userRSP = when (userRSP) {
            "ROCK" -> RSP.ROCK
            "SCISSORS" -> RSP.SCISSORS
            else -> RSP.PAPER
        }
    }

    fun saveResult() {
        setcpuRSP()
        this.gameResult = when {
            computerRSP == userRSP -> RSPResult.DREW
            (userRSP == RSP.ROCK && computerRSP == RSP.SCISSORS) ||
            (userRSP == RSP.SCISSORS && computerRSP == RSP.PAPER) ||
            (userRSP == RSP.PAPER && computerRSP == RSP.ROCK) -> RSPResult.WIN
            else -> RSPResult.DEFEAT
        }

    }

    fun setcpuRSP() {
        this.computerRSP = getrandomRSP()
    }

    fun getResult(): Triple<RSP, RSP, RSPResult> {
        return Triple(computerRSP, userRSP, gameResult)
    }
}


