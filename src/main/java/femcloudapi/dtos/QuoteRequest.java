package femcloudapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record QuoteRequest(
        @NotBlank(message = "Quote is required")
        @Size(min = 1, max = 200, message = "Quote must contain min 1 and max 200 characters")
        String text,

        @NotBlank(message = "Author is required")
        String author,

        @NotBlank(message = "Year is required")
        String year
) {
}
