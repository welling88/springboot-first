package com.cc.sbfirst.resources;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cc.sbfirst.model.Calculation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CalculationControllerTest {

	MockMvc mvc;
	
	@Resource
    WebApplicationContext webApplicationConnect;  
	
	@Before  
    public void setUp() throws JsonProcessingException {  
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();  
    } 
	
	@Test
	public void testSqrt() throws Exception { 
		int value = 144;
        String uri = "/calculation/sqrt/" + value;  
    
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))  
			        .andReturn();  
		int status = mvcResult.getResponse().getStatus();  
		assertEquals(200, status);
		
		String response = mvcResult.getResponse().getContentAsString();
		ObjectMapper m = new ObjectMapper();
		Calculation c = m.readValue(response, Calculation.class);
		assertEquals(12, c.getOutput().get(0).intValue());
	}
	
	@Test
	public void testPower() throws Exception { 
		double base = 2;
		double exponent = 4;
        String uri = "/calculation/power?base="+base+"&exponent=" + exponent;  
    
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))  
			        .andReturn();  
		int status = mvcResult.getResponse().getStatus();  
		assertEquals(200, status);
		
		String response = mvcResult.getResponse().getContentAsString();
		ObjectMapper m = new ObjectMapper();
		Calculation c = m.readValue(response, Calculation.class);
		assertEquals(16, c.getOutput().get(0).intValue());
	}
}
