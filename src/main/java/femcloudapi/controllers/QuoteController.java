package femcloudapi.controllers;

import femcloudapi.models.Quote;
import femcloudapi.services.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> getAllQuotes() {
        List<Quote> quotes = quoteService.getAllQuotes();
        return new ResponseEntity<List<Quote>>(quotes, HttpStatus.OK);
    }

    @GetMapping("/quotes/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable Long id) {
        Quote quoteById = quoteService.getQuoteById(id);
        return new ResponseEntity<Quote>(quoteById, HttpStatus.OK);
    }

    @PostMapping("/quotes")
    public ResponseEntity<Quote> addQuote(@RequestBody Quote newQuote) {
        Quote createdQuote = quoteService.addQuote(newQuote);
        return new ResponseEntity<Quote>(createdQuote, HttpStatus.CREATED);
    }

    @PutMapping("/quotes/{id}")
    public void updateQuote(@PathVariable Long id, @RequestBody Quote quote) {
        quoteService.updateQuote(id, quote);
    }

    @DeleteMapping("/quotes/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
        return ResponseEntity.noContent().build();
    }
}
