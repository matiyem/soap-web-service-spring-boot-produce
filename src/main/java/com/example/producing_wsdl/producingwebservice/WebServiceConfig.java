package com.example.producing_wsdl.producingwebservice;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * created by Atiye Mousavi
 * Date: 8/2/2021
 * Time: 3:30 PM
 */

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

//    http://<host>:<port>/ws/countries.wsdl
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
//      این قسمت مهمی است برای ست کردن applicationContext بر روی MessageDispatcherServlet است بدون این کار sprins ws بصورت خودکار bean ها  را detect نمیکد
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);//وقتی وب سرویس بالا میاد یه قسمتی هست به اسم soap:address که اگر از جایی غیر Localhost برنامه اجرا شود آی پی اون ماشین رو میزنه
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "countries")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
        //برای فعال کردن استاندارد wsdl 1.1 با استفاده از XsdSchema
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CountriesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
        wsdl11Definition.setSchema(countriesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
    }
}
