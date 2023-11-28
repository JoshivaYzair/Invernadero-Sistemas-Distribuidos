package com.Lectura.Lectura.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LecturaDTO {

	private float temperatura;
	private float humedad;
	private String IdSensor;
}
