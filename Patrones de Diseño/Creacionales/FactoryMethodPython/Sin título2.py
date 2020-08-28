# -*- coding: utf-8 -*-
"""
Created on Thu May 14 15:23:22 2020

@author: ASUS
"""

import rsa
import base64

# Private key decryption
def fun1():
    publicKey, privateKey = rsa.newkeys(512)
    cipher = rsa.encrypt(b'Hello World!', publicKey)
    base64Text = base64.b64encode(cipher).decode()

    print(base64Text)

    text = rsa.decrypt(base64.b64decode(base64Text.encode()), privateKey)
    print(text.decode())

# Public key decryption
def fun2():
    publicKey, privateKey = rsa.newkeys(512)
    cipher = rsa.encrypt(b'Hello World!', privateKey)
    base64Text = base64.b64encode(cipher).decode()

    print(base64Text)

    text = rsa.decrypt(base64.b64decode(base64Text.encode()), publicKey) # AttributeError: 'PublicKey' object has no attribute 'blinded_decrypt'
    print(text.decode())


fun1() # success
fun2() # fail