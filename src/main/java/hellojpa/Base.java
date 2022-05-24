package hellojpa;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class Base {

    private String createdBy;
    private LocalDateTime createdDateTime;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDateTime;

}
