package de.kaigoe.backendbombenzeitung.Repository;

import de.kaigoe.backendbombenzeitung.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public Person getPersonByUserName(String username);
}
