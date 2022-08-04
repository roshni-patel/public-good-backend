package com.walmart.platform.common;

import java.io.ObjectStreamException;
import java.security.KeyRep;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.codec.binary.Base64;

public class SignatureGenerator {

    public static void main(String[] args) {
        SignatureGenerator generator = new SignatureGenerator();

        String consumerId = "65103062-2bdb-44e4-a037-3d4ccbba4d7c";
        String privateKeyVersion = "1";
        String key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQDwEGM4opcLWpb7"+
        "cME+sZhgp5XEItob3Q0JAkUjXMIht+JbTkZZs4oTquMIO4GZv6qct2gpVpcFDmDX"+
        "rrGicdOemB8pjLTaR8uiY3xvtCmm4f44WzVMysbXXGR01d4qlGJQTPrxSlEb+tvj"+
        "N1vVHzvvvy51nuglOryWc3VLrcbI3v99Yo4RCB0bwsSpmIO7vBM/FBvzDsPy+Co4"+
        "5ka5Vra/xSA0FCD+pa9NOB5D43qtpqEs0CY0FWRS922NuKI8ztuyByK7JCHI6FDZ"+
        "eyOfEye6/rC5q91Txyh3f8yN1d737XY70P0p4feajw4qcP4cbTwu7B2a9tHiuCS5"+
        "ss00IqNLAgMBAAECggEBAIwG0wlO9VGfFqA1hdKe3qXKOrZ8KcLE7nyJwXA+A9KN"+
        "ItBlWO2rpueP7vt3UkIvJUJiTLSIGHDPkTddY6nAQVKposumkjscU7A13Xh+mykH"+
        "ezS+JtnTEaa+8q2frgYiJTJ3pIwn8CWk7qubN8qZfGl8l4nuFbTZjPUpBYsOIvw4"+
        "zYBZCLOs/iqq8Maqn7hdmHHMlYkt7YYqD6ExtCy4o+hsOkfAPq0wa4VC4C208FXw"+
        "lqhqNXWhWtEGIJat4DnkS8p1VIoA/c+Wukt4QvelR6S+LTgTSQpu4Vv8EyzF4uO2"+
        "LM5Uyv/ucvLq1lqBw0lNbWLF1bnb6HXoynmVvpCr0GkCgYEA/amyKkbcNAl8RfgR"+
        "AjDAz9kfHVDtNrDeOFYBQKJW1fOMzfbQmP6+eVoFHV3gJQZBXSmgTKG5uMoYZ/sZ"+
        "o/WjvIddD/utbdduQ+Pzuyr61f2FG9TZnoSRGNzqFX+m/4WrMT4jCzvX+oQgBMeX"+
        "sl/8KAEjUKWCM/a3TzfSunNE7e8CgYEA8kad1tflODyqZuweBYR9elRsq+3Qy+7s"+
        "Nqr13SYz3IgLmFXTA8thFOxfXEQoCHCu05DaSrxm7l+NVGOc5B8odWIllvfQY2Bd"+
        "t5K2n97VkDOOBUdJxsOITKxXiKrcpQabVX7Iplnm55oKmjWqGsgi5TS1GhTmTpQ4"+
        "LJIFF6VffGUCgYEA25I9p7zItb6UNRjC2EuNSx1dgonfnBzDbq57zQ/47KAyfMKt"+
        "1BGGnRKgJMhy0nm0sMjsegjv85X0RGWlzzg88F+X3dL0T4VQbDHwc06D7CHUS8AW"+
        "U9Haq1PmyI9D5iE1i52Gxh2aGb6u3JRMqlnNsm8xu4hYyVRBXrAql7xZqT8CgYEA"+
        "r/le2BhEpA5cbxl9zOApC9uae17nU9kctbCDmLgQ31PpqCJefNkSkNIHicrvkQHX"+
        "2k/SXopt8SJyUyNvZ7rB9lDtoLQrJqNuLtJf18tRL8Zil67qBXcs3xQnGFuSnEMq"+
        "PHU0ZK/UKdEXdl8YSQ+pWPZpvKIFjnnWO3lsPXqe2okCgYEAnTZTMhqrsLcTQcLu"+
        "QRkvtpK1s3wkWxC8XI7s0Jb5RpFjBXeCVvjNqnfEacL5uSp2a7lhH+iAID7aCb6s"+
        "3VqDqOP5nuqhgA9OfmLpeK5mJ426MH7sLzanjgGsNYHo9WK03psCGn/xyhF7j+wg"+
        "xIoBuJvwyP7NJ2Wp4FO/EOMIAS0=";

        long intimestamp = System.currentTimeMillis();

        System.out.println("consumerId: " + consumerId);
        System.out.println("intimestamp: " + intimestamp);

        Map<String, String> map = new HashMap<>();
        map.put("WM_CONSUMER.ID", consumerId);
        map.put("WM_CONSUMER.INTIMESTAMP", Long.toString(intimestamp));
        map.put("WM_SEC.KEY_VERSION", privateKeyVersion);

        String[] array = canonicalize(map);

        String data = null;

        try {
            data = generator.generateSignature(key, array[1]);
        } catch(Exception e) { }
        System.out.println("Signature: " + data);
    }

    public String generateSignature(String key, String stringToSign) throws Exception {
        Signature signatureInstance = Signature.getInstance("SHA256WithRSA");

        ServiceKeyRep keyRep = new ServiceKeyRep(KeyRep.Type.PRIVATE, "RSA", "PKCS#8", Base64.decodeBase64(key));

        PrivateKey resolvedPrivateKey = (PrivateKey) keyRep.readResolve();

        signatureInstance.initSign(resolvedPrivateKey);

        byte[] bytesToSign = stringToSign.getBytes("UTF-8");
        signatureInstance.update(bytesToSign);
        byte[] signatureBytes = signatureInstance.sign();

        // byte[] signatureString = signatureBytes;
        String signatureString = Base64.encodeBase64String(signatureBytes);

        return signatureString;
    }
    protected static String[] canonicalize(Map<String, String> headersToSign) {
        StringBuffer canonicalizedStrBuffer=new StringBuffer();
        StringBuffer parameterNamesBuffer=new StringBuffer();
        Set<String> keySet=headersToSign.keySet();

        // Create sorted key set to enforce order on the key names
        SortedSet<String> sortedKeySet=new TreeSet<String>(keySet);
        for (String key :sortedKeySet) {
            Object val=headersToSign.get(key);
            parameterNamesBuffer.append(key.trim()).append(";");
            canonicalizedStrBuffer.append(val.toString().trim()).append("\n");
        }
        return new String[] {parameterNamesBuffer.toString(), canonicalizedStrBuffer.toString()};
    }

    class ServiceKeyRep extends KeyRep  {
        private static final long serialVersionUID = -7213340660431987616L;
        public ServiceKeyRep(Type type, String algorithm, String format, byte[] encoded) {
            super(type, algorithm, format, encoded);
        }
        protected Object readResolve() throws ObjectStreamException {
            return super.readResolve();
        }
    }
}