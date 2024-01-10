package employee.management.service.repository;

import employee.management.service.entity.EmployeeEntity;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

}
