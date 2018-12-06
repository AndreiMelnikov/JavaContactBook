package org.itstep.msk;

import org.itstep.msk.FindByNameTreeMapSpecification.ContactSpecification;
import org.itstep.msk.FindByNameTreeMapSpecification.SpecificationContactBook;
import org.itstep.msk.contact_formatter.ContactFormatter;
import org.itstep.msk.contact_formatter_factory.AbstractContactFormatterFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Декоратор позволяющий работать со спецификациями
 * */

public class SpecificationContactFormatterDecorator implements Iterable<ContactFormatter> {

    private SpecificationContactBook contactBook;
    private ContactSpecification specification;
    private AbstractContactFormatterFactory factory;

    public SpecificationContactFormatterDecorator(SpecificationContactBook contactBook,
                                                  ContactSpecification specification,
                                                  AbstractContactFormatterFactory factory) {

        this.contactBook = contactBook;
        this.specification = specification;
        this.factory = factory;
    }


    @Override
    public Iterator<ContactFormatter> iterator() {
        List<ContactFormatter> list = new ArrayList<>();
        for(Contact con : contactBook.read(specification)){
            list.add(factory.getContactFormatter(con));
        }
        return list.iterator();
    }
}
