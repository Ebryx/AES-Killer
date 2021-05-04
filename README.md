# AES Killer (Burpsuite Plugin)
[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)](https://github.com/ellerbrock/open-source-badge/)
[![GitHub version](https://d25lcipzij17d.cloudfront.net/badge.svg?id=gh&type=0.3&v=3.0&x2=0)](http://badge.fury.io/gh/boennemann%2Fbadges)
[![Open Source Love](https://badges.frapsoft.com/os/mit/mit.svg?v=102)](https://github.com/ellerbrock/open-source-badge/)

**Burpsuite Plugin to decrypt AES Encrypted traffic on the fly**

<img src="https://i.imgur.com/LKYQMoj.png" />

### Requirements
- Burpsuite

### Tested on
- Burpsuite 2021.4
- Windows 10 
- Ubuntu & PopOS

### What it does
- The IProxyListener decrypt requests and encrypt responses, and an IHttpListener than encrypt requests and decrypt responses. 
- Burp sees the decrypted traffic, including Repeater, Intruder and Scanner, but the client/mobile app and server see the encrypted version.

***NOTE:*** Currently support `AES/CBC/PKCS5Padding` && `AES/ECB/PKCS5Padding` encryption/decryption.

### How it works
- Require **Secret Key** and **Initialize Vector** which can be obtained by using <a href="https://github.com/d3vilbug/demo-example-code-snippets/blob/master/AES_Killer%20-%20Mobile%20App%20Demo/aes-hook.js" target="_blank">aes-hook.js</a> and <a href="https://github.com/d3vilbug/demo-example-code-snippets/blob/master/AES_Killer%20-%20Mobile%20App%20Demo/frida-hook.py" target=_blank>frida-hook.py</a> or by reversing the application
- A detailed usage guide can be found at <a href="https://n00b.sh/posts/aes_killer-usage-guide/" target=_blank>AES Killer - Usage Guide</a>
- This article will help you in <a href="https://n00b.sh/posts/aes-killer-mobile-app-demo/" target=_blank>Decrypting Mobile App Traffic using AES Killer and Frida</a>

### How to Build 
```
$ git clone https://github.com/Ebryx/AES-Killer/
$ cd AES-Killer
$ ./gradlew clean build
```

## Variants
- AES_Killer for JSON request <a href="https://gist.github.com/d3vilbug/853d6823a015cfe20656bd24ad8dd410" target="_blank">AES_Killer-JSON.java</a>
- AES_Killer for random/alternate Parameters on different endpoints <a href="https://gist.github.com/d3vilbug/391cc26b27de37e49f5e75682f65ed5b" target="_blank">AES_Killer-Parameters.java</a>

***AES_Killer-Parameters.java:*** Let's say if application enforcing encryption on few parameters in request and these parameters will change every time with respect to  endpoint/request so all you need to do is as follow
<pre>
- Add endpoints by adding <code><bold>this.endpoints.add("abc");</bold></code> in registerExtenderCallbacks function
- Add parameters which will be encrypted in `String[][] parameters`
- Add rest of parameter in grant_type or make blank entry
</pre>
and let the code do the magic for you.

- AES_Killer_v3.0 a generic variant for alternate parameters on different endpoints with GET, POST (JSON, Form) support <a href="https://gist.github.com/d3vilbug/0a55139c24b183b36dd1d4e9fa2658e0" target="_blank">AES_Killer_v3.0.java</a>

***AES_Killer_v3.0.java:*** This variant is generic and can deal with any type of request format i-e GET, POST(Form, JSON) with alternate parameters on different endpoints
<pre>
- Clone the project and replace the BurpExtender.java with AES_Killer_v3.0.java code
- Modify the endpoints and parameters of each request type in order as shown below
- Update SecretKey and IV parameters and other required methods
- Build the project and you are good to go
</pre>

<img src="https://i.imgur.com/1mpZeEg.png" />


- <a href="https://gist.github.com/d3vilbug/0225423e124605f9eb58d439fcc50234" target="_blank">AES_Killer_v4.0.java</a> for multi-level encryption on request _(Support Form, JSON and XML formats)_

***AES_Killer_v4.0.java:*** This variant is for Multi-Level encryption where application is encrypting few request parameters with one key and later on encrypting the whole request body with another key
<pre>
- Clone the project and replace the BurpExtender.java with AES_Killer_v4.0.java code
- Modify the endpoints and parameters as shown below
- Update Secret Keys and other required methods
- Build the project and add jar file to your extender
</pre>

<img src="https://i.imgur.com/JVDhKLX.png" />

***NOTE:*** These variants will not work for you directly due to nature of your request so might need little tweaking.

### How to Install
<pre>Download jar file from <a href="https://github.com/Ebryx/AES-Killer/releases/download/3.0/AES_Killer.jar" target="_blank">Release</a> and add in burpsuite</pre>

<img src="https://i.imgur.com/6DS04gb.gif" />

### Original Request/Response
<img src="https://i.imgur.com/pr8uLv8.gif" />

### Getting AES Encryption Key and IV
- First setup frida server on <a href="https://www.frida.re/docs/ios/" target="_blank">IOS</a> and <a href="https://www.frida.re/docs/android/" target="_blank">Android</a> device.
- Launch Application on mobile device.
- Run <a href="https://github.com/d3vilbug/demo-example-code-snippets/blob/master/AES_Killer%20-%20Mobile%20App%20Demo/aes-hook.js" target="_blank">aes-hook.js</a> and <a href="https://github.com/d3vilbug/demo-example-code-snippets/blob/master/AES_Killer%20-%20Mobile%20App%20Demo/frida-hook.py" target=_blank>frida-hook.py</a> on your host machine to get AES Encryption Key and IV as shown in <a href="https://n00b.sh/posts/aes-killer-mobile-app-demo/" target=_blank>this post</a>.

<img src="https://i.imgur.com/Bwi17Bb.gif" />

### Decrypt Request and Response
- Provide SecretSpecKey under `Secret Key` field
- Provide IV under `Initialize Vector` field
- Provide Host/URL to filter request and response for encryption and decryption
- Select appropriate Request and Response options
- Press `Start AES Killer`

<img src="https://i.imgur.com/JfrH65u.gif" />


### AES Killer with Repeater, Intruder and Scanner
Once we start AES Killer, it takes control of Burp `IHttpListener.processHttpMessage` which is responsible for handling all outgoing and incoming traffic and AES Killer do the following

- Before sending the final request to a server, `ProcessHttpMessage` encrypt the request 
- Upon receiving a response,  `ProcessHttpMessage` decrypt the response first before showing it to us

So we'll only be getting the Plain Text Response and can play with Plain Text request.

<img src="https://i.imgur.com/MVhBHcS.gif">



### Manual Encryption and Decryption 
We can also manually encrypt and decrypt strings using AES Killer. Let's take an encrypted string from the request `TYROd49FWJjYBfv02oiUzwRQgxWMWiw4W3oCqvNf8h3bnb7X0bobypFzMt797CYU` and decrypt it using AES Killer. Similarly, we can perform the encryption too.

<img src="https://i.imgur.com/rjWDACt.gif">


<pre>Download Demo App from <a href="https://github.com/11x256/frida-android-examples/blob/master/examples/5/app-release.apk" target="_blank">here</a></pre>
