package Settings;

import DTO.*;

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

    public InitBean() {
        billDTO.readFromCSV();
        locationDTO.readFromCSV();
        actorDTO.readFromCSV();
        customerDTO.readFromCSV();
        storeDTO.readFromCSV();
        employeeDTO.readFromCSV();
        genreDTO.readFromCSV();
        lendDTO.readFromCSV();
        movieDTO.readFromCSV();
        storeDTO.readFromCSV();
    }

    @PostConstruct
    private void init() {
    }
}
