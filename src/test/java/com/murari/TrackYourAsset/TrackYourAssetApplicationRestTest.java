package com.murari.TrackYourAsset;

import com.murari.TrackYourAsset.Controller.RestController;
import com.murari.TrackYourAsset.Entity.UserProfileEntity;
import com.murari.TrackYourAsset.Service.UserProfileService;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@WebMvcTest(value = RestController.class, secure = false)

public class TrackYourAssetApplicationRestTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserProfileService userProfileService;


    UserProfileEntity userProfileEntity = new UserProfileEntity("muraric@gmail.com", "Murari", "Chakrakodi", "11725 Cleary Blvd", "APT 306", "Planatation", "FL", "33324", "USAXX");

    @Test
    public void testgetTestUserProfile() throws Exception {
        Mockito.when(userProfileService.findById(Mockito.anyString())).thenReturn(userProfileEntity);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/TrackYourAsset/getTestUserProfile").accept(MediaType.APPLICATION_JSON).content("{}").contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        System.out.println("Test Result Rest" + response.getContentAsString());
        String expected = "{\"firstName\":\"Murari\",\"lastName\":\"Chakrakodi\",\"addressLine1\":\"11725 Cleary Blvd\",\"addressLine2\":\"APT 306\",\"city\":\"Planatation\",\"state\":\"FL\",\"zipCd\":\"33324\",\"countryCd\":\"USAXX\",\"email\":\"muraric@gmail.com\"}";
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        JSONAssert.assertEquals(expected,response.getContentAsString(),false);
        //assertEquals("http://localhost:8080/TrackYourAsset/getTestUserProfile", response.getHeader(HttpHeaders.LOCATION));

    }
}


