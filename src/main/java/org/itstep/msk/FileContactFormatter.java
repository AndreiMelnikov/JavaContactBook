package org.itstep.msk.contact_formatter;

import org.itstep.msk.Contact;
import org.itstep.msk.contact_formatter.ContactFormatter;

import java.io.PrintWriter;

public class FileContactFormatter implements ContactFormatter {

    private final Contact origin;
    String splitItem;

    public FileContactFormatter(Contact origin, String splitItem) {
        this.origin = origin;
        this.splitItem = splitItem;
    }

    @Override
    public void print(PrintWriter pw) {
       pw.write(origin.getName()+splitItem+origin.getPhone());
       pw.println();
    }
}
