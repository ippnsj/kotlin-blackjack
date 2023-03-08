package blackjack.domain

class PlayerResults(private val results: Map<String, GameResult>) {

    fun get(): List<PlayerResult> = results.map { (name, result) -> PlayerResult(name, result) }

    fun getDealerResult(): Map<GameResult, Int> {
        with(results.values) {
            val win = count { it == GameResult.LOSE }
            val draw = count { it == GameResult.DRAW }
            val lose = count { it == GameResult.WIN }
            return GameResult.values().zip(listOf(win, draw, lose)).toMap()
        }
    }
}
