# AES Killer (Burpsuite Plugin)
[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)](https://github.com/ellerbrock/open-source-badge/)
[![GitHub version](https://d25lcipzij17d.cloudfront.net/badge.svg?id=gh&type=0.2&v=2.0&x2=0)](http://badge.fury.io/gh/boennemann%2Fbadges)
[![Open Source Love](https://badges.frapsoft.com/os/mit/mit.svg?v=102)](https://github.com/ellerbrock/open-source-badge/)

**Burpsuite Plugin to decrypt AES Encrypted mobile app traffic**

<img src="https://i.imgur.com/qjUqRW5.png" />

### Requirements
- Burpsuite
- Java

### Tested on
- Burpsuite 1.7.36
- Windows 10
- xubuntu 18.04
- Kali Linux 2018

### What it does
- Decrypt AES Encrypted traffic on proxy tab 
- Decrypt AES Encrypted traffic on proxy, scanner, repeater and intruder

***NOTE:*** Currently support `AES/CBC/PKCS5Padding` encryption/decryption.

### How it works
- Require AES Encryption Key (Can be obtained by using frida or reversing mobile app)
- Require AES Encryption Initialize Vector (Can be obtained by using frida or reversing mobile app)
- Request Parameter (Leave blank in case of whole request body)
- Response Parameter (Leave blank in case of whole response body)
- Character Separated with space for obfuscation on request/response 
- URL/Host of target to filter request and response

### How to Install
<pre>Download jar file from <a href="https://github.com/Ebryx/AES-Killer/releases/download/3.0/AES_Killer.jar" target="_blank">Release</a> and add in burpsuite</pre>

<img src="https://i.imgur.com/tAsxDnx.gif" />

### Original Request/Response
<img src="https://i.imgur.com/FY18Toe.png" />

### Decrypted Request/Response
<img src="https://i.imgur.com/c9xSclU.png" />

