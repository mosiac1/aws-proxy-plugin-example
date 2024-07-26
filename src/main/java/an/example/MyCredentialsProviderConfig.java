package an.example;

import io.airlift.configuration.Config;
import jakarta.validation.constraints.NotNull;

public class MyCredentialsProviderConfig
{
    private String secretAccessKey;

    @NotNull
    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    @Config("credentials-provider.my-provider.secret-access-key")
    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }
}
