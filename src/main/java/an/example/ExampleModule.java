package an.example;

import com.google.inject.Binder;
import io.airlift.configuration.AbstractConfigurationAwareModule;
import io.trino.aws.proxy.plugin.config.CredentialsProviderPluginIdentifier;
import io.trino.aws.proxy.plugin.config.S3SecurityFacadeProviderPluginIdentifier;

import static io.airlift.configuration.ConfigBinder.configBinder;
import static io.trino.aws.proxy.plugin.TrinoAwsProxyPluginModuleBuilders.credentialsProviderModule;
import static io.trino.aws.proxy.plugin.TrinoAwsProxyPluginModuleBuilders.s3SecurityFacadeProviderModule;

public class ExampleModule
    extends AbstractConfigurationAwareModule
{
    @Override
    protected void setup(Binder binder)
    {
        install(credentialsProviderModule(
                new CredentialsProviderPluginIdentifier("my-credentials-provider"),
                MyCredentialsProvider.class,
                innerBinder -> configBinder(innerBinder).bindConfig(MyCredentialsProviderConfig.class)));
        install(s3SecurityFacadeProviderModule(
                new S3SecurityFacadeProviderPluginIdentifier("my-security-facade"),
                MyS3SecurityFacadeProvider.class,
                (_) -> {}));
    }
}
