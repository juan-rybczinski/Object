class Bag(
    private val amount: Long,
    private val invitation: Invitation?,
) {
    constructor(amount: Long) : this(amount, null)

    var ticket: Ticket? = null

    fun hasInvitation(): Boolean = invitation != null

    fun hasTicket(): Boolean = ticket != null

    fun minusAmount(amount: Long) {
        this.amount - amount
    }

    fun plusAmount(amount: Long) {
        this.amount + amount
    }
}