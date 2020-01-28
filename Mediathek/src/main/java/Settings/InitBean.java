package Settings;

import DTO.*;
import Entity.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class InitBean {

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    BillDAO billDAO;
    @Inject
    LocationDAO locationDAO;
    @Inject
    ActorDAO actorDAO;
    @Inject
    CustomerDAO customerDAO;
    @Inject
    StoreDAO storeDAO;
    @Inject
    EmployeeDAO employeeDAO;
    @Inject
    GenreDAO genreDAO;
    @Inject
    LendDAO lendDAO;
    @Inject
    MovieDAO movieDAO;
    @Inject
    StudioDAO studioDAO;
    @Inject
    CustomerDetailDAO customerDetailDAO;

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

        insertTestdata();

    }

    public void insertTestdata(){

        // Region Store

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

        bills.forEach(entityManager::persist);
        employees.forEach(entityManager::persist);
        entityManager.persist(locations);
        //EndRegion Store

        //Region Lend
        CustomerDetail customerDetail = new CustomerDetail("069919249980", "eineEmail@gmx.at", LocalDate.now(), "Ein Filmche", "Röm. Katolisch");
        CustomerDetail customerDetail2 = new CustomerDetail("069919249981", "zweiEmail@gmx.at", LocalDate.now(), "Avenger", "Islam");
        Customer customer = new Customer("Fabian Fischler", -300, customerDetail);
        Customer customer2 = new Customer("Philip NixTestdata", 1000000, customerDetail2);

        entityManager.persist(customer);
        entityManager.persist(customer2);


        //EndRegion Lend

        //Region Movie
        //EndRegion Movie
    }

}