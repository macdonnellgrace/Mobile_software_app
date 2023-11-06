package com.gtappdevelopers.gfgroomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModal extends AndroidViewModel {
    //creating a new variable for course repository.
    private ContactRepository repository;
    //below line is to create a variable for live data where all the courses are present.
    private LiveData<List<ContactModal>> allContacts;

    //constructor for our view modal.
    public ViewModal(@NonNull Application application) {
        super(application);
        repository = new ContactRepository(application);
        allContacts = repository.getAllContacts();
    }


    //below method is use to insert the data to our repository.
    public void insert(ContactModal model) {
        repository.insert(model);
    }

    //below line is to update data in our repository.
    public void update(ContactModal model) {
        repository.update(model);
    }

    //below line is to delete the data in our repository.
    public void delete(ContactModal model) {
        repository.delete(model);
    }

    //below method is to delete all the courses in our list.
    public void deleteAllContacts() {
        repository.deleteAllContacts();
    }

    //below method is to get all the courses in our list.
    public LiveData<List<ContactModal>> getAllContacts() {
        return allContacts;
    }
}
