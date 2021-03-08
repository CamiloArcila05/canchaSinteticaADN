package com.co.canchasintetica.testintegracion.infraestructura.cancha;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CanchaEntity;
import com.co.canchasintetica.microservicio.infraestructura.controladores.CanchaController;
import com.co.canchasintetica.testintegracion.infraestructura.cancha.databuilder.CanchaControloadorTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CanchaController.class)
public class CanchaControladorTest {
	
	    @Autowired
	    private ObjectMapper objectMapper;

	    @Autowired
	    private MockMvc mocMvc;
	    
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
