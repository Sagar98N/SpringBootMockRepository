package com.assignment.ContactManagement.Repository;

import com.assignment.ContactManagement.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Person,Integer> {
}
