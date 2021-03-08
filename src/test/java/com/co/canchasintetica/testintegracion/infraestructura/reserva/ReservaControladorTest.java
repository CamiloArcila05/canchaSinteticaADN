package com.co.canchasintetica.testintegracion.infraestructura.reserva;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity;
import com.co.canchasintetica.microservicio.infraestructura.controladores.ReservaController;
import com.co.canchasintetica.testintegracion.infraestructura.reserva.databuilder.ReservaControladorTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReservaController.class)
public class ReservaControladorTest {
	
	  @Autowired
	    private ObjectMapper objectMapper;

	    @Autowired
	    private MockMvc mocMvc;
	    
	    @Test
	    public void crearReserva() throws Exception {
	     ReservaEntity reserva = new ReservaControladorTestDataBuilder().build();
	     mocMvc.perform(post("/reserva/registrar-reserva")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(reserva)))
	                .andExpect(status().isOk())
	                .andExpect(status().isCreated());
	    }
	    
	    @Test
	    public void listarReservas() throws Exception {
	        this.mocMvc.perform(get("/reserva/listar-reservas")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)));
	    }
	
}
