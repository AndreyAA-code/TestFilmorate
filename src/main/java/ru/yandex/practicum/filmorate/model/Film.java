package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.Date;

/**
 * Film.
 */
@Data
public class Film {
    long id;
    @NotBlank
    String name;
    @Size(max=200)
    String description;
    Date releaseDate;
    @Min(0)
    Long duration;
}
