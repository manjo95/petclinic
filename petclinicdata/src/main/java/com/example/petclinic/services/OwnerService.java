package com.example.petclinic.services;

import com.example.petclinic.model.Owner;

public interface OwnerService extends CreudService<Owner , Long>{

    Owner findByLastName(String lastName);
}
