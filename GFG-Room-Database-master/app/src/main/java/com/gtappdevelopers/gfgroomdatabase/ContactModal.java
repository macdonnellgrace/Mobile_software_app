package com.gtappdevelopers.gfgroomdatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//below line is for setting table name.
@Entity(tableName = "course_table")
public class ContactModal {

    //below line is to auto increment id for each course.
    @PrimaryKey(autoGenerate = true)
    //variable for our id.
    private int id;
    //below line is a variable for name.
    private String Name;
    //below line is use for surname.
    private String Surname;
    //below line is use for telephone.
    private String Telephone;

    //below line we are creating constructor class.
    //inside constructor class we are not passing our id because it is incrementing automatically
    public ContactModal(String Name, String Surname, String Telephone) {
        this.Name = Name;
        this.Surname = Surname;
        this.Telephone = Telephone;
    }

    //on below line we are creating getter and setter methods.
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        this.Telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
