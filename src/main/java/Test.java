import pl.vrajani.iex.model.StockQuote;
import pl.vrajani.iex.model.Version;
import pl.vrajani.iex.request.APIService;

public class Test {

    public static void main(String[] args) {
        APIService apiService = new APIService(Version.STABLE);
        StockQuote stockQuote = apiService.getStockQuote("MSFT");
        System.out.println();
    }
}
