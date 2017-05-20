package com.staxter;

import com.staxter.model.FaultResponse;
import com.staxter.model.FaultResponses;
import com.staxter.model.RegistrationData;
import com.staxter.model.RegistrationResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRegisterUser() {
        final RegistrationData userToRegister = new RegistrationData("Some first name",
                "Some last name",
                "Some user name",
                "The password in plain text");

        final RegistrationResponse response = registerUser(userToRegister);
        assertEquals(userToRegister.getFirstName(), response.getFirstName());
        assertEquals(userToRegister.getLastName(), response.getLastName());
        assertEquals(userToRegister.getUserName(), response.getUserName());
        assertNotNull(response.getId());
    }

    @Test
    public void testRegisterMultipleUsers() {
        RegistrationData userToRegister = createRandomUser();
        final RegistrationResponse response = registerUser(userToRegister);
        assertEquals(userToRegister.getFirstName(), response.getFirstName());
        assertEquals(userToRegister.getLastName(), response.getLastName());
        assertEquals(userToRegister.getUserName(), response.getUserName());
        assertNotNull(response.getId());
        RegistrationData userToRegister2 = createRandomUser();
        final RegistrationResponse response2 = registerUser(userToRegister2);
        assertEquals(userToRegister2.getFirstName(), response2.getFirstName());
        assertEquals(userToRegister2.getLastName(), response2.getLastName());
        assertEquals(userToRegister2.getUserName(), response2.getUserName());
        assertNotNull(response2.getId());
    }

    @Test
    public void testRegisterUsersWithSameUserName() {
        final RegistrationData userToRegister = createRandomUser();

        final RegistrationResponse response = registerUser(userToRegister);
        assertEquals(userToRegister.getFirstName(), response.getFirstName());
        assertEquals(userToRegister.getLastName(), response.getLastName());
        assertEquals(userToRegister.getUserName(), response.getUserName());
        assertNotNull(response.getId());
        final FaultResponse faultResponse = this.restTemplate.postForObject("http://localhost:" + port + "/userservice/register",
                userToRegister,
                FaultResponse.class);
        assertEquals(faultResponse.getCode(), FaultResponses.USER_ALREADY_EXISTS.getResponse().getCode());
        assertEquals(faultResponse.getDescription(), FaultResponses.USER_ALREADY_EXISTS.getResponse().getDescription());
    }

    private RegistrationResponse registerUser(RegistrationData userToRegister) {
        return this.restTemplate.postForObject("http://localhost:" + port + "/userservice/register",
                userToRegister,
                RegistrationResponse.class);
    }

    private static RegistrationData createRandomUser() {
        return new RegistrationData(
                "Some first name" + UUID.randomUUID().toString(),
                "Some last name" + UUID.randomUUID().toString(),
                "Some user name" + UUID.randomUUID().toString(),
                "The password in plain text" + UUID.randomUUID().toString());
    }
}
