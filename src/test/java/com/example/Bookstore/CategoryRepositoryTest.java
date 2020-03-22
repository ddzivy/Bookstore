package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository crepository;

    @Test
    public void findByNameShouldReturnId() {
        List<Category> categories = crepository.findByName("Fantasy");
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getCategoryid()).isEqualTo(1);
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Drama");
    	crepository.save(category);
    	assertThat(category.getCategoryid()).isNotNull();
    }    

    @Test
    public void deleteCategory() {
    	List <Category> categories = crepository.findByName("Action");
    	crepository.deleteById(categories.get(0).getCategoryid());
    	assertThat(categories.isEmpty());
    } 
}

