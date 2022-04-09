package ir.maktab.response;

import ir.maktab.model.Person;

public class BorrowLate {

    private final Person person;
    private final long price;

    public BorrowLate(Person person, long price) {
        this.person = person;
        this.price = price;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Person getPerson() {
        return person;
    }

    public long getPrice() {
        return price;
    }

    public static class Builder {

        private Person person;
        private long price;

        private Builder() {
        }

        public Builder person(Person person) {
            this.person = person;
            return this;
        }

        public Builder price(long price) {
            this.price = price;
            return this;
        }

        public BorrowLate build() {
            return new BorrowLate(person, price);
        }

    }
}
