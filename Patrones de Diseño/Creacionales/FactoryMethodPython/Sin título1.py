# -*- coding: utf-8 -*-
"""
Created on Thu May 14 15:15:27 2020

@author: ASUS
"""

from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP
import binascii

keyPair = RSA.generate(1024)

pubKey = keyPair.publickey()

print(f"Public key:  (n={hex(pubKey.n)}, e={hex(pubKey.e)})")
pubKeyPEM = pubKey.exportKey()
print(pubKeyPEM.decode('ascii'))

print(f"Private key: (n={hex(pubKey.n)}, d={hex(keyPair.d)})")
privKeyPEM = keyPair.exportKey()
print(privKeyPEM.decode('ascii'))

msg = b'A message for encryption'
encryptor = PKCS1_OAEP.new(pubKey)
encrypted = encryptor.encrypt(msg)
print("Encrypted:", binascii.hexlify(encrypted))

decryptor = PKCS1_OAEP.new(keyPair)
decrypted = decryptor.decrypt(encrypted)
print('Decrypted:', decrypted)


msg2 = b'Mensaje a encriptar 2'
encryptor2 = PKCS1_OAEP.new(pubKey)
encrypted2 = encryptor2.encrypt(msg2)
print("Encrypted:", binascii.hexlify(encrypted2))

decryptor2 = PKCS1_OAEP.new(keyPair)
decrypted2 = decryptor2.decrypt(encrypted2)
print('Decrypted2:', decrypted2)

