package femcloudapi.services;

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
        quoteRepository.deleteById(id);
    }
}




//aquí tendremos que usar el optional por si estamos buscando por ID y no encuentra, que ponga un mensaje, y si encuentra, que devuelva lo que buscamos