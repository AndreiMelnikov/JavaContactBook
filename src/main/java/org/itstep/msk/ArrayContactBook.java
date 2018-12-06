package org.itstep.msk.contact_book;

import org.itstep.msk.Contact;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The most simple implementation of the contact repository
 * It stores the data in the ArrayList
 * Might be useful for testing
 *
 * @author Марк Михайлович
 * @version 1.0
 * */
public final class ArrayContactBook implements SimpleContactBook {
    private final ArrayList<Contact> contacts;


    public ArrayContactBook(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public Contact create(String name, String phoneNumber) {
        contacts.add(new Contact(name,phoneNumber));
        return contacts.get(contacts.size()-1);
    }

    @Override
    public SimpleContactBook delete(Contact c) {
        contacts.remove(c);
        return this;
    }

    @Override
    public Iterable<Contact> read() {
        return Collections.unmodifiableCollection(contacts);
    }

    @Override
    public SimpleContactBook commit() {
        return null;
    }
}
