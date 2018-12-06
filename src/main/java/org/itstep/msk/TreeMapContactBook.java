package org.itstep.msk.FindByNameTreeMapSpecification;

import org.itstep.msk.Contact;
import org.itstep.msk.contact_book.SimpleContactBook;
import org.itstep.msk.contact_formatter.ContactFormatter;

import java.util.Collections;
import java.util.TreeMap;

public class TreeMapContactBook implements SpecificationContactBook {

    private final TreeMap<String,Contact> mapContact;

    public TreeMapContactBook(TreeMap<String, Contact> mapContact) {
        this.mapContact = mapContact;
    }

    @Override
    public Iterable<Contact> read(ContactSpecification specification) {
        if(((TreeMapSpecification) specification).read(mapContact).equals(Collections.emptyList())){
            System.out.println("Совпадений не найдено");
        }
        return ((TreeMapSpecification) specification).read(mapContact);
    }

    @Override
    public SpecificationContactBook delete(ContactSpecification specification) {
        ((TreeMapSpecification) specification).delete(mapContact);
        return this;
    }

    @Override
    public Contact create(String name, String phoneNumber) {
        Contact contact = new Contact(name,phoneNumber);
        mapContact.put(contact.getName(),contact);
        return contact;
    }

    @Override
    public SimpleContactBook delete(Contact c) {
        mapContact.remove(c.getName());
        return this;
    }

    @Override
    public Iterable<Contact> read() {
        return mapContact.values();
    }

    @Override
    public SimpleContactBook commit() {
        return null;
    }
}
