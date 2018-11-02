# AES Killer (Burpsuite Plugin)
[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)](https://github.com/ellerbrock/open-source-badge/)
[![GitHub version](https://d25lcipzij17d.cloudfront.net/badge.svg?id=gh&type=0.3&v=3.0&x2=0)](http://badge.fury.io/gh/boennemann%2Fbadges)
[![Open Source Love](https://badges.frapsoft.com/os/mit/mit.svg?v=102)](https://github.com/ellerbrock/open-source-badge/)

**Burpsuite Plugin to decrypt AES Encrypted traffic on fly**

<img src="https://i.imgur.com/7IQbJaz.png" />

### Requirements
- Burpsuite
- Java

### Tested on
- Burpsuite 1.7.36
- Windows 10
- xubuntu 18.04
- Kali Linux 2018

### What it does
- The IProxyListener decrypt requests and encrypt responses, and an IHttpListener than encrypt requests and decrypt responses. 
- Burp sees the decrypted traffic, including Repeater, Intruder and Scanner, but the client/mobile app and server see the encrypted version.

***NOTE:*** Currently support `AES/CBC/PKCS5Padding` encryption/decryption.

### How it works
- Require AES Encryption Key (Can be obtained by using <a href="https://gist.github.com/d3vilbug/41deacfe52a476d68d6f21587c5f531d" target="_blank">frida script</a> or reversing mobile app)
- Require AES Encryption Initialize Vector (Can be obtained by using<a href="https://gist.github.com/d3vilbug/41deacfe52a476d68d6f21587c5f531d" target="_blank">frida script</a> or reversing mobile app)
- Request Parameter (Leave blank in case of whole request body)
- Response Parameter (Leave blank in case of whole response body)
- Character Separated with space for obfuscation on request/response (In case of Offuscation) 
- URL/Host of target to decrypt/encrypt request and response

### How to Install
<pre>Download jar file from <a href="https://github.com/Ebryx/AES-Killer/releases/download/3.0/AES_Killer.jar" target="_blank">Release</a> and add in burpsuite</pre>

<img src="https://i.imgur.com/6DS04gb.gif" />

### Original Request/Response
<img src="https://i.imgur.com/ocznHPa.gif" />

### Getting AES Encryption Key and IV
- First setup frida server on <a href="https://www.frida.re/docs/ios/" target="_blank">IOS</a> and <a href="https://www.frida.re/docs/android/" target="_blank">Android</a> device.
- Launch Application on mobile device.
- Run this <a href="https://gist.github.com/d3vilbug/41deacfe52a476d68d6f21587c5f531d" target="_blank">frida script</a> on your host machine to get AES Encryption Key and IV.

<img src="https://i.imgur.com/NOLlQcy.gif" />

### Decrypt Request/Response
- Provide SecretSpecKey under `Secret Key` field
- Procide IV under `Initialize Vector` field
- Provide Host/URL to filter request and response for encryption and decryption
- Press `Start AES Killer`

<img src="https://i.imgur.com/Eyukxhs.gif" />

<pre>Download Demo App from <a href="https://github.com/11x256/frida-android-examples/blob/master/examples/5/app-release.apk" target="_blank">here</a></pre>
