package br.com.leavecargo.customer.utils

import org.springframework.security.crypto.bcrypt.BCrypt
import java.security.SecureRandom

object HashUtils {

    @JvmStatic
    fun encryptPassword(prefix: String, password: String): String =
        encrypt(password, createSalt(prefix))

    @JvmStatic
    fun checkEncryptedString(encryptedStr: String, hash: String) =
        BCrypt.checkpw(encryptedStr, hash)

    private fun encrypt(strToEncrypt: String, salt: String): String =
        BCrypt.hashpw(strToEncrypt, salt)

    private fun createSalt(prefix: String): String =
        BCrypt.gensalt("\$2a$prefix", 11, SecureRandom())

}
