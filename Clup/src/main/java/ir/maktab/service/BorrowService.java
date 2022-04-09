package ir.maktab.service;

import ir.maktab.model.Borrow;
import ir.maktab.model.Disc;
import ir.maktab.repository.BorrowRepository;
import ir.maktab.response.BorrowLate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BorrowService {

    private Long late = 1000L;
    private final BorrowRepository borrowRepository;

    public BorrowService() {
        this.borrowRepository = new BorrowRepository();
    }

    public List<Disc> getAllDiscs() {
        List<Borrow> borrows = borrowRepository.getBorrows();
        return borrows.stream().map(this::getDisc).collect(Collectors.toList());
    }

    public List<BorrowLate> getBorrowsLate() {
        List<Borrow> borrowLate = borrowRepository.getBorrowLate();
        return borrowLate.stream().map(this::createBorrowLate).collect(Collectors.toList());
    }

    private BorrowLate createBorrowLate(Borrow borrowLate) {
        return BorrowLate.builder()
                .person(borrowLate.getPerson())
                .price(borrowLate.getDate().getDayOfYear() - LocalDateTime.now().minusDays(7).getDayOfYear() * late)
                .build();
    }

    private Disc getDisc(Borrow borrow) {
        return borrow.getDisk();
    }

    public void setLate(Long late) {
        this.late = late;
    }
}
