package de.neuefische.springexceptionhandlingtask.exeptions;

import lombok.Builder;
import lombok.With;

@With
@Builder
public record ErrorMessage(String message) {
}
