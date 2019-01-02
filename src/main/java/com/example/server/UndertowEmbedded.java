package com.example.server;

import com.example.configuration.Configuration;
import com.example.servlets.TransferMoneyServlet;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.core.DeploymentManagerImpl;

import javax.servlet.ServletException;

public class UndertowEmbedded implements Server {

    private static UndertowEmbedded instance;

    private UndertowEmbedded() {
    }

    public static UndertowEmbedded getInstance() {
        if (instance == null) {
            synchronized (UndertowEmbedded.class) {
                instance = new UndertowEmbedded();
            }
        }
        return instance;
    }

    @Override
    public void run() throws ServletException {

        DeploymentInfo deploymentInfo = Servlets.deployment()
                .setClassLoader(this.getClass().getClassLoader())
                .setContextPath("")
                .setDeploymentName("account.war")
                .addServlets(TransferMoneyServlet.getInfo());

        DeploymentManager deployment = new DeploymentManagerImpl(deploymentInfo, Servlets.defaultContainer());
        deployment.deploy();

        PathHandler path = Handlers.path(deployment.start());

        Undertow.builder()
                .addHttpListener(
                        Integer.valueOf(Configuration.getOrDefault("server.port", "8080")),
                        Configuration.getOrDefault("server.host", "localhost"))
                .setHandler(path)
                .build()
                .start();
    }

}
