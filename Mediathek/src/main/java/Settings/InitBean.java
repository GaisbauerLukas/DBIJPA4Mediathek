package Settings;

import DTO.*;

import javax.enterprise.context.ApplicationScoped;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    BillDTO billDTO;
    @Inject
    LocationDTO locationDTO;
    @Inject
    ActorDTO actorDTO;
    @Inject
    CustomerDTO customerDTO;
    @Inject
    StoreDTO storeDTO;
    @Inject
    EmployeeDTO employeeDTO;
    @Inject
    GenreDTO genreDTO;
    @Inject
    LendDTO lendDTO;
    @Inject
    MovieDTO movieDTO;
    @Inject
    StudioDTO studioDTO;
    @Inject
    CustomerDetailDTO customerDetailDTO;

    @Transactional
    private void init(@Observes @Initialized(ApplicationScoped.class) Object init){
        billDTO.readFromCSV();
        locationDTO.readFromCSV();
        customerDetailDTO.readFromCSV();
        customerDTO.readFromCSV();
        actorDTO.readFromCSV();
        employeeDTO.readFromCSV();
        storeDTO.readFromCSV();
        genreDTO.readFromCSV();
        lendDTO.readFromCSV();
        movieDTO.readFromCSV();
        studioDTO.readFromCSV();
    }

}
