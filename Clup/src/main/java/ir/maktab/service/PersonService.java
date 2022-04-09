package ir.maktab.service;

import ir.maktab.model.Person;
import ir.maktab.repository.BaseRepository;

public class PersonService {

    private final BaseRepository<Person> baseRepository;

    public PersonService() {
        this.baseRepository = new BaseRepository<Person>() {};
    }

    public void save(Person person){
        baseRepository.save(person);
    }
}
