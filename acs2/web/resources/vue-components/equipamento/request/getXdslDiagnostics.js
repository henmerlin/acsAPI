/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Equipamento, Vue, XdslDiagnostics */

Vue.component("getXdslDiagnostics", {
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
            type: XdslDiagnostics,
            default: function(){
                    return new XdslDiagnostics();
            }
        }
    },
    data: function(){
      return {mensagem: '', erro: ''};  
    },
    methods:{
        getXdslDiagnostics: function(){
            var self = this;
            $.ajax({
                type: "POST",
                url: "/acs/equipamento/getXdslDiagnostics/",
                data: JSON.stringify(self.equipamento.flush()),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function(data) {
                    self.info = new XdslDiagnostics(data.xdslDiagnostics);
                },
                error: function(e) {
                    console.log(e);
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                },
                complete: function() {
                    self.$parent.loading = false;
                }
            });
        }
    },
    mounted: function(){
        this.getXdslDiagnostics();
    },
    template: "\
            <div>\n\
                <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                <div class='modal-body'>\n\
                    <table class='table table-condensed table-striped text-center'>\n\
                        <tbody>\n\
                            <tr>\n\
                                <td><label>Modulação</label></td>\n\
                                <td>{{info.ModulationType}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>ShowtimeStart</label></td>\n\
                                <td>{{info.ShowtimeStart}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>LinkRetrain</label></td>\n\
                                <td>{{info.LinkRetrain}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>LossOfFraming</label></td>\n\
                                <td>{{info.LossOfFraming}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>SeverelyErroredSecs</label></td>\n\
                                <td>{{info.SeverelyErroredSecs}}</td>\n\
                            </tr>\n\
                        </tbody>\n\
                    </table>\n\
                    <hr>\n\
                    <table class='table table-bordered table-condensed table-striped'>\n\
                        <thead>\n\
                            <tr>\n\
                                <th></th>\n\
                                <th>Downstream</th>\n\
                                <th>Upstream</th>\n\
                            </tr>\n\
                        </thead>\n\
                        <tbody>\n\
                            <tr>\n\
                                <td>Vel. Máx. Alcançável</td>\n\
                                <td>{{info.DownstreamMaxRate}}</td>\n\
                                <td>{{info.UpstreamMaxRate}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>Vel. Sincronizada</td>\n\
                                <td>{{info.DownstreamCurrRate}}</td>\n\
                                <td>{{info.UpstreamCurrRate}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>Snr</td>\n\
                                <td>{{info.DownstreamNoiseMargin}}</td>\n\
                                <td>{{info.UpstreamNoiseMargin}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>Atn</td>\n\
                                <td>{{info.DownstreamAttenuation}}</td>\n\
                                <td>{{info.UpstreamAttenuation}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>Power</td>\n\
                                <td>{{info.DownstreamPower}}</td>\n\
                                <td>{{info.UpstreamPower}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>FEC</td>\n\
                                <td>{{info.FECErrors}}</td>\n\
                                <td>{{info.ATUCFECErrors}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>HEC</td>\n\
                                <td>{{info.HECErrors}}</td>\n\
                                <td>{{info.ATUCHECErrors}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>CRC</td>\n\
                                <td>{{info.CRCErrors}}</td>\n\
                                <td>{{info.ATUCCRCErrors}}</td>\n\
                            </tr>\n\
                        </tbody>\n\
                    </table>\n\
                </div>\n\
                <div class='modal-footer'>\n\
                    <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                    <button type='button' class='btn btn-primary' @click='getXdslDiagnostics()'>Consultar</button>\n\
                </div>\n\
            </div>"
});