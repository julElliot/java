package by.epam.presentation;

import by.epam.bean.Client;
import by.epam.bean.JobPosition;
import by.epam.bean.Staff;
import by.epam.dao.DaoClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static by.epam.dao.DaoClient.AddClientsFile;
import static by.epam.dao.DaoClient.ReadClientsFile;
import static by.epam.dao.DaoStaff.AddStuffFile;
import static by.epam.service.tag.byName.FindByName;
import static by.epam.dao.DaoStaff.ReadStuffFile;

public class Main {
    public static void main(String[] args) throws IOException {

        final String PATH_TO_CLIENT_FILE = "D:/Универ/5 семестр/Java/Lab1/Lab1/src/resourses/Clients.txt";
        final String PATH_TO_STAFF_FILE = "D:/Универ/5 семестр/Java/Lab1/Lab1/src/resourses/Staff.txt";
        Scanner scanner = new Scanner(System.in);
        int command = -1;

        List<Client> clients = new ArrayList<>();
        List<Staff> workers = new ArrayList<>();
        ArrayList<String> tempRecord;

        String name;
        String surname;
        String login;
        String password;
        int discount;
        int counter;

        Staff worker = new Staff();
        tempRecord = ReadStuffFile(PATH_TO_STAFF_FILE);
        counter = 0;
        for (int i = 0; i < (tempRecord.size()/4); i++){
            worker.setName(tempRecord.get(counter++));
            worker.setSurname(tempRecord.get(counter++));

            switch (tempRecord.get(counter++)){
                case "pilot":
                    worker.setJobPosition(JobPosition.pilot);
                    worker.setSalary(3000);
                    break;
                case "dispatcher":
                    worker.setJobPosition(JobPosition.dispatcher);
                    worker.setSalary(1500);
                    break;
                case "stewardess":
                    worker.setJobPosition(JobPosition.stewardess);
                    worker.setSalary(2000);
                    break;
                case "anotherOne":
                    worker.setJobPosition(JobPosition.anotherOne);
                    worker.setSalary(1000);
                    break;
            }
            counter++;
            workers.add(worker);
            worker = new Staff();
        }


        Client client = new Client();
        tempRecord = ReadClientsFile(PATH_TO_CLIENT_FILE);
        counter = 0;
        for (int i = 0; i < (tempRecord.size()/5); i++){
            client.setName(tempRecord.get(counter++));
            client.setSurname(tempRecord.get(counter++));
            client.setDiscount(Integer.parseInt(tempRecord.get(counter++)));
            client.setLogin(tempRecord.get(counter++));
            client.setPass(tempRecord.get(counter++));
            clients.add(client);
            client = new Client();
        }

        System.out.println("Доступные действия:\n" +
                "0. Выход\n" +
                "1. Добавить клиента\n" +
                "2. Изменить логин и пароль клиента\n" +
                "3. Удалить клиента \n" +
                "4. Отобразить всех клиентов \n" +
                "5. Найти клиентов по имени\n" +
                "6. Добавить сотрудника\n" +
                "7) Просмотреть текущих сотрудников\n" +
                "8) Сортировать клиентов по имени \n");
                /*"9) Уволить врача с данной проф. квалификацией\n");*/

        while (command != 0)
        {
            System.out.println("Выберите действие:");
            command = scanner.nextInt();
            scanner.nextLine();

            switch (command){
                case (0):
                    break;
                case (1):
                    System.out.println("Введите Ваше имя");
                    name = scanner.nextLine();
                    System.out.println("Введите Вашу фамилию");
                    surname = scanner.nextLine();
                    System.out.println("Введите Вашу скидку");
                    discount = Integer.parseInt( scanner.nextLine());
                    System.out.println("Введите логин");
                    login = scanner.nextLine();
                    System.out.println("Введите пароль");
                    password = scanner.nextLine();

                    client.setName(name);
                    client.setSurname(surname);
                    client.setDiscount(discount);
                    client.setLogin(login);
                    client.setPass(password);

                    clients.add(client);

                    AddClientsFile(PATH_TO_CLIENT_FILE, client, true);
                    break;
                case (2):
                    System.out.println("Введите старый логин");
                    String oldLogin = scanner.nextLine();
                    System.out.println("Введите старый пароль");
                    String oldPassword = scanner.nextLine();
                    System.out.println("Введите новый логин");
                    login = scanner.nextLine();
                    System.out.println("Введите новый пароль");
                    password = scanner.nextLine();

                    Client oldClient = new Client();
                    oldClient.setLogin(oldLogin);
                    oldClient.setPass(oldPassword);

                    for (int i = 0; i < clients.size(); i++) {
                        if (clients.get(i).getLogin().equals(oldClient.getLogin())){
                            if (clients.get(i).getPass().equals(oldClient.getPass())){
                                clients.get(i).setLogin(login);
                                clients.get(i).setPass(password);
                            }
                        }
                    }

                    PrintWriter pw = new PrintWriter(PATH_TO_CLIENT_FILE);
                    pw.close();
                    for (int i = 0; i < clients.size(); i++) {
                        AddClientsFile(PATH_TO_CLIENT_FILE, clients.get(i),true);
                    }
                    break;
                case (3):
                    System.out.println("Введите Вашу фамилию");
                    surname = scanner.nextLine();
                    System.out.println("Введите логин");
                    login = scanner.nextLine();
                    System.out.println("Введите пароль");
                    password = scanner.nextLine();

                    Client removeClient = new Client();
                    removeClient.setSurname(surname);
                    removeClient.setLogin(login);
                    removeClient.setPass(password);

                    for (int i = 0; i < clients.size(); i++) {
                        if (clients.get(i).getSurname().equals(removeClient.getSurname())){
                            if (clients.get(i).getLogin().equals(removeClient.getLogin())){
                                if (clients.get(i).getPass().equals(removeClient.getPass())){
                                    clients.remove(i);
                                }
                            }
                        }
                    }

                    PrintWriter pwDel = new PrintWriter(PATH_TO_CLIENT_FILE);
                    pwDel.close();
                    for (int i = 0; i < clients.size(); i++) {
                        AddClientsFile(PATH_TO_CLIENT_FILE, clients.get(i),true);
                    }
                    break;
                case (4):
                    ArrayList<String> records = ReadClientsFile(PATH_TO_CLIENT_FILE);

                    if (records != null)
                        for (String record : records) {
                            System.out.println(record);
                        }
                    break;
                case (5):
                    System.out.println("Введите имя для поиска");
                    name = scanner.nextLine();
                    Client foundedClient = new Client();

                    for (int i = 0; i < clients.size(); i++) {
                        foundedClient = FindByName(clients.get(i), name);
                        if (foundedClient != null){
                            System.out.println(foundedClient.toString());
                        }
                    }
                    break;
                case (6):
                    System.out.println("Введите Ваше имя");
                    name = scanner.nextLine();
                    System.out.println("Введите Вашу фамилию");
                    surname =  scanner.nextLine();
                    System.out.println("Введите Вашу должность");
                    String jobPosition = scanner.nextLine();

                    worker.setName(name);
                    worker.setSurname(surname);

                    switch (jobPosition){
                        case "pilot":
                            worker.setJobPosition(JobPosition.pilot);
                            worker.setSalary(3000);
                            break;
                        case "dispatcher":
                            worker.setJobPosition(JobPosition.dispatcher);
                            worker.setSalary(1500);
                            break;
                        case "stewardess":
                            worker.setJobPosition(JobPosition.stewardess);
                            worker.setSalary(2000);
                            break;
                        case "anotherOne":
                            worker.setJobPosition(JobPosition.anotherOne);
                            worker.setSalary(1000);
                            break;
                    }

                    workers.add(worker);
                    AddStuffFile(PATH_TO_STAFF_FILE, worker, true);
                    System.out.println(worker.toString());
                    break;
                case (7):
                    ArrayList<String> staffRecords = ReadStuffFile(PATH_TO_STAFF_FILE);

                    if (staffRecords != null)
                        for (String record : staffRecords) {
                            System.out.println(record);
                        }
                    break;
                case (8):
                    clients = DaoClient.SortByName(clients);

                    PrintWriter pwSorted = new PrintWriter(PATH_TO_CLIENT_FILE);
                    pwSorted.close();
                    for (int i = 0; i < clients.size(); i++) {
                        AddClientsFile(PATH_TO_CLIENT_FILE, clients.get(i),true);
                    }
                    break;
                /*case (9):
                    System.out.println(INPUT_QUALIFICATION);
                    speciality = scanner.nextLine();

                    stuff.removeDoctor(speciality);
                    break;*/
                default:
                    System.out.println("Неверная команда");
            }
        }
    }
}
