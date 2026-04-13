package com.taller.demo.invoices.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
@Entity // Marca la clase como tabla JPA
@Table(name = "invoices") // Nombre de la tabla en BD
@Getter @Setter // Lombok genera getters y setters
@NoArgsConstructor // Lombok: constructor vacío (requerido por JPA)
@AllArgsConstructor // Lombok: constructor con todos los campos
@Builder // Lombok: patrón Builder
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String provider; // Empresa proveedora (ej. "EPM", "Codensa")
    @Column(nullable = false)
    private int total; // Valor total del recibo en pesos
    @Column(nullable = false)
    private String period; // Periodo de facturación, ej. "2024-03"
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType serviceType;
    public enum ServiceType {
        AGUA, ENERGIA, GAS, INTERNET, TELEFONO
    }
}