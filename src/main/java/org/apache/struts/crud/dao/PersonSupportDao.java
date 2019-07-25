package org.apache.struts.crud.dao;

//import java.util.Map;
import org.apache.struts.crud.model.Country;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Methods a PersonSupportDao class must implement to provide
 * additional information related to a Person.
 * 
 * @author bruce phillips
 * @author antonio sánchez
 */

public interface PersonSupportDao {
    @Autowired
    Country[] getCountries();
    @Autowired
    String[] getCarModels();
    @Autowired
    String[] getSports();
    @Autowired
    String[] getGenders();
    
}
