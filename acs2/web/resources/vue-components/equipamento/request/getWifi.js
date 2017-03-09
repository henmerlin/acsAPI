/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue */
var url = "/acs/equipamento/";


Vue.component("getWifi", {
    mounted: function() {
        this.getWifi();
    },
    props: {
        eqpString: {
            type: String,
            required: true
        },
        equipamento: {
            type: Equipamento,
            default: function() {
                return new Equipamento(this.eqpString);
            }
        },
        info: {
            type: WifiInfo,
            default: function() {
                return new WifiInfo();
            }
        }
    },
    methods: {
        getWifi: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "getWifiInfo/",
                data: JSON.stringify(self.equipamento.flush()),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    // self.$parent.loadingRequest();
                },
                success: function(data) {
                    self.info = new WifiInfo(data.wifiInfo);
                    self.alertPanel = {tipo: 'success', mensagem: 'Sucesso na execução', display: 'block'}
                },
                error: function(e) {
                    console.log(e)
                    self.alertPanel = {tipo: 'danger', mensagem: 'Falha na execução', display: 'block'}
                },
                complete: function() {
                }
            });
        },
        setWifi: function() {
            var self = this;

            /**
             * Utilizar este padrão para enviar duas variaveis json para a controller
             * @type type
             */
            var _data = {};
            _data.nbiDeviceData = self.equipamento;
            _data.info = self.info;

            $.ajax({
                type: "POST",
                url: url + "setWifiInfo/",
                data: JSON.stringify(_data),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
//                    self.$parent.loadingRequest();
                },
                success: function(data) {
                    console.log(this.url)
                    self.info = new WifiInfo(data.wifiInfo);
                    self.alertPanel = {tipo: 'success', mensagem: 'Sucesso na execução', display: 'block'}
                },
                error: function(e) {
                    console.log(e)
                    self.alertPanel = {tipo: 'danger', mensagem: 'Falha na execução', display: 'block'}
                },
                complete: function() {
//                    self.$parent.loadingRequest();
                }
            });
        }
    },
    template: "<div>\n\
                <div class='modal-body'>\n\
                    <component is='alertpanel' :msg='alertPanel'></component>\n\
                    <div class='form-group'>\n\
                        <label for='ssid'>SSID (Nome da Rede WiFi)</label>\n\
                        <input class='form-control' v-model='info.ssid'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='ssid'>Senha</label>\n\
                        <input class='form-control' v-model='info.ssidPassword'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='ssid'>Encriptação</label>\n\
                        <input class='form-control' v-model='info.encryptation'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='ssid'>Status</label>\n\
                        <input class='form-control' v-model='info.operStatus'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='ssid'>Canal</label>\n\
                        <input class='form-control' v-model='info.channel'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='ssid'>Broadcast</label>\n\
                        <input class='form-control' v-model='info.broadcastEnabled'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='ssid'>Radio</label>\n\
                        <input class='form-control' v-model='info.radioEnabled'>\n\
                    </div>\n\
                </div>\n\
                <div class='modal-footer'>\n\
                    <button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>\n\
                    <button type='button' class='btn btn-primary' @click='setWifi()'>Alterar</button>\n\
                </div>\n\
            </div>"
});

