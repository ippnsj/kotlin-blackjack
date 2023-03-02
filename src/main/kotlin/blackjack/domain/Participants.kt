package blackjack.domain

class Participants(private val dealer: Dealer, private val players: Players) {
    fun drawAll(deck: CardDeck) {
        dealer.addCard(deck.draw())
        players.drawAll(deck)
    }

    fun getGameResults(): Map<String, String> = players.toList().associate {
        it.name to GameResult.judgePlayer(dealer.getTotalScore(), it.getTotalScore()).name
    }
}
