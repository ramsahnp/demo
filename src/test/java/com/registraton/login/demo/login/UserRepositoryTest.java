package com.registraton.login.demo.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("rsah@gmail.com");
        user.setFirstName("ram");
        user.setLastName(("sah"));
        user.setPassword("123");

        User savedUser = userRepository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

       //assertThat(savedUser.getEmail(), equals(existUser.getEmail()));
    }


@Test
    public void testFindbyEmail(){
        User  user = userRepository.findByEmail("jony@gmail.com");
        //assertThat(user.getEmail(),equals("jony@gmail.com"));
    }
}
