/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp;

import java.awt.Component;
import java.io.PrintWriter;
import java.net.URL;
import java.security.Security;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;




/**
 *
 * @author n00b
 */
public class BurpExtender implements IBurpExtender, ITab, IHttpListener, IProxyListener, IMessageEditorTabFactory {
    
    public String ExtensionName =  "AES Killer";
    public String TabName =  "AES Killer";
    public String _Header = "Aes: Killer";
    AES_Killer _aes_killer;
    
    public IBurpExtenderCallbacks callbacks;
    public IExtensionHelpers helpers;
    public PrintWriter stdout;
    public PrintWriter stderr;
    public Boolean isDebug = true;
    public Boolean isRunning = false;
    
    public Cipher cipher;
    public SecretKeySpec sec_key;
    public IvParameterSpec iv_param;
   
    public String _host;
    public String _enc_type;
    public String _secret_key;
    public String _iv_param;
    public String[] _req_param;
    public String[] _res_param;
    
    public String[] _obffusicatedChar;
    public String[] _replaceWithChar;
    
    public Boolean _exclude_iv = false;
    public Boolean _ignore_response = false;
    public Boolean _do_off = false;
    public Boolean _url_enc_dec = false;
    public Boolean _req_tab = false;
    //public Boolean _resp_tab = false;
    public Boolean _is_req_body = false;
    public Boolean _is_res_body = false;
    public Boolean _is_req_param = false;
    public Boolean _is_res_param = false;
    public Boolean _is_ovrr_req_body = false;
    public Boolean _is_ovrr_res_body = false;
    public Boolean _is_ovrr_req_body_form = false;
    public Boolean _is_ovrr_res_body_form = false;
    public Boolean _is_ovrr_req_body_json = false;
    public Boolean _is_ovrr_res_body_json = false;
    
    
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        this.helpers = callbacks.getHelpers();
        this.stdout = new PrintWriter(callbacks.getStdout(), true);
        this.stderr = new PrintWriter(callbacks.getStderr(), true);
        this.callbacks.setExtensionName(this.ExtensionName);
        
