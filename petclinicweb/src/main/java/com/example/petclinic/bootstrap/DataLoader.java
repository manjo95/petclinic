package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.PetTypeService;
import com.example.petclinic.services.SpecialitiesService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count==0){
            LoadData();
        }
    }

    private void LoadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedDCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialitiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Manoj");
        owner1.setLastName("Selvamony");
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
        owner2.setFirstName("Jonam");
        owner2.setLastName("Manjo");
        owner2.setAddress("New York");
        owner2.setCity("California");
        owner2.setTelephone("80734872");

        Pet mycat = new Pet();
        mycat.setName("Tom");
        mycat.setBirthDate(LocalDate.now());
        mycat.setPetType(savedDCatPetType);
        mycat.setOwner(owner1);

        owner2.getPets().add(mycat);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Pancha");
        vet1.setLastName("Bhoodham");
        vet1.getSpecialities().add(savedSurgery);
        vet1.getSpecialities().add(savedDentistry);
        vet1.getSpecialities().add(saveRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Christopher");
        vet2.setLastName("Nolan");
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(saveRadiology);
        vetService.save(vet2);
    }

}
