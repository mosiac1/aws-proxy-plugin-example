package an.example;

import com.google.inject.Module;
import io.airlift.log.Logger;
import io.trino.aws.proxy.spi.TrinoAwsProxyServerPlugin;

public class MyPlugin
        implements TrinoAwsProxyServerPlugin
{
    private static final Logger log = Logger.get(MyPlugin.class);

    @Override
    public Module module()
    {
        log.info("MyPlugin lives!");

        return new ExampleModule();
    }
}
