package burp;
import java.awt.Component;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class BurpExtender implements IBurpExtender, ITab, IProxyListener, IHttpListener
{
    public String ExtensionName =  "AES Killer";
    public String TabName = "AES Killer";
    
    public IBurpExtenderCallbacks callbacks;
    public IExtensionHelpers helpers;
    public PrintWriter stdout;
    public PrintWriter stderr;
    
    public MainPanel myPanel;
    
    public Cipher cipher;
    public IvParameterSpec iv_param;
    public SecretKey sec_key;
    public String reqURL = null;
    public String reqParameter = null;
    public String resPrarameter = null;
    public Boolean decResponse = false;
    public Boolean isOffusicated = false;
    public String[] offusicatedChar = null;
    public String[] replaceWithChar = null;
    
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks)
    {
        this.callbacks = callbacks;
        this.helpers = callbacks.getHelpers();
        stdout = new PrintWriter(callbacks.getStdout(), true);
        this.callbacks.setExtensionName(this.ExtensionName);
        
        myPanel = new MainPanel(this);
        this.callbacks.addSuiteTab(this);
        this.stdout.println("AES Killer Installed");
    }

    @Override
    public String getTabCaption() {
        return this.TabName;
    }

    @Override
    public Component getUiComponent() {
        return this.myPanel;
    }

    public String doEncrypt(String paramString, Boolean doOffFlag){
        try{
            String temp_params = paramString;
            cipher.init(1, sec_key ,iv_param);
            temp_params = new String (Base64.getEncoder().encodeToString(cipher.doFinal(temp_params.getBytes())));
            if(doOffFlag && this.isOffusicated){temp_params = this.doOff(temp_params);}
            return temp_params;
        }catch(Exception ex){
            return paramString;
        }
    }
        
    public String doDecrypt(String paramString){
        try{
            String temp_params = paramString;
            cipher.init(2, sec_key ,iv_param);
            if(this.isOffusicated){
                temp_params = this.removeNull(temp_params);
                temp_params = this.removeOff(temp_params);
            }
            temp_params = new String (cipher.doFinal(Base64.getDecoder().decode(temp_params)));
            return temp_params;
        }catch(Exception ex){
            return paramString;
        }
    }
    
    public String removeNull(String paramString){
        if (paramString != null) {
          return paramString.replace("%0A", "").replace("%2C","");
        }
        return paramString;
    }
    
    public String removeOff(String paramString)
    {
        if (paramString != null) {
          for(int i =0; i< this.offusicatedChar.length; i++){
              paramString = paramString.replace(this.replaceWithChar[i], this.offusicatedChar[i]);
          }
          return paramString;
        }
        return paramString;
    }
    
    public String doOff(String paramString)
    {
        if (paramString != null) {
          for(int i =0; i< this.offusicatedChar.length; i++){
              paramString = paramString.replace(this.offusicatedChar[i], this.replaceWithChar[i]);
          }
          return paramString;
        }
        return paramString;
    }
    
    @Override
    public void processProxyMessage(boolean messageIsRequest, IInterceptedProxyMessage message) {
        if (messageIsRequest){
            IHttpRequestResponse messageInfo = message.getMessageInfo();
            IRequestInfo reqInfo = helpers.analyzeRequest(messageInfo);
            List headers = reqInfo.getHeaders();
            String request = new String(messageInfo.getRequest());
            String URL = new String(reqInfo.getUrl().toString());
            if (URL.contains(this.reqURL) && reqInfo.getMethod().toLowerCase().contains("post")){
                if(reqInfo.getParameters().size() > 2){ return; }
                String messageBody = new String(request.substring(reqInfo.getBodyOffset())).trim();
//                this.stdout.println("PPM :: request :: " + messageBody);
                if ( !this.reqParameter.equals("") && messageBody.startsWith(this.reqParameter)){
                    String arr[] = messageBody.split(this.reqParameter);
                    messageBody = arr[1].substring(0, arr[1].length()-1);
                }
                
                try{
                    messageBody = doDecrypt(messageBody);
//                    this.stdout.println("PPM :: dec --> request :: " + messageBody);
                    byte[] updateMessage = helpers.buildHttpMessage(headers, messageBody.getBytes());
                    messageInfo.setRequest(updateMessage);
                }catch(Exception ex){
                    stdout.println( messageBody + " :: Exception Here :: processProxyMessage request \n --> " + ex + "\n\n");
                }
                
            }
            
        }
        else {
            
            if (this.decResponse != true){
                return;
            }
            IHttpRequestResponse messageInfo = message.getMessageInfo();
            IRequestInfo reqInfo = helpers.analyzeRequest(messageInfo);
            String URL = new String(reqInfo.getUrl().toString());
            if (URL.contains(this.reqURL)  && reqInfo.getMethod().toLowerCase().contains("post")){ 
                IResponseInfo resInfo = helpers.analyzeResponse(messageInfo.getResponse());
                List headers = resInfo.getHeaders(); 
                String response = new String(messageInfo.getResponse());
                String params = new String(response.substring(resInfo.getBodyOffset())).trim();
                try{
//                    this.stdout.println("PPM :: before enc :: " + params);
                    params = doEncrypt(params, false);
                    if ( !this.resPrarameter.equals("")){
                        params = this.resPrarameter + params;
                    }
//                    this.stdout.println("PPM :: after enc :: " + params);
                    byte[] updateMessage = helpers.buildHttpMessage(headers, params.getBytes());
                    messageInfo.setResponse(updateMessage);
                }
                catch (Exception ex) {
                    stdout.println( params + ": Exception Here :: processProxyMessage response \n" + ex + "\n\n");
                }
            }
        }
    }
    
    

    @Override
    public void processHttpMessage(int toolFlag, boolean messageIsRequest, IHttpRequestResponse messageInfo) {
        if (messageIsRequest){
            IRequestInfo reqInfo = helpers.analyzeRequest(messageInfo);
            List headers = reqInfo.getHeaders();
            String request = new String(messageInfo.getRequest());
            String URL = new String(reqInfo.getUrl().toString());
            if (URL.contains(this.reqURL) && reqInfo.getMethod().toLowerCase().contains("post")){
                if(reqInfo.getParameters().size() > 2){ return; }
                String messageBody = request.substring(reqInfo.getBodyOffset()).trim();                
//                this.stdout.println( "PHM :: before enc :: " + messageBody);
                messageBody = doEncrypt(messageBody, true);
                messageBody = "params=" + messageBody;
//                this.stdout.println( "PHM :: after enc :: " + messageBody);
                byte[] updateMessage = helpers.buildHttpMessage(headers, messageBody.getBytes());
                messageInfo.setRequest(updateMessage);
            }
            
        }
        else {
            
            if (this.decResponse != true){
                return;
            }
//            this.stdout.println("----- response -----");
            IRequestInfo reqInfo = helpers.analyzeRequest(messageInfo);
            String URL = new String(reqInfo.getUrl().toString());
            if (URL.contains(this.reqURL) && reqInfo.getMethod().toLowerCase().contains("post")){
                IResponseInfo resInfo = helpers.analyzeResponse(messageInfo.getResponse());
                List headers = resInfo.getHeaders();
                String response = new String(messageInfo.getResponse());
                String params = new String(response.substring(resInfo.getBodyOffset())).trim();
                try{
                    if ( !this.resPrarameter.equals("") && params.startsWith(this.resPrarameter)){
                        String arr[] = params.split(this.resPrarameter);
                        params = arr[1].substring(0, arr[1].length()-1);
                    }
//                    this.stdout.println("PHM :: before dec :: " + params);
                    params = doDecrypt(params);
//                    this.stdout.println("PHM :: after dec :: " + params);
                    byte[] updateMessage = helpers.buildHttpMessage(headers, params.getBytes());
                    messageInfo.setResponse(updateMessage);
                }
                catch (Exception ex) {
                    stdout.println( params.length() + ": Exception Here :: processHttpMessage response");
                }
            }
        }
    }
}
