package ir.maktab.service.shoertterm;

import ir.maktab.model.ShortTerm;
import ir.maktab.repository.Repository;

public class ShortTermServiceImpl implements ShortTermService {

    private final Repository<ShortTerm> repository;

    public ShortTermServiceImpl() {
        this.repository = new Repository<ShortTerm>() {
        };
    }

    @Override
    public void save(ShortTerm shortTerm) {
        repository.save(shortTerm);
    }
}
