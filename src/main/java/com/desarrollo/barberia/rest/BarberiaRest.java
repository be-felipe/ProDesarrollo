package com.desarrollo.barberia.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.barberia.bussiness.BarberiaService;
import com.desarrollo.barberia.dtos.BarberiaDTO;
import com.desarrollo.barberia.dtos.ClienteDTO;
import com.desarrollo.barberia.ibussiness.Ibarberia;
import com.desarrollo.barberia.model.Barberia;
import com.desarrollo.barberia.model.Cliente;

@RestController
@RequestMapping("/barberia")
public class BarberiaRest {
	@Autowired
	private Ibarberia barberiaservice;
	@Autowired
    private ModelMapper mapper;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="getbarbers")
	public List<BarberiaDTO> getReservas(@RequestParam(name= "page")int page,@RequestParam(name="size")int size){
		
		Page<Barberia> barberias= barberiaservice.getBarberias(PageRequest.of(page, size));
		
		List<BarberiaDTO> res= new ArrayList<>();
		for (Barberia not: barberias) {
			res.add(mapper.map(not, BarberiaDTO.class));
		}
		return res;
	}
	
	
	@GetMapping(value = "getBarberiabyid")
	public BarberiaDTO getcliente(@RequestParam("id") Long id) {
		Optional<Barberia> barberia= barberiaservice.getBarberiaById(id);
	
		if (barberia.isPresent()) {
			return mapper.map(barberia.get(), BarberiaDTO.class);
		} else {
			System.out.print("no entro");
			return null;
		}
	}
	@PostMapping(value = "crearBarberia")
    public BarberiaDTO crearBarberia(@RequestBody BarberiaDTO dto) {
		Barberia barberia= toEntity(dto);
		
		
		return toDTO(barberiaservice.CrearBarberia(barberia));
    }
	@DeleteMapping(value="Eliminar/{id}")
	public void deletebarber (@PathVariable ("id") Long id){
		
	
		barberiaservice.DeleteBarberiaId(id);
		
	}
	private Barberia toEntity(BarberiaDTO dto) {
		return mapper.map(dto, Barberia.class);
	}
	private BarberiaDTO toDTO(Barberia res) {
		return mapper.map(res, BarberiaDTO.class);
	}
	

}
