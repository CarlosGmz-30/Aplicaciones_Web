package mx.edu.utez.ExamenUII.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "coches")
public class CochesBean {
}
