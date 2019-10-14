package by.epam.service.tag;

import by.epam.bean.Client;

public class byName {
    public static Client FindByName(Client obj, String name) {
        if (obj.getName().equals(name)){
            return obj;
        }
        else return null;
    }
}
