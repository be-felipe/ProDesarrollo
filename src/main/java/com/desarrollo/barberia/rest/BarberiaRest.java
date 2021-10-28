package com.desarrollo.barberia.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/Barberia")
public class BarberiaRest {
	@Autowired
	private Ibarberia barberiaservice;
	@Autowired
    private ModelMapper mapper;
	
	@GetMapping(value="GetBarberias")
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
	@PutMapping(value = "crearBarberia")
    public BarberiaDTO crearBarberia(@RequestBody BarberiaDTO dto) {
		Barberia barberia= toEntity(dto);
		return toDTO(barberiaservice.CrearBarberia(barberia));
    }
	private Barberia toEntity(BarberiaDTO dto) {
		return mapper.map(dto, Barberia.class);
	}
	private BarberiaDTO toDTO(Barberia res) {
		return mapper.map(res, BarberiaDTO.class);
	}
}
