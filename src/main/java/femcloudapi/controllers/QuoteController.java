package femcloudapi.controllers;

import femcloudapi.dtos.QuoteRequest;
import femcloudapi.dtos.QuoteResponse;
import femcloudapi.services.QuoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {
    private final QuoteService QUOTE_SERVICE;

    public QuoteController(QuoteService QUOTE_SERVICE) {
        this.QUOTE_SERVICE = QUOTE_SERVICE;
    }

    @GetMapping
    public ResponseEntity<List<QuoteResponse>> getAllQuotes() {
        return new ResponseEntity<>(QUOTE_SERVICE.getAllQuotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuoteResponse> getQuoteById(@PathVariable Long id) {
        QuoteResponse quoteResponse = QUOTE_SERVICE.getQuoteById(id);
        return new ResponseEntity<>(quoteResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuoteResponse> addQuote(@Valid @RequestBody QuoteRequest quoteRequest) {
        return new ResponseEntity<>(QUOTE_SERVICE.addQuote(quoteRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuoteResponse> updateQuote(@PathVariable Long id, @Valid @RequestBody QuoteRequest quoteRequest) {
        QuoteResponse updatedQuote = QUOTE_SERVICE.updateQuote(id, quoteRequest);
        return new ResponseEntity<>(updatedQuote, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Long id) {
        QUOTE_SERVICE.deleteQuote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
