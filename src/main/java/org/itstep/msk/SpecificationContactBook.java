package org.itstep.msk.FindByNameTreeMapSpecification;

import org.itstep.msk.Contact;
import org.itstep.msk.contact_book.SimpleContactBook;
import org.itstep.msk.contact_formatter.ContactFormatter;

public interface SpecificationContactBook extends SimpleContactBook {

        Iterable<Contact> read(ContactSpecification specification);

        SpecificationContactBook delete(ContactSpecification specification);
}
