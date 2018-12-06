package org.itstep.msk.contact_formatter;

import org.itstep.msk.Contact;
import org.itstep.msk.contact_formatter.ContactFormatter;

import java.io.PrintWriter;

/**
 * Prints a Contact object to the PrintWriter given as a simple string
 *
 * @author Марк Михайлович
 * @version 1.0
 * */
public final class StringContactFormatter implements ContactFormatter {
    private final Contact origin;
    private final int nameLength, phoneLength;

    public StringContactFormatter(Contact origin, int nameLength, int phoneLength) {
        this.origin = origin;
        this.nameLength = nameLength;
        this.phoneLength = phoneLength;
    }

    /**
     * Cuts the string to the size set in constructor and prints name with a phone to the PrintWriter given
     *
     * @param writeTo the PrintWriter to print name and phone
     * */
    @Override
    public void print(PrintWriter writeTo) {
        StringBuilder nameBuilder = new StringBuilder(origin.getName());
        if (nameBuilder.length() >= nameLength) {
            nameBuilder.setLength(nameLength-1);
            nameBuilder.append('\u2026');
        }

        writeTo.write(String.format("%-"+nameLength+"s",nameBuilder.toString())+"    "+origin.getPhone());
    }
}
