package com.example.labofinal.configs;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private byte[] secret = "18J+HDf=W-j.zvr<wYT=MAJ5xBSgAH{v8f>`hSJ&+E\\kl$-{D*_?w@!T=b1g,auYzSMzQJ?=3\\s\"a%zEP38k~x,ar+/znd4{HqmfeTLAW=sor\"u,{{H=[a@*mW#knw9D-w`>ORH.{:=|(Q~_=|HWtTH2|kSu32=".getBytes(StandardCharsets.UTF_8);
    public int expireAt = 86_400 * 7; // 7 Day
    public SecretKey secretKey = new SecretKeySpec(secret,"HmacSHA384");
}
