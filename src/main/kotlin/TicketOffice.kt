class TicketOffice(
    private var amount: Long,
    vararg tickets: Ticket
) {
    private var ticketList: MutableList<Ticket> = mutableListOf(*tickets)

    fun getTicket(): Ticket = ticketList.removeAt(0)

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}