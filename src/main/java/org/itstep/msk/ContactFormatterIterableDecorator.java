package org.itstep.msk;

import org.itstep.msk.contact_formatter.ContactFormatter;
import org.itstep.msk.contact_formatter_factory.AbstractContactFormatterFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Декоратор без спецификаций
 * */

public final class ContactFormatterIterableDecorator implements Iterable<ContactFormatter> {

    private final Iterable<Contact> origin;
    private AbstractContactFormatterFactory factory;

    public ContactFormatterIterableDecorator(Iterable<Contact> origin,AbstractContactFormatterFactory factory) {
        this.origin = origin;
        this.factory = factory;
    }

    @Override
    public Iterator<ContactFormatter> iterator() {
        List<ContactFormatter> list = new ArrayList<>();
        for(Contact con : origin){
            list.add(factory.getContactFormatter(con));
        }
        return list.iterator();
    }
}
