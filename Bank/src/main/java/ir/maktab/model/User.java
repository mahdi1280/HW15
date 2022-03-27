package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Schema.TABLE_USER
        ,schema = Schema.SCHEMA_NAME)
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    private String firstname;
    private String lastname;


    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{

        private String firstname;
        private String lastname;

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public User build(){
            return new User(firstname,lastname);
        }
    }
}
