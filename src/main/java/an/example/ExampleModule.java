package an.example;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

import static io.trino.aws.proxy.spi.TrinoAwsProxyBinder.trinoAwsProxyBinder;

public class ExampleModule
    implements Module
{
    @Override
    public void configure(Binder binder)
    {
        trinoAwsProxyBinder(binder)
                .bindS3SecurityFacadeProvider(binding -> binding.to(MyS3SecurityFacadeProvider.class).in(Scopes.SINGLETON))
                .bindCredentialsProvider(binding -> binding.to(MyCredentialsProvider.class).in(Scopes.SINGLETON));
    }
}
