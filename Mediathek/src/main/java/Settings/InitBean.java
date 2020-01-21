package Settings;

import DTO.CustomerDTO;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class InitBean {

    @Inject
    CustomerDTO customerDTO;

    public InitBean() {
        //customerDTO.readFromCSV();
    }

    @PostConstruct
    private void init() {
    }
}
