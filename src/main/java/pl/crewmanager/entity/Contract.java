package pl.crewmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String place;

    @NotBlank
    private String companyName;

    @NotBlank
    private String contactName;

    @NotNull
    @Digits(integer = 9, fraction = 0)
    private int contactPhoneNumber;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactPhoneNumber(int contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public void setStartDate(String startDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.startDate = LocalDate.parse(startDate, formatter);
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setRigging(boolean rigging) {
        this.rigging = rigging;
    }

    public void setConstruction(boolean construction) {
        this.construction = construction;
    }

    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }

    public void setForklift(boolean forklift) {
        this.forklift = forklift;
    }

    public void setCherrypicker(boolean cherrypicker) {
        this.cherrypicker = cherrypicker;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public void setMultimedia(boolean multimedia) {
        this.multimedia = multimedia;
    }
}
