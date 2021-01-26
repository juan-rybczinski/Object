package chapter01

class TicketOffice(
    private var amount: Long,
    vararg tickets: Ticket
) {
    private var ticketList: MutableList<Ticket> = mutableListOf(*tickets)

    private fun getTicket(): Ticket = ticketList.removeAt(0)

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun sellTicketTo(audience: Audience) {
        plusAmount(audience.buy(getTicket()))
    }
}