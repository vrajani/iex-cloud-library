import pl.vrajani.model.StockQuote;
import pl.vrajani.model.Version;
import pl.vrajani.request.APIService;
import pl.vrajani.request.QuoteRequest;

public class Test {

    public static void main(String[] args) {
        APIService apiService = new APIService(Version.STABLE);
        StockQuote stockQuote = apiService.getStockQuote("MSFT");
        System.out.println();
    }
}
