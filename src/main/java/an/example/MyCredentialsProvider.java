package an.example;

import io.trino.aws.proxy.spi.credentials.Credentials;
import io.trino.aws.proxy.spi.credentials.CredentialsProvider;

import java.util.Optional;

public class MyCredentialsProvider
        implements CredentialsProvider
{
    @Override
    public Optional<Credentials> credentials(String emulatedAccessKey, Optional<String> session)
    {
        // real credentials provider would go here
        return Optional.empty();
    }
}
