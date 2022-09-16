package test.backend.kuama;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import test.backend.kuama.dto.CategoryResponseDto;
import test.backend.kuama.dto.DrinksResponseDto;
import test.backend.kuama.exception.KuamaUncheckedException;

import java.util.Locale;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static test.backend.kuama.utils.Constant.*;
import static test.backend.kuama.utils.Constant.DRINK_WRONG_CATEGORY;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class KuamaTest {
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected MockMvc mockMvc;

    private static final String CATEGORYDRINK = "/drinks/categories";
    private static final String DRINKS_BY_NAME = "/drinks/{name}";
    private static final String DRINKS_BY_CATEGORY = "/drinks/categories/{category}";

    private MockHttpServletRequestBuilder getAllDrinksCategories() {
        return get(CATEGORYDRINK).accept(APPLICATION_JSON_VALUE).contentType(APPLICATION_JSON_VALUE);
    }

    private MockHttpServletRequestBuilder getAllDrinksByCategory(String category) {
        return get(DRINKS_BY_CATEGORY, category).accept(APPLICATION_JSON_VALUE).contentType(APPLICATION_JSON_VALUE);
    }

    private MockHttpServletRequestBuilder getAllDrinksByName(String name) {
        return get(DRINKS_BY_NAME, name).accept(APPLICATION_JSON_VALUE).contentType(APPLICATION_JSON_VALUE);
    }

    @Test
    public void getAllDrinksByCategory() throws Exception {
        String respContent = mockMvc
                .perform(getAllDrinksCategories())
                .andExpect(status().is(HttpStatus.OK.value()))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        CategoryResponseDto categories = objectMapper.readValue(respContent, CategoryResponseDto.class);
        assertNotNull(categories);
    }

    @Test
    public void getAllDrinksByNameSuccess() throws Exception {

        String respContent = mockMvc
                .perform(getAllDrinksByName(DRINK_NAME))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        DrinksResponseDto drinksResponseDto = objectMapper.readValue(respContent, DrinksResponseDto.class);
        assertNotNull(drinksResponseDto);
    }

    @Test
    public void allDrinkNameContainSpritz() throws Exception {

        String respContent = mockMvc
                .perform(getAllDrinksByName(DRINK_NAME))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        DrinksResponseDto drinksResponseDto = objectMapper.readValue(respContent, DrinksResponseDto.class);

        drinksResponseDto.getDrinks().forEach(drinkDto ->
                assertTrue(drinkDto.getName().toLowerCase(Locale.ROOT).contains(DRINK_NAME)));
    }

    @Test
    public void getAllDrinksByNameFailed() throws Exception {

        String respContent = mockMvc
                .perform(getAllDrinksByName(DRINK_WRONG_NAME))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        KuamaUncheckedException response = objectMapper.readValue(respContent, KuamaUncheckedException.class);
        assertEquals(response.getCode(), String.valueOf(HttpStatus.NOT_FOUND.value()));
        assertEquals(response.getMessage(), "Drinks not found for name: " + DRINK_WRONG_NAME);
    }

    @Test
    public void getAllDrinksByCategorySuccess() throws Exception {

        String respContent = mockMvc
                .perform(getAllDrinksByCategory(DRINK_CATEGORY))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        DrinksResponseDto drinksResponseDto = objectMapper.readValue(respContent, DrinksResponseDto.class);
        assertNotNull(drinksResponseDto);
    }

    @Test
    public void getAllDrinksByCategoryFailed() throws Exception {

        String respContent = mockMvc
                .perform(getAllDrinksByCategory(DRINK_WRONG_CATEGORY))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        KuamaUncheckedException response = objectMapper.readValue(respContent, KuamaUncheckedException.class);
        assertEquals(response.getCode(), String.valueOf(HttpStatus.NOT_FOUND.value()));
        assertEquals(response.getMessage(), "Drinks not found for category: " + DRINK_WRONG_CATEGORY);
    }
}
