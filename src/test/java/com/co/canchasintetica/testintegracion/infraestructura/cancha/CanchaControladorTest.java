package com.co.canchasintetica.testintegracion.infraestructura.cancha;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.co.canchasintetica.ApplicationMock;
import com.co.canchasintetica.microservicio.CanchaSinteticaApplication;
import com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CanchaEntity;
import com.co.canchasintetica.testintegracion.infraestructura.cancha.databuilder.CanchaControloadorTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@SpringBootTest(classes = CanchaSinteticaApplication.class)
@AutoConfigureMockMvc
public class CanchaControladorTest {
	
	    @Autowired
	    private ObjectMapper objectMapper;

	    @Autowired
	    private MockMvc mocMvc;
	    
	    @Autowired
		private WebApplicationContext wac;
	    
	    @Before
		public void setUp() {
			this.mocMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		}
	    
	    @Test
	    public void crearCancha() throws Exception{
	        // arrange
	        CanchaEntity cancha = new CanchaControloadorTestDataBuilder().build();
	        // act - assert
	        mocMvc.perform(post("/cancha/registrar-cancha")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(cancha)))
	                .andExpect(status().isOk())
	                .andExpect(status().isCreated());
	    }
	    
	    
	    @Test
	    public void listarCanchas() throws Exception {
	        this.mocMvc.perform(get("/cancha/listar-canchas")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)));
	    }

}