        _aes_killer = new AES_Killer(this);
        this.callbacks.addSuiteTab(this);
        this.callbacks.registerMessageEditorTabFactory(this);
        this.stdout.println("AES_Killer Installed !!!");
    }

    @Override
    public String getTabCaption() {
        return this.TabName;
    }

    @Override
    public Component getUiComponent() {
        return this._aes_killer;
    }
    
    public void start_aes_killer(){
        this.callbacks.registerHttpListener(this);
        this.callbacks.registerProxyListener(this);
        this.isRunning = true;
    }
    
    public void stop_aes_killer(){
        this.callbacks.removeHttpListener(this);
        this.callbacks.removeProxyListener(this);
        this.isRunning = false;
    }
    
    private void print_output(String _src, String str){
        if(! isDebug){ return; }
        this.stdout.println(_src + " :: " + str);
    }
    
    private void print_error(String _src, String str){
        if(! isDebug){ return; }
        this.stderr.println(_src + " :: " + str);
    }
    
    public String get_host(String _url){
        try{
            URL abc = new URL(_url);
            return abc.getHost().toString();
        }catch (Exception ex){
            print_error("get_endpoint", _url);
            return _url;
        }
    }

    public String remove_0bff(String _paramString) {
        if (_paramString != null) {
          for(int i =0; i< this._obffusicatedChar.length; i++){
              _paramString = _paramString.replace(this._replaceWithChar[i], this._obffusicatedChar[i]);
          }
          return _paramString;
        }
        return _paramString;
    }
    
    public String do_0bff(String _paramString) {
        if (_paramString != null) {
          for(int i =0; i< this._obffusicatedChar.length; i++){
              _paramString = _paramString.replace(this._obffusicatedChar[i], this._replaceWithChar[i]);
          }
          return _paramString;
        }
        return _paramString;
    }
    
    public String do_decrypt(String _enc_str){
        try{
            Security.addProvider(new BouncyCastleProvider());
            cipher = Cipher.getInstance(this._enc_type);
            //sec_key = new SecretKeySpec(this.helpers.base64Decode(this._secret_key),"AES");
            //sec_key = new SecretKeySpec(this.helpers.base64Decode(this._secret_key),"GOST3412-2015");
            String alg = this._enc_type.split("/")[0];
            sec_key = new SecretKeySpec(this.helpers.base64Decode(this._secret_key),alg);
            
            if (this._exclude_iv){
                cipher.init(Cipher.DECRYPT_MODE, sec_key);
            }
            else {
                iv_param = new IvParameterSpec(this.helpers.base64Decode(this._iv_param));
                cipher.init(Cipher.DECRYPT_MODE, sec_key, iv_param);
            }
            
            if (this._url_enc_dec) { _enc_str = this.helpers.urlDecode(_enc_str); }
            if (this._do_off) { _enc_str = this.remove_0bff(_enc_str); }
            
            _enc_str = new String (cipher.doFinal(this.helpers.base64Decode(_enc_str)));
            return _enc_str;
        }catch(Exception ex){
            print_error("do_decrypt", ex.getMessage());
            return _enc_str;
        }
    }

    public String do_encrypt(String _dec_str){
        try{
            cipher = Cipher.getInstance(this._enc_type);
            String alg = this._enc_type.split("/")[0];
            sec_key = new SecretKeySpec(this.helpers.base64Decode(this._secret_key),alg);
            //sec_key = new SecretKeySpec(this.helpers.base64Decode(this._secret_key),"GOST3412-2015");
            //sec_key = new SecretKeySpec(this.helpers.base64Decode(this._secret_key),"AES");
            
            if (this._exclude_iv){
                cipher.init(Cipher.ENCRYPT_MODE, sec_key);
            }
            else {
                iv_param = new IvParameterSpec(this.helpers.base64Decode(this._iv_param));
                cipher.init(Cipher.ENCRYPT_MODE, sec_key, iv_param);
            }
                        
            _dec_str = new String (this.helpers.base64Encode(cipher.doFinal(_dec_str.getBytes())));
            if (this._do_off) { _dec_str = this.do_0bff(_dec_str); }
            if (this._url_enc_dec) { _dec_str = this.helpers.urlEncode(_dec_str); }
            return _dec_str;
        }catch(Exception ex){
            print_error("do_decrypt", ex.getMessage());
            return _dec_str;
        }
    }
    
    
    public byte[] update_req_params (byte[] _request, List<String> headers, String[] _params, Boolean _do_enc){
        for(int i = 0 ; i < _params.length; i++){
            IParameter _p = this.helpers.getRequestParameter(_request, _params[i]);
            if (_p == null || _p.getName().toString().length() == 0){ continue; }
            
            String _str = "";
            if(_do_enc) {
                _str = this.do_encrypt(_p.getValue().toString().trim());
            }
            else {
                _str = this.do_decrypt(_p.getValue().toString().trim());
            }
            
            if(this._is_ovrr_req_body){
                if (!headers.contains(this._Header)) { headers.add(this._Header); }
                _request = this.helpers.buildHttpMessage(headers, _str.getBytes());
                return _request;
            }
            
            if(this._is_ovrr_res_body){
                if (!headers.contains(this._Header)) { headers.add(this._Header); }
                _request = this.helpers.buildHttpMessage(headers, _str.getBytes());
                return _request;
            }

            
            IParameter _newP = this.helpers.buildParameter(_params[i], _str, _p.getType());
            _request = this.helpers.removeParameter(_request, _p);
            _request = this.helpers.addParameter(_request, _newP);
            if (!headers.contains(this._Header)) { headers.add(this._Header); }
            IRequestInfo reqInfo2 = helpers.analyzeRequest(_request);
            String tmpreq = new String(_request);
            String messageBody = new String(tmpreq.substring(reqInfo2.getBodyOffset())).trim();
            _request = this.helpers.buildHttpMessage(headers, messageBody.getBytes());
        }
        return _request;
    }
    
    public byte[] update_req_params_json(byte[] _request, List<String> headers, String[] _params, Boolean _do_enc){
        for(int i=0; i< _params.length; i++){
            IParameter _p = this.helpers.getRequestParameter(_request, _params[i]);
            if (_p == null || _p.getName().toString().length() == 0){ continue; }
            
            String _str = "";
            if(_do_enc) {
                _str = this.do_encrypt(_p.getValue().toString().trim());
            }
            else {
                _str = this.do_decrypt(_p.getValue().toString().trim());
            }
            
            
            if(this._is_ovrr_req_body){
                if (!headers.contains(this._Header)) { headers.add(this._Header); }
                _request = this.helpers.buildHttpMessage(headers, _str.getBytes());
                return _request;
            }
            
            if(this._is_ovrr_res_body){
                if (!headers.contains(this._Header)) { headers.add(this._Header); }
                _request = this.helpers.buildHttpMessage(headers, _str.getBytes());
                return _request;
            }
            
            
            IRequestInfo reqInfo = helpers.analyzeRequest(_request);
            String tmpreq = new String(_request);
            String messageBody = new String(tmpreq.substring(reqInfo.getBodyOffset())).trim();

            int _fi = messageBody.indexOf(_params[i]);
            if(_fi < 0) { continue; }

            _fi = _fi + _params[i].length() + 3;
            int _si = messageBody.indexOf("\"", _fi);
            print_output("update_req_params_json", _str);
            print_output("update_req_params_json", messageBody.substring(0, _fi));
            print_output("update_req_params_json", messageBody.substring(_si, messageBody.length()));
            if (!headers.contains(this._Header)) { headers.add(this._Header); }
            messageBody = messageBody.substring(0, _fi) + _str + messageBody.substring(_si, messageBody.length());
            _request = this.helpers.buildHttpMessage(headers, messageBody.getBytes());
            
        }
        return _request;
    }
    
    @Override
    public void processProxyMessage(boolean messageIsRequest, IInterceptedProxyMessage message) {
        if (messageIsRequest) {
            IHttpRequestResponse messageInfo = message.getMessageInfo();
            IRequestInfo reqInfo = helpers.analyzeRequest(messageInfo);
            String URL = new String(reqInfo.getUrl().toString());
            List headers = reqInfo.getHeaders();
            
            //if(this._host.contains(get_host(URL))) {
            if(URL.contains(this._host)) {
                
                if(this._is_req_body) {
                    // decrypting request body
                    String tmpreq = new String(messageInfo.getRequest());
                    String messageBody = new String(tmpreq.substring(reqInfo.getBodyOffset())).trim();
                    String decValue = this.do_decrypt(messageBody);
                    headers.add(new String(this._Header));
                    byte[] updateMessage = helpers.buildHttpMessage(headers, decValue.getBytes());
                    messageInfo.setRequest(updateMessage);
                    print_output("PPM-req", "Final Decrypted Request\n" + new String(updateMessage));
                }
                else if(this._is_req_param){
                    
                    byte[] _request = messageInfo.getRequest();
                    
                    if(reqInfo.getContentType() == IRequestInfo.CONTENT_TYPE_JSON){
                        _request = update_req_params_json(_request, headers, this._req_param ,false);
                    }
                    else{
                        _request = update_req_params(_request, headers, this._req_param, false);                        
                    }
                    print_output("PPM-req", "Final Decrypted Request\n" + new String(_request));
                    messageInfo.setRequest(_request);
                    
                }
                else {
                    return;
                }
                
            }
        }
        else {
            if(this._ignore_response) { return; }
            // PPM Response
            
            IHttpRequestResponse messageInfo = message.getMessageInfo();
            IRequestInfo reqInfo = helpers.analyzeRequest(messageInfo);
            IResponseInfo resInfo = helpers.analyzeResponse(messageInfo.getResponse());
            String URL = new String(reqInfo.getUrl().toString());
            List headers = resInfo.getHeaders();
            
            //if(this._host.contains(this.get_host(URL))){
            if(URL.contains(this._host)) {
                
                if(!headers.contains(this._Header)){ return; }
                
                if(this._is_res_body){
                    // Complete Response Body encryption
                    String tmpreq = new String(messageInfo.getResponse());
                    String messageBody = new String(tmpreq.substring(resInfo.getBodyOffset())).trim();
                    messageBody = do_encrypt(messageBody);
                    byte[] updateMessage = helpers.buildHttpMessage(headers, messageBody.getBytes());
                    messageInfo.setResponse(updateMessage);
                    print_output("PPM-res", "Final Encrypted Response\n" + new String(updateMessage));
                }
                else if(this._is_ovrr_res_body){
                    String tmpreq = new String(messageInfo.getResponse());
                    String messageBody = new String(tmpreq.substring(resInfo.getBodyOffset())).trim();
                    messageBody = do_encrypt(messageBody);
                    
                    if(this._is_ovrr_res_body_form){
                        messageBody = this._req_param[0] + "=" + messageBody;
                    }
                    else if(this._is_ovrr_res_body_json){
                        messageBody = "{\"" + this._req_param[0] + "\":\"" + messageBody + "\"}";
                    }
                    
                    byte[] updateMessage = helpers.buildHttpMessage(headers, messageBody.getBytes());
                    messageInfo.setResponse(updateMessage);
                    print_output("PPM-res", "Final Encrypted Response\n" + new String(updateMessage));
                }
                else if(this._is_res_param){
                    // implement left --------------------------
                    byte[] _response = messageInfo.getResponse();
                    
                    _response = this.update_req_params_json(_response, headers, this._res_param, true);
                    messageInfo.setResponse(_response);
                    print_output("PHTM-res", "Final Decrypted Response\n" + new String(_response));
                    
                }
                else{
                    return;
                }
            
            }
        }
    }

    @Override
    public void processHttpMessage(int toolFlag, boolean messageIsRequest, IHttpRequestResponse messageInfo) {
        if (messageIsRequest) {
            IRequestInfo reqInfo = helpers.analyzeRequest(messageInfo);
            String URL = new String(reqInfo.getUrl().toString());
            List headers = reqInfo.getHeaders();
            
            if(!headers.contains(this._Header)){ return; }
            
            //if(this._host.contains(get_host(URL))){
            if(URL.contains(this._host)) {
                if(this._is_req_body) {
                    String tmpreq = new String(messageInfo.getRequest());
                    String messageBody = new String(tmpreq.substring(reqInfo.getBodyOffset())).trim();
                    messageBody = this.do_encrypt(messageBody);
                    byte[] updateMessage = helpers.buildHttpMessage(headers, messageBody.getBytes());
                    messageInfo.setRequest(updateMessage);
                    print_output("PHTM-req", "Final Encrypted Request\n" + new String(updateMessage));
                }
                else if(this._is_ovrr_req_body){
                    String tmpreq = new String(messageInfo.getRequest());
                    String messageBody = new String(tmpreq.substring(reqInfo.getBodyOffset())).trim();
                    messageBody = this.do_encrypt(messageBody);
                    
                    if(this._is_ovrr_req_body_form){
                        messageBody = this._req_param[0] + "=" + messageBody;
                    }
                    else if(this._is_ovrr_req_body_json){
                        messageBody = "{\"" + this._req_param[0] + "\":\"" + messageBody + "\"}";
                    }
                    
                    byte[] updateMessage = helpers.buildHttpMessage(headers, messageBody.getBytes());
                    messageInfo.setRequest(updateMessage);
                    print_output("PHTM-req", "Final Encrypted Request\n" + new String(updateMessage));
                }
                else if(this._is_req_param){
                    
                    byte[] _request = messageInfo.getRequest();
                    
                    if(reqInfo.getContentType() == IRequestInfo.CONTENT_TYPE_JSON){
                        _request = update_req_params_json(_request, headers, this._req_param, true);
                    }
                    else{
                        _request = update_req_params(_request, headers, this._req_param, true);                        
                    }
                    print_output("PHTM-req", "Final Encrypted Request\n" + new String(_request));
                    messageInfo.setRequest(_request);
                }
                else {
                    return;
                }
            }
            
            
        }
        else {
            if(this._ignore_response) { return; }
            
            // PHTM Response
            IRequestInfo reqInfo = helpers.analyzeRequest(messageInfo);
            IResponseInfo resInfo = helpers.analyzeResponse(messageInfo.getResponse());
            String URL = new String(reqInfo.getUrl().toString());
            List headers = resInfo.getHeaders();
            
            
            //if(this._host.contains(this.get_host(URL))){
            if(URL.contains(this._host)) {
                
                if(this._is_res_body){
                    // Complete Response Body decryption
                    String tmpreq = new String(messageInfo.getResponse());
                    String messageBody = new String(tmpreq.substring(resInfo.getBodyOffset())).trim();
                    messageBody = do_decrypt(messageBody);
                    headers.add(this._Header);
                    byte[] updateMessage = helpers.buildHttpMessage(headers, messageBody.getBytes());
                    messageInfo.setResponse(updateMessage);
                    print_output("PHTM-res", "Final Decrypted Response\n" + new String(updateMessage));
                }
                else if(this._is_res_param){
                    // implement left --------------------------
                    byte[] _response = messageInfo.getResponse();
                    
                    _response = this.update_req_params_json(_response, headers, this._res_param, false);
                    messageInfo.setResponse(_response);
                    print_output("PHTM-res", "Final Decrypted Response\n" + new String(_response));
                }
                else{
                    return;
                }
                
            }
            
            
        }
    }

    @Override
    public IMessageEditorTab createNewInstance(IMessageEditorController controller, boolean editable)
    {
        // create a new instance of our custom editor tab
        return new AESDecoderTab(controller, editable, this._is_req_body, this._is_req_param, this._req_param);
    }

    class AESDecoderTab implements IMessageEditorTab
    {
        private boolean editable;


        private ITextEditor txtInput;
        private byte[] currentMessage;

        public AESDecoderTab(IMessageEditorController controller, boolean editable, boolean is_req_body,
                              boolean is_req_param, String[] req_param)
        {
            this.editable = editable;

            // create an instance of Burp's text editor, to display our deserialized data
            txtInput = callbacks.createTextEditor();
            txtInput.setEditable(editable);
        }

        //
            // implement IMessageEditorTab
        //

        @Override
        public String getTabCaption()
        {
            return "AESKiller Decoder";
        }

        @Override
        public Component getUiComponent()
        {
            return txtInput.getComponent();
        }

        @Override
        public boolean isEnabled(byte[] content, boolean isRequest)
        {
            // enable this tab for requests
            if (BurpExtender.this._req_tab) {
                   return true;
                }
            return false;
        }

        @Override
        public void setMessage(byte[] content, boolean isRequest)
        {
            if (content == null)
            {
                // clear our display
                txtInput.setText(null);
                txtInput.setEditable(false);
            }
            else {
                if (isRequest && BurpExtender.this._req_tab ) {
                    IRequestInfo reqInfo = helpers.analyzeRequest(content);
                    String URL = "";
                    List headers = reqInfo.getHeaders();
                    String[] tmp =  reqInfo.getHeaders().get(1).split(" ");
                    if (tmp.length >1 ){
                        URL = reqInfo.getHeaders().get(1).split(" ")[1];
                    }
                    if (URL.contains(_host)) {
                        //if ((Base64InputTab)this.this$0._is_req_body) {
                        if (BurpExtender.this._is_req_body) {
                            // decrypting request body
                            String tmpreq = content.toString();
                            String messageBody = new String(tmpreq.substring(reqInfo.getBodyOffset())).trim();
                            String decValue = do_decrypt(messageBody);
                            txtInput.setText(decValue.getBytes());
                            txtInput.setEditable(editable);
                        } else if (BurpExtender.this._is_req_param) {
                            byte[] _request = content;
                            if (reqInfo.getContentType() == IRequestInfo.CONTENT_TYPE_JSON) {
                                _request = update_req_params_json(_request, headers, BurpExtender.this._req_param, false);
                            } else {
                                _request = update_req_params(_request, headers, BurpExtender.this._req_param, false);
                            }
                            txtInput.setText(_request);
                            txtInput.setEditable(editable);
                        } else {
                            return;
                        }

                    }


                }
                if (!isRequest && BurpExtender.this._req_tab ) {
                    IResponseInfo respInfo = helpers.analyzeResponse(content);
                    List headers = respInfo.getHeaders();
                    if (BurpExtender.this._is_req_body) {
                        // decrypting response body
                        String tmpreq = content.toString();
                        String messageBody = new String(tmpreq.substring(respInfo.getBodyOffset())).trim();
                        String decValue = do_decrypt(messageBody);
                        txtInput.setText(decValue.getBytes());
                        txtInput.setEditable(editable);
                    } else if (BurpExtender.this._is_req_param) {
                        byte[] _request = content;

                        if (respInfo.getStatedMimeType().contains("JSON")) {
                            _request = update_req_params_json(_request, headers, BurpExtender.this._res_param, false);
                        } else {
                            _request = update_req_params(_request, headers, BurpExtender.this._res_param, false);
                        }
                        txtInput.setText(_request);
                        txtInput.setEditable(editable);
                    } else {
                        return;
                    }
                }
            }

        }

        @Override
        public byte[] getMessage()
        {
            return null;
        }

        @Override
        public boolean isModified()
        {
            return txtInput.isTextModified();
        }

        @Override
        public byte[] getSelectedData()
        {
            return txtInput.getSelectedText();
        }
    }


}
