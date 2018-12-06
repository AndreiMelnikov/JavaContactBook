package org.itstep.msk.contact_formatter_factory;

import org.itstep.msk.Contact;
import org.itstep.msk.contact_formatter.ContactFormatter;
import org.itstep.msk.contact_formatter.FileContactFormatter;
import org.itstep.msk.contact_formatter_factory.AbstractContactFormatterFactory;

public class FileContactFormatterFactory implements AbstractContactFormatterFactory {

    String splitItem = " %% ";

    public FileContactFormatterFactory() {
    }

    public FileContactFormatterFactory(String splitItem) {
        this.splitItem = splitItem;
    }

    @Override
    public ContactFormatter getContactFormatter(Contact origin) {
        return new FileContactFormatter(origin,splitItem);
    }
}
