package pl.vrajani.iex.utility;

public class URLFormatter {
    public static String injectSymbol(String url, String symbol){
        return url.replace("[symbol]", symbol);
    }
}
