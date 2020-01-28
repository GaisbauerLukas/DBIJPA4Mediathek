package Settings;

import DTO.*;
import Entity.Bill;
import Entity.Employee;
import Entity.Location;

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
import java.util.LinkedList;
import java.util.List;

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
        //Store
        //billDTO.readFromCSV();
        //locationDTO.readFromCSV();
        //employeeDTO.readFromCSV();
        //storeDTO.readFromCSV();

        /*  debugZone
        //Lend
        customerDetailDTO.readFromCSV();
        customerDTO.readFromCSV();
        //lendDTO.readFromCSV();


        //Movie
        actorDTO.readFromCSV();
        genreDTO.readFromCSV();
        studioDTO.readFromCSV();
        //movieDTO.readFromCSV();
        */

    }

    public void insertTestdata(){
        //Bill
        List<Bill> bills = new LinkedList<Bill>();
        bills.add(new Bill("Scary Movie", 11.50));
        bills.add(new Bill("Avanger", 22.10));
        bills.add(new Bill("American Sniper", 55));

        //employees
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Herbert Miller"));
        employees.add(new Employee("Anette Frank"));

        //Location
        Location locations = new Location("Österreich", "Wels");



    }

}
