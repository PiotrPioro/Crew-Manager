package pl.crewmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @Digits(integer = 9, fraction = 0)
    private int phoneNumber;

    @NotNull
    private boolean rigging;

    @NotNull
    private boolean construction;

    @NotNull
    private boolean lighting;

    @NotNull
    private boolean forklift;

    @NotNull
    private boolean cherrypicker;

    @NotNull
    private boolean sound;

    @NotNull
    private boolean multimedia;
}
