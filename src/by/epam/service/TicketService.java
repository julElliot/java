package by.epam.service;

import by.epam.bean.Ticket;
import by.epam.dao.TicketDao;

public class TicketService {
    private static TicketService ourInstance = new TicketService();

    public static TicketService getInstance() {
        return ourInstance;
    }

    private TicketService() {
    }


    public void create(Ticket ticket) {
        TicketDao ticketDao = TicketDao.getInstance();
        for (Ticket ticket1 : ticketDao.getTickets()) {
            if (ticket1.getId() == ticket.getId()) {
                return;
            }
        }
        ticketDao.add(ticket);
    }
}
