package org.itstep.msk.contact_formatter_factory;

import org.itstep.msk.Contact;
import org.itstep.msk.contact_formatter.ContactFormatter;
import org.itstep.msk.contact_formatter.StringContactFormatter;
import org.itstep.msk.contact_formatter_factory.AbstractContactFormatterFactory;

public class StringContactFormatterFactory implements AbstractContactFormatterFactory {
    int nameLength = 18;
    int phoneLength = 20;

    public StringContactFormatterFactory(){

    }

    public StringContactFormatterFactory(int nameLength,int phoneLength){
        this.nameLength = nameLength;
        this.phoneLength = phoneLength;
    }
    public ContactFormatter getContactFormatter(Contact origin){
        return new StringContactFormatter(origin,nameLength,phoneLength);
    }
}
