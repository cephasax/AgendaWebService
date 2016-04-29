
/**
 * AgendaServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */

    package principal;

    /**
     *  AgendaServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class AgendaServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public AgendaServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public AgendaServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for listarContatos method
            * override this method for handling normal response from listarContatos operation
            */
           public void receiveResultlistarContatos(
                    principal.AgendaServiceStub.ListarContatosResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listarContatos operation
           */
            public void receiveErrorlistarContatos(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for adicionarContato method
            * override this method for handling normal response from adicionarContato operation
            */
           public void receiveResultadicionarContato(
                    principal.AgendaServiceStub.AdicionarContatoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from adicionarContato operation
           */
            public void receiveErroradicionarContato(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for buscarContato method
            * override this method for handling normal response from buscarContato operation
            */
           public void receiveResultbuscarContato(
                    principal.AgendaServiceStub.BuscarContatoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from buscarContato operation
           */
            public void receiveErrorbuscarContato(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removerContato method
            * override this method for handling normal response from removerContato operation
            */
           public void receiveResultremoverContato(
                    principal.AgendaServiceStub.RemoverContatoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removerContato operation
           */
            public void receiveErrorremoverContato(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for editarContato method
            * override this method for handling normal response from editarContato operation
            */
           public void receiveResulteditarContato(
                    principal.AgendaServiceStub.EditarContatoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from editarContato operation
           */
            public void receiveErroreditarContato(java.lang.Exception e) {
            }
                


    }
    