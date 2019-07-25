package org.apache.struts.crud.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.crud.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * In memory data repository for Person objects.
 * 
 * @author bruce phillips
 * @author antonio sanchez
 */
@Repository("personDao")
public class MemoryPersonDao implements PersonDao {
    private static final Logger LOG = LogManager.getLogger(MemoryPersonDao.class.getName());

    @Autowired
    private final static List<Person> persons;

    static {
        persons = new ArrayList<>();
        persons.add(new Person(1L, "Bruce", "Phillips", "basketball", "male", MemoryPersonSupportDao.getCountry("US"), true, new String[]{"Ford", "Nissan"}, "bphillips@ku.edu", "123-456-9999"));
        persons.add(new Person(2L, "Antonio", "Sanchez", "mtb", "male", MemoryPersonSupportDao.getCountry("ES"), true, new String[]{"Toyota", "Seat"}, "asanchez@correo-e.es", "555-999-8888"));
    }

    @Override
    public Person getPerson(Long id) {
        for (Person p : persons) {
            if (p.getPersonId().equals(id)) {
                try {
                    return (Person) p.clone();
                } catch (CloneNotSupportedException ex) {
                    LOG.error("Unexpected exception cloning Person");
                }
            }
        }
        return null;
    }

    @Override
    public Person[] getAllPersons() {
        return persons.toArray(new Person[persons.size()]);
    }

    @Override
    public void updatePerson(Person person) {
        Long id = person.getPersonId();
        for (int i = 0; i < persons.size(); i++) {
            Person p = persons.get(i);
            if (p.getPersonId().equals(id)) {
                person.setCountry(MemoryPersonSupportDao.getCountry(person.getCountry().getCountryId()));
                persons.set(i, person);
                break;
            }
        }
    }

    @Override
    public void insertPerson(Person person) {
        long lastId = 0;
        for (Person p : persons) {
            if (p.getPersonId() > lastId) {
                lastId = p.getPersonId();
            }
        }
        person.setPersonId(lastId + 1);
        person.setCountry(MemoryPersonSupportDao.getCountry(person.getCountry().getCountryId()));
        persons.add(person);
    }

    @Override
    public void deletePerson(Long id) {
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            if (person.getPersonId().equals(id)) {
                persons.remove(i);
                break;
            }
        }
    }
}
