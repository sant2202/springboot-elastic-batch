package com.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@PropertySource(value = "classpath:elasticsearch.properties")
@EnableElasticsearchRepositories(basePackages = "com.example")
public class ElasticsearchConfiguration {

  @Resource
  private Environment environment;

  @Bean
  public Client client() throws NumberFormatException, UnknownHostException {
    String host = environment.getProperty("elasticsearch.host");
    String port = environment.getProperty("elasticsearch.port");
    String clusterName = environment.getProperty("elasticsearch.cluster");
    Settings settings = Settings.settingsBuilder().put("cluster.name", clusterName).build();
    TransportClient client =
        new TransportClient.Builder().settings(settings).build().addTransportAddress(
            new InetSocketTransportAddress(InetAddress.getByName(host), Integer.parseInt(port)));
    System.out.println(clusterName + " " + host + " " + port);
    return client;
  }
}
