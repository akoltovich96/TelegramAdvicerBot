package application.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Data
@EqualsAndHashCode
@Table(name = "ADVICES")
@SequenceGenerator(name="advice_id_gen",initialValue = 10, allocationSize = 100)
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "advice_id_gen")
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    City city = new City();
}
