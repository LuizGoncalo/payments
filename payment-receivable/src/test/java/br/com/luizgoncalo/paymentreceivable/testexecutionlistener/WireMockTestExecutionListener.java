package br.com.luizgoncalo.paymentuser.testexecutionlistener;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;
import org.springframework.util.StreamUtils;

@Slf4j
public class WireMockTestExecutionListener implements TestExecutionListener {

    private WireMockServer wireMockServer;

    @Override
    public void beforeTestClass(final TestContext testContext) throws Exception {
        wireMockServer = new WireMockServer(new WireMockConfiguration()
                .extensions(new ResponseTemplateTransformer(false))
                .port(8888));
        wireMockServer.start();
        WireMock.configureFor(wireMockServer.port());
        wireMockServer.resetAll();
    }

    @Override
    public void beforeTestMethod(final TestContext testContext) throws Exception {
        final String folderName = String.format("classpath:/stubs/%s/**/*.json",
                testContext.getTestClass().getSimpleName(),
                testContext.getTestMethod().getName());
        final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        try{
            for (final Resource resource : resolver.getResources(folderName)){
                wireMockServer.addStubMapping(StubMapping.buildFrom(StreamUtils
                        .copyToString(resource.getInputStream(), StandardCharsets.UTF_8)));
            }
        }catch (IOException e){
            log.info("I=nenhum stub encontrado para o teste, folderName={}", folderName);
        }
    }

    @Override
    public void afterTestMethod(final TestContext testContext) throws Exception {
        wireMockServer.resetAll();
        wireMockServer.listAllStubMappings()
                .getMappings()
                .forEach(WireMock::removeStub);
    }

    @Override
    public void afterTestClass(final TestContext testContext) throws Exception {
        wireMockServer.stop();
    }
}
