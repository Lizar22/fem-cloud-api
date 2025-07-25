package femcloudapi.services;

import femcloudapi.dtos.QuoteMapper;
import femcloudapi.dtos.QuoteRequest;
import femcloudapi.dtos.QuoteResponse;
import femcloudapi.exeptions.QuoteNotFoundException;
import femcloudapi.models.Quote;
import femcloudapi.repositories.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
        private final QuoteRepository QUOTE_REPOSITORY;

    public QuoteService(QuoteRepository QUOTE_REPOSITORY) {
        this.QUOTE_REPOSITORY = QUOTE_REPOSITORY;
    }

    public List<QuoteResponse> getAllQuotes() {
        List<Quote> quotes = QUOTE_REPOSITORY.findAll();
        return quotes.stream().map(quote -> QuoteMapper.entityToDto(quote)).toList();
    }

    public QuoteResponse getQuoteById(Long id) {
        Quote quote =  QUOTE_REPOSITORY.findById(id).orElseThrow(() -> new QuoteNotFoundException("Quote not foud with id " + id));
        return QuoteMapper.entityToDto(quote);
    }

    public QuoteResponse addQuote(QuoteRequest quoteRequest) {
        Quote newQuote = QuoteMapper.dtoToEntity(quoteRequest);
        Quote savedQuote = QUOTE_REPOSITORY.save(newQuote);
        return QuoteMapper.entityToDto(savedQuote);
    }

    public QuoteResponse updateQuote(Long id, QuoteRequest quoteRequest) {
        Quote updatedQuote = QUOTE_REPOSITORY.findById(id).orElseThrow(() -> new QuoteNotFoundException("Quote not foud with id " + id));
        updatedQuote.setText(quoteRequest.text());
        updatedQuote.setAuthor(quoteRequest.author());
        updatedQuote.setYear(quoteRequest.year());
        Quote savedQuote = QUOTE_REPOSITORY.save(updatedQuote);
        return QuoteMapper.entityToDto(savedQuote);
    }

    public void deleteQuote(Long id) {
        getQuoteById(id);
        QUOTE_REPOSITORY.deleteById(id);
    }
}
