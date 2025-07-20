package femcloudapi.dtos;

import femcloudapi.models.Quote;

public class QuoteMapper {
    public static Quote dtoToEntity (QuoteRequest dto) {
        return new Quote(dto.text(), dto.author(), dto.year());
    }

    public static QuoteResponse entityToDto (Quote quote) {
        return new QuoteResponse(quote.getText(),quote.getAuthor(),quote.getYear());
    }
}