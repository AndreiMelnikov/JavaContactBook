package org.itstep.msk.contact_book;

import org.itstep.msk.*;
import org.itstep.msk.contact_formatter.ContactFormatter;
import org.itstep.msk.contact_formatter_factory.AbstractContactFormatterFactory;
import org.itstep.msk.contact_formatter_factory.FileContactFormatterFactory;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

public class FileContactBook implements SimpleContactBook {

    private final ArrayList<Contact> contacts;
    private final String filePath;
    String splitItem;
    AbstractContactFormatterFactory factory;

    public FileContactBook(ArrayList<Contact> contacts, String filePath,String splitItem) {
        this.contacts = contacts;
        this.filePath = filePath;
        this.splitItem = splitItem;
    }


    @Override
    public Contact create(String name, String phoneNumber) {
       contacts.add(new Contact(name,phoneNumber));
       return contacts.get(contacts.size()-1);
    }

    @Override
    public SimpleContactBook delete(Contact c) {
        contacts.remove(c);
        return null;
    }

    @Override
    public Iterable<Contact> read() {
        String line;
        int c;
        contacts.clear();
        File file = new File(filePath);
        if(file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//                br.lines().forEach((String s) -> {
//                    String[] arr = s.split(splitItem);
//                    contacts.add(new Contact(arr[0], arr[1]));
//                });
                while ((line = br.readLine())!=null){
                    String[] arr = line.split(splitItem);
                    contacts.add(new Contact(arr[0],arr[1]));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Фаил с таким именем не найден");
        }
        return Collections.unmodifiableCollection(contacts);
    }

    @Override
    public SimpleContactBook commit() {
        File file = new File(filePath);
        factory = new FileContactFormatterFactory(splitItem);
        if(file.exists()){
            try(PrintWriter pw = new PrintWriter(file)){
                for(Contact con : contacts){
                    ContactFormatter fileContactFormatter = factory.getContactFormatter(con);
                    fileContactFormatter.print(pw);
                    pw.flush();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Фаил с таким именем не найден");
        }

        return null;
    }
}
