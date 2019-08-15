package pl.vrajani.iex.model;

public enum Version {
    STABLE("stable"),
    LATEST("latest"),
    V1("v1");

    private String version;

    Version(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}
