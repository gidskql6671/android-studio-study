package com.ass

class User(var name: String) {
    var email = "test@test.com"

    constructor(name: String, email: String): this(name) {
        this.email = email
    }

}