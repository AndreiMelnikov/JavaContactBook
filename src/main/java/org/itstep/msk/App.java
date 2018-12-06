package org.itstep.msk;

import org.itstep.msk.FindByNameTreeMapSpecification.*;
import org.itstep.msk.contact_book.*;
import org.itstep.msk.contact_formatter.*;
import org.itstep.msk.contact_formatter_factory.*;
import java.io.PrintWriter;
import java.util.*;

/**
 * Application main class
 *
 * @author Марк Михайлович
 * @version 1.0
 */
public final class App {
    /**
     * To print out contacts
     * Defines the main abstractions needed to do the job
     *
     * @param contactFormatters Iterable with contacts
     * @param writeTo PrintWriter to write to
     * */
    private static void printContacts(Iterable<ContactFormatter> contactFormatters, PrintWriter writeTo) {
        for (ContactFormatter cf : contactFormatters) {
            cf.print(writeTo);
            writeTo.println();
        }
        writeTo.flush();
    }

    public static void main( String[] args ) {
        ArrayList<Contact> contacts = new ArrayList<>(16);
        contacts.add(new Contact("Павел Иванович Чичиков","+13(900)999-99-99"));
        contacts.add(new Contact("Настасья Петровна Коробочка","+17(900) 999 99 99"));
        contacts.add(new Contact("Михаил Семёнович Сабакевич","8 900 999-99-99"));
        contacts.add(new Contact("Плюшкин","999-99-99"));
        contacts.add(new Contact("Манилов","999 99 99"));
        contacts.add(new Contact("Ноздрёв","8 (900) 999-99-99"));
        contacts.add(new Contact("Хлестаков Иван","+7(900)9999999"));
        contacts.add(new Contact("Земляника Артемий","+4 900 99999999"));
        contacts.add(new Contact("Шлёпкин Иван","8 800 8889999"));
        contacts.add(new Contact("Hercule Poirot","8 800 900 99 99"));
        contacts.add(new Contact("Mary Debenham","+19 900 999 99 99"));
        contacts.add(new Contact("Mrs. Hubbard","+23 900 999-99-99"));
//=======================================================================================
/**
 * Работа c фаилом (FileContactBook)
 * Необходимо прописать верный путь к фаилу
 * */

if(false) {
    SimpleContactBook fileContactBook = new FileContactBook(contacts, "D:\\Java\\ContactBookProject\\JavaContactBook-devel\\src\\FileContactBook.txt", " %% ");
    fileContactBook.commit();
    AbstractContactFormatterFactory factory1 = new FileContactFormatterFactory();
    Iterable<ContactFormatter> decoracor1 = new ContactFormatterIterableDecorator(fileContactBook.read(), factory1);
    printContacts(decoracor1, new PrintWriter(System.out));
}
//=======================================================================================
/**
* Работа со списками (ArrayContactBook)
* */

if(false){
    SimpleContactBook arrayContactBook = new ArrayContactBook(contacts);
    StringContactFormatterFactory factory2 = new StringContactFormatterFactory();
    Iterable<ContactFormatter> decoracor2 = new ContactFormatterIterableDecorator(arrayContactBook.read(), factory2);
    printContacts(decoracor2, new PrintWriter(System.out));
}
//=======================================================================================
/**
 * Работа c TreeMapContactBook и спецификациями
 * Спецификация поиска по имени(FindByNameTreeMapSpecification)
 * поиска по префиксу (NameStartsWithTreeMapSpecification)
 * */

//=======================================================================================
 if(false) {
     TreeMap<String, Contact> map = new TreeMap<>();
     for (Contact con : contacts) {
         map.put(con.getName(), con);
            }
     SpecificationContactBook treeMapBook = new TreeMapContactBook(map); //Получения Map из готового списка

     ContactSpecification specification1 = new FindByNameTreeMapSpecification("Иван");
     AbstractContactFormatterFactory factory3 = new StringContactFormatterFactory();
     Iterable<ContactFormatter> decorator3 = new SpecificationContactFormatterDecorator(treeMapBook, specification1, factory3);
     printContacts(decorator3, new PrintWriter(System.out));
     }
// =======================================================================================
 if(false) {
     TreeMap<String, Contact> map = new TreeMap<>();
     for (Contact con : contacts) {
          map.put(con.getName(), con);
          }

    SpecificationContactBook treeMapBook = new TreeMapContactBook(map); //Получения Map из готового списка

    ContactSpecification specification2 = new NameStartsWithTreeMapSpecification("Ив");
    AbstractContactFormatterFactory factory4 = new StringContactFormatterFactory();
    Iterable<ContactFormatter> decorator4 = new SpecificationContactFormatterDecorator(treeMapBook, specification2, factory4);
    printContacts(decorator4, new PrintWriter(System.out));
        }
    }
}
