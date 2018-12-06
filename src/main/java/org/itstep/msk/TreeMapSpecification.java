package org.itstep.msk.FindByNameTreeMapSpecification;

import org.itstep.msk.Contact;
import sun.reflect.generics.tree.Tree;

import java.util.TreeMap;

public interface TreeMapSpecification extends ContactSpecification {

    Iterable<Contact> read(TreeMap<String,Contact> mapContact);

    void delete(TreeMap<String,Contact> mapContact);
}
