package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.practicum.filmorate.validation.DataBeginFilmEra;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

/**
 * Film.
 */
@Data
public class Film {
    private long id;
    @NotBlank
    private String name;
    @Size(max=200)
    private String description;
    @DataBeginFilmEra
    private LocalDate releaseDate;
    @Min(0)
    private Long duration;
}
