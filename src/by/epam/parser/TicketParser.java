package by.epam.parser;

import by.epam.bean.Ticket;

import java.util.ArrayList;

public class TicketParser {
    private static TicketParser ourInstance = new TicketParser();

    public static TicketParser getInstance() {
        return ourInstance;
    }

    private TicketParser() {
    }

    public ArrayList<Ticket> parseTickets(String path) {
        ArrayList<Ticket> tickets = new ArrayList<>();

        return null;
    }
}
