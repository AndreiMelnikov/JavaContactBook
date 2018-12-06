package org.itstep.msk;

/**
 * An entity to store data relevant for contact
 *
 * @author Марк Михайлович
 * @version 1.0
 * */
public final class Contact {
    private final String name;
    private final String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return name+" "+phone;
    }
}
