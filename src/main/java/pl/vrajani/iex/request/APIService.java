package pl.vrajani.iex.request;

import org.apache.commons.lang3.StringUtils;
import pl.vrajani.iex.model.StockQuote;
import pl.vrajani.iex.model.Version;

public class APIService {
    private String token;
    private Version version;

    private boolean verifyIfTokenAquired() {
        return StringUtils.isNotBlank(token);
    }

    public APIService(Version version) {
        this.version = version;
    }

    private void acquireToken() {
        if (!verifyIfTokenAquired()) {
            this.token = System.getenv("token");
        }
    }

    public StockQuote getStockQuote(String symbol) {
        acquireToken();
        QuoteRequest request = new QuoteRequest(version, symbol, token);
        return request.execute();
    }
}