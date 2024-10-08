package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
/*  Completed By Malesela Modiba
    23 May 2024
 */
class ServiceRecordFactoryTest {
    private ServiceRecord serviceRecord;
    private TruckType truckType;
    private Insurance insurance;
    private Truck truck;
    @BeforeEach
    void setUp() {
        truckType = TruckTypeFactory.buildTruckType("Enclosed", "Large box truck suitable for moving large items.With its higher payload capacity, you can transport a wide range of items, including large packages, bulky equipment, furniture, appliances, and more", "7.4m * 2.48m*2.7m",
                6.3, "Manual", 5.89, "Diesel");
        insurance = InsuranceFactory.buildInsurance("Truck Insurance", "Out Surance",
                "POL-12345", LocalDate.of(2024, 4, 24), "Truck damage or theft,Natural disasters", 1500);
        byte[] photo = new byte[0];
        truck = TruckFactory.buildTruck("1FUJGBDV7PLCW1234", "Volvo VNL 760",photo, true, "CA 652-589", 478920.50, truckType, insurance);
    }
    @Test
    void BuildServiceRecord(){
      serviceRecord = ServiceRecordFactory.buildServiceRecord(001,
                "Normal Service",
                3500.99,
                LocalDate.of(2024,3,25),
                LocalDate.of(2024,6,25)
                ,truck);
        assertNotNull(serviceRecord);
        System.out.println(serviceRecord);
    }
    @Test
    void BuildServiceRecordWithFail(){
       serviceRecord = ServiceRecordFactory.buildServiceRecord(001,
                "Normal Service",
                3500.99,
                LocalDate.of(2024,3,32),
                LocalDate.of(2024,6,25)
                ,truck);
        assertNotNull(serviceRecord);
        System.out.println(serviceRecord);
    }
}
