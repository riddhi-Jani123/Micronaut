package employee.management.service.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@Introspected
public record Employee (long id, String name, String email, long departmentId){

}
