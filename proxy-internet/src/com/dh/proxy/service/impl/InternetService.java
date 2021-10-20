package com.dh.proxy.service.impl;

import com.dh.proxy.service.IConexionInternet;

public class InternetService implements IConexionInternet {


    @Override
    public void conectarCom(String url) {
        System.out.println("Conectando com "+url);
    }
}
