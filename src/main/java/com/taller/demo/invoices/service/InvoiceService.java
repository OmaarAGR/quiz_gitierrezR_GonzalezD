package com.taller.demo.invoices.service;

import com.taller.demo.invoices.dto.InvoiceRequest;
import com.taller.demo.invoices.dto.InvoiceResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface InvoiceService {
    List<InvoiceResponse> findAll();
    Optional<InvoiceResponse> findById(UUID id);
    InvoiceResponse create(InvoiceRequest request);
    Optional<InvoiceResponse> update(UUID id, InvoiceRequest request);
    boolean delete(UUID id);
}