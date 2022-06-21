package io.swagger.bankapi.junit5.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.UsersApiController;
import io.swagger.model.dto.UserDTO;
import io.swagger.model.entity.User;
import io.swagger.repo.UserRepo;
import io.swagger.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UsersApiController.class)
class UsersApiControllerTest {

    private static final int SKIP = 0;
    private static final int LIMIT = 1;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Mock
    private User user;

    @Mock
    private UserDTO userDTO;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getAllUserShouldReturnJsonArrayContainingOneElement() throws Exception {
        when(userService.getAll(SKIP, LIMIT)).thenReturn(List.of(user));
        this.mockMvc.perform(get("/users?skip=0&limit=1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void addUserShouldReturnANonNullObjectAndStatusCreated() throws Exception {
        when(userService.addUser(any(User.class))).thenReturn(user);
        mockMvc.perform(post("/users")
                        .content(mapper.writeValueAsString(userDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

}