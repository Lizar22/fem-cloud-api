package femcloudapi.services;

import femcloudapi.exeptions.QuoteNotFoundException;
import femcloudapi.models.Quote;
import femcloudapi.repositories.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    public Quote addQuote(Quote newQuote) {
        return quoteRepository.save(newQuote);
    }

    public void deleteQuote(Long id) {
        Quote quoteToDelete = getById(id);
        quoteRepository.deleteById(quoteToDelete.getId());
    }

    public Quote getById(Long id) {
        return quoteRepository.findById(id).orElseThrow(() -> new QuoteNotFoundException("No se ha encontrado ninguna cita con el id " + id));
    }

    public void updateQuote(Long id, Quote updatedQuote) {
        Quote oldQuote = getById(id);
        oldQuote.setText(updatedQuote.getText());
        oldQuote.setAuthor(updatedQuote.getAuthor());
        oldQuote.setYear(updatedQuote.getYear());
        quoteRepository.save(oldQuote);
    }
}
