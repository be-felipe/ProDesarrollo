package com.desarrollo.barberia.dtos;

public class BarberiaDTO {
	private Long idbarberia;

	private String nombrebarberia;
	
	private String direccionbarberia;
	
	private float preciobarberia;
	
	private String logobarberia;

	private String fotobarber;
;
	
	
	public long getIdbarberia() {
		return idbarberia;
	}

	public String getFotobarber() {
		return fotobarber;
	}

	public void setFotobarber(String fotobarber) {
		this.fotobarber = fotobarber;
	}

	public void setIdbarberia(Long idbarberia) {
		this.idbarberia = idbarberia;
	}

	public void setIdbarberia(long idbarberia) {
		this.idbarberia = idbarberia;
	}

	public String getNombrebarberia() {
		return nombrebarberia;
	}

	public void setNombrebarberia(String nombrebarberia) {
		this.nombrebarberia = nombrebarberia;
	}

	public String getDireccionbarberia() {
		return direccionbarberia;
	}

	public void setDireccionbarberia(String direccionbarberia) {
		this.direccionbarberia = direccionbarberia;
	}

	public float getPreciobarberia() {
		return preciobarberia;
	}

	public void setPreciobarberia(float preciobarberia) {
		this.preciobarberia = preciobarberia;
	}

	public String getLogobarberia() {
		return logobarberia;
	}

	public void setLogobarberia(String logobarberia) {
		this.logobarberia = logobarberia;
	}

	
	
}
