package versions.v2.application;

import versions.v2.domain.model.BankAccount;
import versions.v2.domain.model.User;
import versions.v2.repository.UserRepository;

import java.time.LocalDate;

public class Bootstrap {

        private final UserRepository repository;

        public Bootstrap(
                UserRepository repository) {

            this.repository = repository;

        }

        public void initialize() {

            // create demo users
            BankAccount account =
                    new BankAccount(
                            110000,
                            "Aryan",
                            1234
                    );

            User aryan =
                    new User(
                            1,
                            "ch_aryan1",
                            "Aryan@123",
                            "Aryan Chilkeshwaram",
                            account,
                            LocalDate.of(2003, 8, 14)
                    );

            repository.storeUser(
                    aryan.getUserName(),
                    aryan
            );

        }

    }

