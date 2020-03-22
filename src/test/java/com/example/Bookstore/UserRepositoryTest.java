package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository urepository;

    @Test
    public void findByUsernameShouldReturnEmail() {
        List<User> users = urepository.findByEmail("user@user.com");
        
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getUsername()).isEqualTo("user");
    }
    
    //Test create user: player/player
    @Test
    public void createNewUser() {
    	User user = new User("player", "$2a$10$OrTkrPNCD8SIDAAfWL9bk.LT2W8dPuqQ8VR.InvkOPYosr2DI15iG", "player@player.com", "USER");
    	urepository.save(user);
    	assertThat(user.getId()).isNotNull();
    }
    
    @Test
    public void deleteUser() {
    	List <User> users = urepository.findByEmail("reader@reader.com");
    	urepository.deleteById(users.get(0).getId());
    	assertThat(users.isEmpty());
    } 
}


