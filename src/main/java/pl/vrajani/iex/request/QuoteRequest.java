package pl.vrajani.iex.request;

import org.springframework.http.ResponseEntity;
import pl.vrajani.iex.model.StockQuote;
import pl.vrajani.iex.model.Version;
import pl.vrajani.iex.utility.URLFormatter;

public class QuoteRequest extends Request<StockQuote> {
    private String symbol;

    public QuoteRequest(Version version, String symbol, String token) {
        super(version, token);
        this.symbol = symbol;
        this.url = URLFormatter.injectSymbol(this.url, symbol) + "/?token=" + token;
    }

    @Override
    public StockQuote execute() {
        try{
            ResponseEntity<StockQuote> response =  restTemplate.getForEntity(this.url, StockQuote.class);
            return handleResponse(response);
        } catch (Exception ex){
            System.out.println("Error calling Positions request with symbol: "+symbol+" exception: " +ex.getMessage());
        }
        return null;
    }

    @Override
    public String getPath() {
        return "/stock/[symbol]/quote";
    }
}
