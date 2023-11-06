package com.gtappdevelopers.gfgroomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ContactRepository {
    //below line is the create a variable for dao and list for all contacts.
    private Dao dao;
    private LiveData<List<ContactModal>> allContacts;

    //creating a constructor for our variables and passing the variables to it.
    public ContactRepository(Application application) {
        ContactDatabase database = ContactDatabase.getInstance(application);
        dao = database.Dao();
        allContacts = dao.getAllCourses();
    }

    //creating a method to insert the data to our database.
    public void insert(ContactModal model) {
        new InsertContactAsyncTask(dao).execute(model);
    }

    //creating a method to update data in database.
    public void update(ContactModal model) {
        new UpdateContactAsyncTask(dao).execute(model);
    }

    //creating a method to delete the data in our database.
    public void delete(ContactModal model) {
        new DeleteContactAsyncTask(dao).execute(model);
    }

    //below is the method to delete all the contacts.
    public void deleteAllContacts() {
        new DeleteAllContactAsyncTask(dao).execute();
    }

    //below method is to read all the contacts.
    public LiveData<List<ContactModal>> getAllContacts() {
        return allContacts;
    }

    //we are creating a async task method to insert new course.
    private static class InsertContactAsyncTask extends AsyncTask<ContactModal, Void, Void> {
        private Dao dao;

        private InsertContactAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(ContactModal... model) {
            //below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }

    //we are creating a async task method to update our contacts.
    private static class UpdateContactAsyncTask extends AsyncTask<ContactModal, Void, Void> {
        private Dao dao;

        private UpdateContactAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(ContactModal... models) {
            //below line is use to update our modal in dao.
            dao.update(models[0]);
            return null;
        }
    }

    //we are creating a async task method to delete contacts
    // .
    private static class DeleteContactAsyncTask extends AsyncTask<ContactModal, Void, Void> {
        private Dao dao;

        private DeleteContactAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(ContactModal... models) {
            //below line is use to delete our contact modal in dao.
            dao.delete(models[0]);
            return null;
        }
    }

    //we are creating a async task method to delete all contacts.
    private static class DeleteAllContactAsyncTask extends AsyncTask<Void, Void, Void> {
        private Dao dao;

        private DeleteAllContactAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //on below line calling method to delete all contacts.
            dao.deleteAllCourses();
            return null;
        }
    }
}
