package ir.maktab.service.current;

import ir.maktab.exception.RuleException;
import ir.maktab.model.Current;
import ir.maktab.repository.Repository;

public class CurrentServiceImpl implements CurrentService {

    private final Repository<Current> repository;

    public CurrentServiceImpl() {
        repository=new Repository<Current>() {};
    }

    @Override
    public void save(Current current) {
        if(current.getAmount() < 100000)
            throw new RuleException("not valid");
        repository.save(current);
    }
}
