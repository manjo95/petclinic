package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;
import com.example.petclinic.model.PetType;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.PetTypeService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedDCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("fnowner1");
        owner1.setLastName("lnowner1");
        owner1.setAddress("12 california");
        owner1.setCity("malahide");
        owner1.setTelephone("123444555");

        Pet mypet = new Pet();
        mypet.setName("Logan");
        mypet.setBirthDate(LocalDate.now());
        mypet.setPetType(savedDogPetType);
        mypet.setOwner(owner1);

        owner1.getPets().add(mypet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("fnowner2");
        owner2.setLastName("lnowner2");
        owner2.setAddress("New York");
        owner2.setCity("California");
        owner2.setTelephone("80734872");

        Pet mycat = new Pet();
        mycat.setName("Tom");
        mycat.setBirthDate(LocalDate.now());
        mycat.setPetType(savedDogPetType);
        mycat.setOwner(owner1);

        owner2.getPets().add(mycat);

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
