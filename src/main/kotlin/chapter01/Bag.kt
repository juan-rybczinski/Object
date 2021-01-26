package chapter01

class Bag(
    private val amount: Long,
    private val invitation: Invitation?,
) {
    constructor(amount: Long) : this(amount, null)

    private var ticket: Ticket? = null

    private fun hasInvitation(): Boolean = invitation != null

    fun hasTicket(): Boolean = ticket != null

    private fun minusAmount(amount: Long) {
        this.amount - amount
    }

    fun plusAmount(amount: Long) {
        this.amount + amount
    }

    fun hold(ticket: Ticket): Long {
        return if (hasInvitation()) {
            this.ticket = ticket
            0L
        } else {
            minusAmount(ticket.fee)
            this.ticket = ticket
            ticket.fee
        }
    }
}