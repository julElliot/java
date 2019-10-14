package by.epam.dao;

import by.epam.bean.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DaoClient {

    public static void AddClientsFile(String pathToFile, Client client, boolean flag) throws IOException {
        FileWriter fw;
        if (flag) {
            fw = new FileWriter(pathToFile, true);
        }
        else
        {
            fw = new FileWriter(pathToFile, false);
        }

        try {
            fw.write(
                    client.getName() + "\n"
                    + client.getSurname() + "\n"
                    + client.getDiscount() + "\n"
                    + client.getLogin() + "\n"
                    + client.getPass() + "\n");
        }
        finally {
            fw.close();
        }
    }

    public static ArrayList<String> ReadClientsFile(String pathToFile) throws IOException {

        ArrayList<String> records = new ArrayList();
        String name;
        String surname;
        String login;
        String pass;
        String discount;

        if (pathToFile == null)
        {
            throw new ExceptionInInitializerError("Incorrect path was received in bean.Stuff class constructor.");
        }

        File f = new File(pathToFile);
        if(!f.exists())
        {
            //f.createNewFile();
            return null;
        }

        FileReader fr = new FileReader(pathToFile);
        BufferedReader br = new BufferedReader(fr);

        try {
            do {
                name = br.readLine();
                surname = br.readLine();
                discount = br.readLine();
                login = br.readLine();
                pass = br.readLine();
                if (name != null && surname != null && discount!= null && login!= null && pass!= null)
                {
                    records.add(name);
                    records.add(surname);
                    records.add(discount);
                    records.add(login);
                    records.add(pass);
                }
            } while (name != null && surname != null && discount!= null && login!= null && pass!= null);
        }
        finally {
            fr.close();
            br.close();
        }

        return records;
    }

    public static int compare(Client client, Client comparedClient) {
        return client.getName().compareTo(comparedClient.getName()) ;
    }

    public  static List<Client> SortByName (List<Client> clients )  {

           Client swap ;

        for ( int i = 0 ; i < clients.size()-1; i++) {
            for (int j = 0; j < clients.size() - i - 1; j++) {
                int g = compare(clients.get(j), clients.get(j + 1)) ;
                while (compare(clients.get(j), clients.get(j + 1)) > 0 ) {

                    swap = (Client) clients.get(j);


                    clients.set(j, clients.get(j + 1));
                    clients.set(j + 1, swap);
                }
            }
        }

        return clients ;

    }
}
