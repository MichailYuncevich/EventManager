package com.example.tonys.event;

/**
 * Created by TonyS
 */

class Event {
    private String  name,
            date,
            email,
            phoneNumber,
            description,
            category;

    Event(String nName, String nDate,
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
    public String getDate() {return date;}
}
