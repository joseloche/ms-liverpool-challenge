package com.liverpool.challenge.utils;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

@Component
public class LiverUtils {

	public String encriptar(String texto) {
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, generarClaveSecreta());
			byte[] textoEncriptado = cipher.doFinal(texto.getBytes());
			return Base64.getEncoder().encodeToString(textoEncriptado);
		} catch (Exception ex) {
			throw new RuntimeException("Error al encriptar el texto", ex);
		}
	}

	private SecretKey generarClaveSecreta() throws Exception {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			return keyGenerator.generateKey();
		} catch (Exception ex) {
			throw new Exception("Error al generar la clave secreta", ex);
		}
	}
}
