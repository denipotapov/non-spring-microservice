package com.example.servlets;

import com.example.entities.rest.TransferMoneyPayload;
import com.example.exceptions.AccountNotFoundException;
import com.example.exceptions.DifferentTransferCurrenciesException;
import com.example.exceptions.InsufficientFundsException;
import com.example.services.TransferMoneyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.ServletInfo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TransferMoneyServlet extends HttpServlet {

    private TransferMoneyService transferMoneyService = new TransferMoneyService();

    public static ServletInfo getInfo() {
        return Servlets.servlet(TransferMoneyServlet.class)
                .addMapping("/transfer");
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
        try {
            TransferMoneyPayload payload = new ObjectMapper().readValue(req.getReader(), TransferMoneyPayload.class);
            transferMoneyService.transfer(payload);
        } catch (InsufficientFundsException | IOException | DifferentTransferCurrenciesException | AccountNotFoundException e) {
            e.printStackTrace();
        }
    }

}
