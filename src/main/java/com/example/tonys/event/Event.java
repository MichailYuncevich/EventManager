package com.example.tonys.event;

/**
 * Created by TonyS on 16-May-17.
 */

public class Event {
    private String  name,
            date,
            email,
            phoneNumber,
            description,
            category;

    public Event(String nName,String nDate,
                 String nEmail, String nPhoneNumber,
                 String nDescription, String nCategory){
        name = nName;
        date = nDate;
        email = nEmail;
        phoneNumber = nPhoneNumber;
        description = nDescription;
        category = nCategory;
    }

    public String getName(){
        return name;
    }
}
