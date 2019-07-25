package org.apache.struts.crud.service;

import org.apache.struts.crud.model.Country;
import org.apache.struts.crud.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Define methods a PersonService must implement
 * to provide services related to a Person class.
 * 
 * @author bruce phillips
 * @author antonio sánchez
 */
public interface PersonService {
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
    @Autowired
    Country[] getCountries();
    @Autowired
    String[] getCarModels();
    @Autowired
    String[] getSports();
    @Autowired
    String[] getGenders();
}