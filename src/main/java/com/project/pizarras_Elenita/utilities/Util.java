/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.pizarras_Elenita.utilities;

import java.security.SecureRandom;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author KB
 */
public class Util {

    public static String generateRandomId(String prefix) {
        return prefix
                + RandomStringUtils.random(17, 0, 0, Boolean.TRUE, Boolean.TRUE, null, new SecureRandom());
    }

    private Util() {
    }

}
