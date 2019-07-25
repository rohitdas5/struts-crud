package org.apache.struts.crud.service;

import org.apache.struts.crud.dao.MemoryPersonDao;
import org.apache.struts.crud.dao.MemoryPersonSupportDao;
import org.apache.struts.crud.dao.PersonDao;
import org.apache.struts.crud.dao.PersonSupportDao;
import org.apache.struts.crud.model.Country;
import org.apache.struts.crud.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implement Services needed to edit and save
 * a Person object's state.  
 * 
 * @author bruce phillips
 * @author antonio sanchez
 */
@Service
public class DefaultPersonService implements PersonService {

    @Autowired
    PersonDao personDao; 
    PersonSupportDao personSupportDao; 
    
    public DefaultPersonService() {
        personDao = new MemoryPersonDao();
        personSupportDao = new MemoryPersonSupportDao();
    }

    @Override
    public Person getPerson(Long id) {
        return personDao.getPerson(id);
    }

    @Override
    public Person[] getAllPersons() {
        return personDao.getAllPersons();
    }

    @Override
    public void updatePerson(Person personBean) {
        personDao.updatePerson(personBean);
    }

    @Override
    public void insertPerson(Person personBean) {
        personDao.insertPerson(personBean);
    }

    @Override
    public void deletePerson(Long id) {
        personDao.deletePerson(id);
    }

    @Override
    public Country[] getCountries() {
        return personSupportDao.getCountries();
    }

    @Override
    public String[] getCarModels() {
        return personSupportDao.getCarModels();
    }

    @Override
    public String[] getSports() {
        return personSupportDao.getSports();
    }

    @Override
    public String[] getGenders() {
        return personSupportDao.getGenders();
    }
}
