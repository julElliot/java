package by.epam.dao;

import by.epam.bean.Staff;

import java.io.*;
import java.util.ArrayList;

public class DaoStaff {
    public static void AddStuffFile(String pathToFile, Staff worker, boolean flag) throws IOException {
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
                    worker.getName() + "\n"
                            + worker.getSurname() + "\n"
                            + worker.getJobPosition() + "\n"
                            + worker.getSalary() + "\n");
        }
        finally {
            fw.close();
        }
    }

    public static ArrayList<String> ReadStuffFile(String pathToFile) throws IOException {

        ArrayList<String> records = new ArrayList();
        String name;
        String surname;
        String jobPosition;
        String salary;

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
                jobPosition = br.readLine();
                salary = br.readLine();
                if (name != null && surname != null && jobPosition!= null && salary!= null)
                {
                    records.add(name);
                    records.add(surname);
                    records.add(jobPosition);
                    records.add(salary);
                }
            } while (name != null && surname != null && jobPosition!= null && salary!= null);
        }
        finally {
            fr.close();
            br.close();
        }

        return records;
    }
}
