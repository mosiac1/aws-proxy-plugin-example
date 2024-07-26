package an.example;

import com.google.inject.Inject;
import io.trino.aws.proxy.spi.credentials.Credential;
import io.trino.aws.proxy.spi.credentials.Credentials;
import io.trino.aws.proxy.spi.credentials.CredentialsProvider;

import java.util.Optional;

public class MyCredentialsProvider
        implements CredentialsProvider
{
    private final String secretAccessKey;

    @Inject
    public MyCredentialsProvider(MyCredentialsProviderConfig config) {
        this.secretAccessKey = config.getSecretAccessKey();
    }

    @Override
    public Optional<Credentials> credentials(String emulatedAccessKey, Optional<String> session)
    {
        return Optional.of(
                new Credentials(
                        new Credential(emulatedAccessKey, secretAccessKey),
                        Optional.of(new Credential(emulatedAccessKey, secretAccessKey)),
                        Optional.empty()));
    }
}
