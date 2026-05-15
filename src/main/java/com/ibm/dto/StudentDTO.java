package com.ibm.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	private Integer id;
	@NotBlank(message = "Name field should not be blank")
	private String name;
	@NotNull(message = "Marks field should not be null")
	@Min(value = 10,message = "Value should be greater than 0")
	@Max(value= 1000, message = "Value Should be less than or equal to 1000")
	private Integer marks;

}
