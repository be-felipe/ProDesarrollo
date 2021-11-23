package com.desarrollo.barberia.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.barberia.bussiness.ReservaService;
import com.desarrollo.barberia.dtos.ReservaDTO;
import com.desarrollo.barberia.ibussiness.Ireserva;
import com.desarrollo.barberia.model.Reserva;

@RestController
@RequestMapping("/Reserva")
public class ReservaRest {
	@Autowired
	private Ireserva reservaService;
	@Autowired
    private ModelMapper mapper;
	
	@GetMapping(value="GetReservas")
	public List<ReservaDTO> getReservas(@RequestParam(name= "page")int page,@RequestParam(name="size")int size){
		
		Page<Reserva> reserva= reservaService.getReservas(PageRequest.of(page, size));
		
		List<ReservaDTO> res= new ArrayList<>();
		for (Reserva not: reserva) {
			res.add(mapper.map(not, ReservaDTO.class));
		}
		return res;
	}
	
	@GetMapping(value = "getReservaid")
	public ReservaDTO getEstudiante(@RequestParam("id") Long id) {
		Optional<Reserva> reserva= reservaService.getReservaById(id);
	
		if (reserva.isPresent()) {
			return mapper.map(reserva.get(), ReservaDTO.class);
		} else {
			System.out.print("no entro");
			return null;
		}
	}
	@PostMapping(value = "guardarreserva")
	ReservaDTO crearEstudiante(@RequestBody ReservaDTO dto) {
		Reserva reserva= toEntity(dto);
		return toDTO(reservaService.crearResrva(reserva));
    }
	private Reserva toEntity(ReservaDTO dto) {
		return mapper.map(dto, Reserva.class);
	}
	private ReservaDTO toDTO(Reserva res) {
		return mapper.map(res, ReservaDTO.class);
	}
	
}
