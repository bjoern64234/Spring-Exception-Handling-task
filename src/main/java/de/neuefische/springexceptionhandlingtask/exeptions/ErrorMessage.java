package de.neuefische.springexceptionhandlingtask.exeptions;

import lombok.Builder;
import lombok.With;

import java.time.LocalDateTime;

@With
@Builder
public record ErrorMessage(String message, int status, LocalDateTime timestamp) {
}
