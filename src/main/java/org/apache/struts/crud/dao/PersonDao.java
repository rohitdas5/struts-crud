package org.apache.struts.crud.dao;

import org.apache.struts.crud.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Data access methods that a PersonDao class
 * must define to provide information about
 * a Person or collection of Person objects.
 * 
 * @author bruce phillips
 * @author antonio sánchez
 */

public interface PersonDao {

    @Autowired
    Person getPerson(Long id);
    @Autowired
    Person[] getAllPersons();
    @Autowired
    void updatePerson(Person personBean);
    @Autowired
    void insertPerson(Person personBean);
    @Autowired
    void deletePerson(Long id);
}
