package org.itstep.msk.contact_formatter;

import java.io.PrintWriter;

/**
 * To print a contact to PrintStream given
 *
 * @author Марк Михайлович
 * @version 1.0
 * */
public interface ContactFormatter {
    void print(PrintWriter pw);
}
