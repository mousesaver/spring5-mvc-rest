package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    void categoryToCategoryDTO() throws Exception {

//        given
        Category category = new Category();
        category.setName("Joe");
        category.setId(1L);

//        when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
//        then
        assertEquals(Long.valueOf(1L), categoryDTO.getId());
        assertEquals("Joe", categoryDTO.getName());

    }
}