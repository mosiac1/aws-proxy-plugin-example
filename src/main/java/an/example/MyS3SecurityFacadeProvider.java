package an.example;

import io.trino.aws.proxy.spi.rest.ParsedS3Request;
import io.trino.aws.proxy.spi.security.S3SecurityFacade;
import io.trino.aws.proxy.spi.security.S3SecurityFacadeProvider;
import io.trino.aws.proxy.spi.security.SecurityResponse;
import jakarta.ws.rs.WebApplicationException;

public class MyS3SecurityFacadeProvider
        implements S3SecurityFacadeProvider
{
    @Override
    public S3SecurityFacade securityFacadeForRequest(ParsedS3Request request)
            throws WebApplicationException
    {
        // none shall pass!
        return lowercaseAction -> SecurityResponse.FAILURE;
    }
}
