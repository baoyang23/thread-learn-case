package com.yang.volatilecase;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-10-4
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class Base64CaseOne {

    public static void main(String[] args) {
        final String text = "Please Gavin Gavin a love.";
        final String encode = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));

        System.out.println(encode);

        final String decoder = new String(Base64.getDecoder().decode(encode),StandardCharsets.UTF_8);
        System.out.println(decoder);

    }

}
