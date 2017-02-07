<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container">

    <div class="page-header">
        <h1>Equipamento</h1>
    </div>

    <div class="row">
        <div class="col-md-4">
            <div class="row">                
                <div class="col-md-12">
                    <img src="http://lojadomodem.com.br/media/catalog/product/cache/1/small_image/300x/17f82f742ffe127f42dca9de82fb58b1/0/0/00_1_4.jpg" class="img-responsive" style="border: 3px solid green; padding: 0;">
                </div>                 
            </div>
            <div class="row">
                <div class="col-md-12">
                    <ul class="list-group">
                        <li class="list-group-item"><label>MAC:</label> 8C:10:D4:DA:15:50</li>
                        <li class="list-group-item"><label>IP:</label> 177.16.212.159</li>
                        <li class="list-group-item"><label>Data Autenticação:</label> 07/02/2017 08:59:45</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="row">                
                <div class="col-md-6">                    
                    <div class="list-group">
                        <label class="list-group-item">Consulta</label>
                        <button type="button" class="list-group-item">Consultar WAN</button>
                        <button type="button" class="list-group-item">Consultar Interface</button>
                        <button type="button" class="list-group-item">Consultar LAN Host</button>
                        <button type="button" class="list-group-item">Consultar Port Mapping</button>
                        <button type="button" class="list-group-item">Consultar xDSL</button>
                        <button type="button" class="list-group-item">Consultar Firmware</button>
                        <button type="button" class="list-group-item">Consultar DNS</button>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="list-group">
                        <label class="list-group-item">Ação</label>
                        <button type="button" class="list-group-item">Reboot</button>
                        <button type="button" class="list-group-item">Reset de Fábrica</button>
                        <button type="button" class="list-group-item">Efetuar Traceroute</button>
                        <button type="button" class="list-group-item">Gerenciar DMZ</button>
                        <button type="button" class="list-group-item">Efetuar Ping</button>
                        <button type="button" class="list-group-item">Gerenciar Port Mapping</button>
                        <button type="button" class="list-group-item">Configurar Wifi</button>
                        <button type="button" class="list-group-item">Configurar Autenticação PPPoE</button>
                        <button type="button" class="list-group-item">Atualizar Firmware</button>
                        <button type="button" class="list-group-item">Alterar DNS</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>