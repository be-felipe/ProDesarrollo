package com.desarrollo.barberia.rest;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.barberia.bussiness.AdminService;
import com.desarrollo.barberia.dtos.AdminDTO;
import com.desarrollo.barberia.dtos.BarberiaDTO;
import com.desarrollo.barberia.model.Admin;
import com.desarrollo.barberia.model.Barberia;



@RestController
@RequestMapping("api")
public class AdminRest {
	@Autowired
	private AdminService adminService;
	@Autowired
    private ModelMapper mapper;
	
	@GetMapping(value="GET")
	public List<AdminDTO> getReservas(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size
){
		
		Page<Admin> admins= adminService.getAdmins(PageRequest.of(page, size));
		
		List<AdminDTO> res= new ArrayList<>();
		for (Admin not: admins) {
			res.add(mapper.map(not, AdminDTO.class));
			System.out.print(not);
		}
		return res;
	}
	
	@GetMapping(value = "getAdminsabyid")
	public AdminDTO getcliente(@RequestParam("id") Long id) {
		Optional<Admin> admin= adminService.getAdminById(id);
		
	
		if (admin.isPresent()) {
			
			
			
			
			return mapper.map(admin.get(), AdminDTO.class);
		} else {
			System.out.print("no entro");
			return null;
		}
	}
	@PostMapping(value = "crearAdmin")
    public AdminDTO crearBarberia(@RequestBody AdminDTO dto) {
		Admin admin= toEntity(dto);
		return toDTO(adminService.crearAdmin(admin));
    }
	private Admin toEntity(AdminDTO dto) {
		return mapper.map(dto, Admin.class);
	}
	private AdminDTO toDTO(Admin res) {
		return mapper.map(res, AdminDTO.class);
	}

	
	
}
