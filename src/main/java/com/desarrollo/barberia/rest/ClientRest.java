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

import com.desarrollo.barberia.bussiness.AdminService;
import com.desarrollo.barberia.bussiness.ClienteService;
import com.desarrollo.barberia.dtos.ClienteDTO;
import com.desarrollo.barberia.dtos.ReservaDTO;
import com.desarrollo.barberia.ibussiness.Icliente;
import com.desarrollo.barberia.ibussiness.Ireserva;
import com.desarrollo.barberia.model.Admin;
import com.desarrollo.barberia.model.Cliente;
import com.desarrollo.barberia.model.Reserva;

@RestController
@RequestMapping("/Clientes")
public class ClientRest {
	@Autowired
	private Icliente clienteService;
	
	@Autowired
    private ModelMapper mapper;
	
	@GetMapping(value="Getclientes")
	public List<ClienteDTO> getReservas(@RequestParam(name= "page")int page,@RequestParam(name="size")int size){
		
		Page<Cliente> clientes= clienteService.getClientes(PageRequest.of(page, size));
		
		List<ClienteDTO> res= new ArrayList<>();
		for (Cliente not: clientes) {
			res.add(mapper.map(not, ClienteDTO.class));
		}
		return res;
	}
	
	@GetMapping(value = "getClienteid")
	public ClienteDTO getcliente(@RequestParam("id") Long id) {
		Optional<Cliente> cliente= clienteService.getClienteById(id);
	
		if (cliente.isPresent()) {
			return mapper.map(cliente.get(), ClienteDTO.class);
		} else {
			System.out.print("no entro");
			return null;
		}
	}
	@PutMapping(value = "crearReserva")
    public ClienteDTO crearEstudiante(@RequestBody ClienteDTO dto) {
		Cliente cliente= toEntity(dto);
		return toDTO(clienteService.crearCliente(cliente));
    }
	private Cliente toEntity(ClienteDTO dto) {
		return mapper.map(dto, Cliente.class);
	}
	private ClienteDTO toDTO(Cliente res) {
		return mapper.map(res, ClienteDTO.class);
	}
}
