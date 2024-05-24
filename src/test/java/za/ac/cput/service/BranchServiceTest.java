package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Branch;
import za.ac.cput.domain.RentTruck;
import za.ac.cput.factory.BranchFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BranchServiceTest.java
 * This is the ServiceTest class
 * @author Thandolwethu Zamasiba Khoza (221797289)
 * Date: 18 May 2024
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BranchServiceTest {
    @Autowired
    private BranchService branchService;

    private Branch branch1 = BranchFactory.buildBranch(3701,
            "WiggleTrucksWC", "10 Main St, Cape Town, South Africa, 7972");

    private Branch branch2 = BranchFactory.buildBranch(3702,
            "WiggleTrucksKZN","10 Dorset St, Durban, South Africa, 7972");


    @Test
    void create() {
        Branch created1 = branchService.create(branch1);
        assertNotNull(created1);
        System.out.println(created1);

        Branch created2 = branchService.create(branch2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void read() {
        Branch read = branchService.read(branch1.getBranchId());
        assertNotNull(read);
        System.out.println("read: " + read);
    }

    @Test
    @Disabled
    void delete() {
    }

    @Test
    void getAll() {
        branchService.getAll();
    }
}