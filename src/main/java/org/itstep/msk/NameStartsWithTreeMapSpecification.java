package org.itstep.msk.FindByNameTreeMapSpecification;

import org.itstep.msk.Contact;

import java.util.Map;
import java.util.TreeMap;

public class NameStartsWithTreeMapSpecification implements TreeMapSpecification {

    private final String prefix;


    public NameStartsWithTreeMapSpecification(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public Iterable<Contact> read(TreeMap<String, Contact> mapContact) {
        TreeMap<String,Contact> map = new TreeMap<>();
        for(Map.Entry<String,Contact> m : mapContact.entrySet()){
            if(isSatisfying(m.getValue())){
                map.put(m.getKey(),m.getValue());
            }
        }
        return map.values();
    }

    @Override
    public void delete(TreeMap<String, Contact> mapContact) {
        for(Map.Entry<String,Contact> m:mapContact.entrySet()){
            if(isSatisfying(m.getValue())){
                mapContact.remove(m.getKey());
            }
        }
    }

    @Override
    public boolean isSatisfying(Contact contact) {
        String[] arr = contact.getName().split(" ");
        for(int i = 0;i<arr.length;i++){
            if(arr[i].startsWith(prefix)){
                return true;
            }
        }
        return false;
    }
}
