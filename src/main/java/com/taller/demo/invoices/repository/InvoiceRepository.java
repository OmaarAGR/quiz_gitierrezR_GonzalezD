import com.taller.demo.invoices.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, UUID> {
    // Spring Data JPA genera la consulta SQL a partir del nombre del método:
    List<InvoiceEntity> findByProvider(String provider);
    List<InvoiceEntity> findByServiceType(InvoiceEntity.ServiceType serviceType);
    // JpaRepository ya incluye: findAll(), findById(), save(),
    // deleteById(), existsById(), count()… sin SQL manual.
}