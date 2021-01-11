package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("fnowner1");
        owner1.setLastName("lnowner1");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("fnowner2");
        owner2.setLastName("lnowner2");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("VetFname1");
        vet1.setLastName("VetLname1");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("VetFname2");
        vet2.setLastName("VetLname2");

        vetService.save(vet2);

    }

}
