package com.example.beta.exception

import org.springframework.http.HttpStatus

class ClientNotFoundException(val statusCode: HttpStatus, val reason: String) : Exception()
