package com.hms.patient.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Pattern(regexp = "\\d{10}", message = "Invalid contact number")
    private String contact;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull
    @Past(message = "DOB must be in the past")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;

    private final LocalDateTime createdAt = LocalDateTime.now();
}
