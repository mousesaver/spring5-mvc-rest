package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CategoryMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

class CategoryServiceTest {
    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    void getAllCategories() throws Exception {
        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());
        when(categoryRepository.findAll()).thenReturn(categories);
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();
        assertEquals(3, categoryDTOS.size());
    }

    @Test
    void getCategoryByName() throws Exception {
//        given
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRepository.findByName(anyString())).thenReturn(category);

        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);
        assertEquals(ID, categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }
}