package by.epam.dao;

import by.epam.bean.Ticket;

import java.util.ArrayList;

public class TicketDao {
    private static TicketDao ourInstance = new TicketDao();

    public static TicketDao getInstance() {
        return ourInstance;
    }

    private TicketDao() {
    }

    private ArrayList<Ticket> tickets = new ArrayList<>();


    public void add(Ticket ticket) {
        if (ticket != null) {

            for (Ticket ticket1 : tickets) {
                if (ticket1.equals(ticket)) {
                    return;
                }
            }
            tickets.add(ticket);
        }
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

}
