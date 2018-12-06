package org.itstep.msk.contact_formatter_factory;

import org.itstep.msk.Contact;
import org.itstep.msk.contact_formatter.ContactFormatter;

/**
 * Интерфейс создания ContactFormatter
 * */

public interface AbstractContactFormatterFactory {

    ContactFormatter getContactFormatter(Contact origin);
}
